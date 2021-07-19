package com.blissofgiving.paymentgetway;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.blissofgiving.dao.PaymentDAO;
import com.blissofgiving.dynamodbmodel.BeneficiaryPayment;
import com.blissofgiving.exception.BlissofgivingServiceException;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;

@Service
public class PaymentServiceImpl implements PaymentService{
	@Value("${stripe.apikey}")
	private String STRIPE_API_KEY;

	@Value("${stripe.secretkey}")
	private String STRIPE_SECRET_KEY;

	@Autowired
	PaymentDAO paymentDAO;

	@Override
	public Payment getStripeUIPayment() throws BlissofgivingServiceException {
		Payment payment = new Payment();
		payment.setAmount(1000);
		payment.setCurrency("USD");
		payment.setStripePublicKey(STRIPE_API_KEY);
		return payment;
	}

	@Override
	public Charge charge(PaymentRequest paymentRequest) throws StripeException {
		Map<String, Object> chargeParams = new HashMap<>();
		chargeParams.put("amount", paymentRequest.getAmount());
		chargeParams.put("currency", paymentRequest.getCurrency() == null || paymentRequest.getCurrency().equals("") ? "USD" : paymentRequest.getCurrency());
		chargeParams.put("description", paymentRequest.getDescription());
		chargeParams.put("source", paymentRequest.getStripeToken());
		//chargeParams.put("beneficiarySysGuid", paymentRequest.getBeneficiarySysGuid());

		//Set API key
		Stripe.apiKey = STRIPE_SECRET_KEY;

		Charge charge =  Charge.create(chargeParams);

		// Save payment info against beneficiary
		saveBeneficiaryCharge(charge, paymentRequest.getBeneficiarySysGuid());

		return charge;
	}

	public void saveBeneficiaryCharge(Charge charge, String beneficiarySysGuid) throws BlissofgivingServiceException {
		BeneficiaryPayment beneficiaryPayment = new BeneficiaryPayment();

		String key = UUID.randomUUID().toString();
		beneficiaryPayment.setBeneficiaryDonationSysGuid(key);
		beneficiaryPayment.setBeneficiarySysGUID(beneficiarySysGuid);
		beneficiaryPayment.setAmount(charge.getAmount());
		beneficiaryPayment.setBillingDetails(charge.getBillingDetails().getPhone()); // TODO saving just phone now as we have Address as object.
		beneficiaryPayment.setCurrency(charge.getCurrency());
		beneficiaryPayment.setInvoice(charge.getInvoice());
		beneficiaryPayment.setDescription(charge.getDescription());
		beneficiaryPayment.setReceiptEmail(charge.getReceiptEmail());
		beneficiaryPayment.setLastUpdateUser(key);

		paymentDAO.saveBeneficiaryCharge(beneficiaryPayment);
	}

	@Override
	public List<BeneficiaryPayment> getBeneficiaryPayments(String beneficiarySysGuid) throws BlissofgivingServiceException {
		List<BeneficiaryPayment> beneficiaryPayments = paymentDAO.getBeneficiaryPayments(beneficiarySysGuid);
		return beneficiaryPayments;
	}
}
