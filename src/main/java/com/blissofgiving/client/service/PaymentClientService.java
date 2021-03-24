package com.blissofgiving.client.service;

import com.blissofgiving.client.dto.PaymentDTO;
import com.blissofgiving.client.dto.PaymentRequestDTO;
import com.blissofgiving.exception.BlissofgivingClientException;
import com.stripe.model.Charge;

public interface PaymentClientService {
	PaymentDTO getStripeUIPaymentDTO() throws BlissofgivingClientException;

	Charge charge(PaymentRequestDTO paymentRequestDTO) throws BlissofgivingClientException;
}
