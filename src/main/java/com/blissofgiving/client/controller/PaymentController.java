package com.blissofgiving.client.controller;

import java.util.Currency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.blissofgiving.client.dto.PaymentDTO;
import com.blissofgiving.client.dto.PaymentRequestDTO;
import com.blissofgiving.client.service.PaymentClientService;
import com.blissofgiving.exception.BlissofgivingClientException;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;

@Controller
@CrossOrigin(origins = {"http://blissofgiving-react-app.s3-website.us-east-2.amazonaws.com"})
public class PaymentController {

	@Autowired
	PaymentClientService paymentClientService;

	@GetMapping(path = "/api/rest/v1/payment")
	public String getPayment(Model model) throws BlissofgivingClientException {
		PaymentDTO paymentDTO = paymentClientService.getStripeUIPaymentDTO();
		model.addAttribute("PaymentDTO", paymentDTO);
		return "payment";
	}

	@PostMapping("/api/rest/v1/charge")
	public String charge(PaymentRequestDTO paymentRequestDTO, Model model)
			throws StripeException {

		Charge charge = paymentClientService.charge(paymentRequestDTO);

		//model.addAttribute("id", charge.getId());
		model.addAttribute("status", charge.getStatus());
		//model.addAttribute("chargeId", charge.getId());
		//model.addAttribute("balance_transaction", charge.getBalanceTransaction());
		return "success";
	}

	@ExceptionHandler(StripeException.class)
	public String handleError(Model model, StripeException ex) {
		model.addAttribute("error", ex.getMessage());
		return "result";
	}

}
