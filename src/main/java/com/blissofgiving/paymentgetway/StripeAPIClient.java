package com.blissofgiving.paymentgetway;

import com.google.gson.Gson;
import com.stripe.param.PaymentIntentCreateParams;
import org.springframework.stereotype.Service;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;


@Service
public class StripeAPIClient {

    PaymentIntentCreateParams params =
            PaymentIntentCreateParams.builder()
                    .setCurrency("usd")
                    .setAmount(1099L)
                    // Verify your integration in this guide by including this parameter
                    .putMetadata("integration_check", "accept_a_payment")
                    .build();

    PaymentIntent intent;

    {
        try {
            intent = PaymentIntent.create(params);
        } catch (StripeException e) {
            e.printStackTrace();
        }
    }

}
