package com.blissofgiving.paymentgetway;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class StripeAPITestUtil {

    public static void main(String[] args) {
        // Set your secret key. Remember to switch to your live secret key in production!
        // See your keys here: https://dashboard.stripe.com/account/apikeys
        Stripe.apiKey = "sk_test_nLhyLyVrLDIK2YpSEKBDlvhp003ph8znS1";

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("amount", 1000);
        params.put("currency", "usd");
        ArrayList paymentMethodTypes = new ArrayList();
        paymentMethodTypes.add("card");
        params.put("payment_method_types", paymentMethodTypes);
        params.put("receipt_email", "blissofgiving1@gmail.com");

        try {
            PaymentIntent paymentIntent = PaymentIntent.create(params);
            System.out.println("paymentIntent: " + paymentIntent.getAmount());
        } catch (StripeException e) {
            e.printStackTrace();
        }
    }
}
