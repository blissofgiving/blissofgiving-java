package com.blissofgiving.client.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blissofgiving.client.dto.PaymentDTO;
import com.blissofgiving.client.dto.PaymentRequestDTO;
import com.blissofgiving.exception.BlissofgivingClientException;
import com.blissofgiving.paymentgetway.Payment;
import com.blissofgiving.paymentgetway.PaymentRequest;
import com.blissofgiving.paymentgetway.PaymentService;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;

@Service
public class PaymentClientServiceImpl implements PaymentClientService{

	@Autowired
	PaymentService paymentService;

	@Override
	public PaymentDTO getStripeUIPaymentDTO() throws BlissofgivingClientException {
		Payment payment = paymentService.getStripeUIPayment();
		PaymentDTO paymentDTO = new PaymentDTO();

		BeanUtils.copyProperties(payment, paymentDTO);
		return paymentDTO;
	}

	@Override
	public Charge charge(PaymentRequestDTO paymentRequestDTO) throws BlissofgivingClientException {
		PaymentRequest paymentRequest = new PaymentRequest();
		BeanUtils.copyProperties(paymentRequestDTO, paymentRequest);
		try {
			Charge charge =  paymentService.charge(paymentRequest);
			return charge;
		} catch (StripeException e) {
			throw new BlissofgivingClientException("Exception while Charge: "+ e.getMessage());
		}
	}
}
