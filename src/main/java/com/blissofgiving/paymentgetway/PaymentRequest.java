package com.blissofgiving.paymentgetway;

import java.util.Currency;

public class PaymentRequest {

	private String description;
	private int amount;
	private Currency currency;
	private String stripeEmail;
	private String stripeToken;
	private String beneficiarySysGuid;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public String getStripeEmail() {
		return stripeEmail;
	}

	public void setStripeEmail(String stripeEmail) {
		this.stripeEmail = stripeEmail;
	}

	public String getStripeToken() {
		return stripeToken;
	}

	public void setStripeToken(String stripeToken) {
		this.stripeToken = stripeToken;
	}

	public String getBeneficiarySysGuid() {
		return beneficiarySysGuid;
	}

	public void setBeneficiarySysGuid(String beneficiarySysGuid) {
		this.beneficiarySysGuid = beneficiarySysGuid;
	}
}
