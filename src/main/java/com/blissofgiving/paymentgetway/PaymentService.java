package com.blissofgiving.paymentgetway;

import com.blissofgiving.exception.BlissofgivingServiceException;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;

public interface PaymentService {
	Payment getStripeUIPayment() throws BlissofgivingServiceException;

	Charge charge(PaymentRequest paymentRequest) throws StripeException;
}
