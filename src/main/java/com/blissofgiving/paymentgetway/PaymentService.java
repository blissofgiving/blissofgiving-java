package com.blissofgiving.paymentgetway;

import java.util.List;

import com.blissofgiving.dynamodbmodel.BeneficiaryPayment;
import com.blissofgiving.exception.BlissofgivingServiceException;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;

public interface PaymentService {
	Payment getStripeUIPayment() throws BlissofgivingServiceException;

	Charge charge(PaymentRequest paymentRequest) throws StripeException;

	public void saveBeneficiaryCharge(Charge charge, String beneficiarySysGuid) throws BlissofgivingServiceException;

	public List<BeneficiaryPayment> getBeneficiaryPayments(String beneficiarySysGuid) throws BlissofgivingServiceException;
}
