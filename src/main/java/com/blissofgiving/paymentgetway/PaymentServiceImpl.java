package com.blissofgiving.paymentgetway;

import java.util.Currency;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

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
		chargeParams.put("beneficiarySysGuid", paymentRequest.getBeneficiarySysGuid());

		//Set API key
		Stripe.apiKey = STRIPE_SECRET_KEY;

		Charge charge =  Charge.create(chargeParams);

		// Save payment info against beneficiary
		//TODO
		return charge;
	}
}
