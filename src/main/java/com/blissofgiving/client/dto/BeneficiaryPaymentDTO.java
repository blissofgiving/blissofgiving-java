package com.blissofgiving.client.dto;

public class BeneficiaryPaymentDTO {

	private String beneficiaryDonationSysGuid;

	private String beneficiarySysGUID;

	private Long amount;

	private String currency;

	private String description;

	private String billingDetails;

	private String invoice;

	private String receiptEmail;

	public String getBeneficiaryDonationSysGuid() {
		return beneficiaryDonationSysGuid;
	}

	public void setBeneficiaryDonationSysGuid(String beneficiaryDonationSysGuid) {
		this.beneficiaryDonationSysGuid = beneficiaryDonationSysGuid;
	}

	public String getBeneficiarySysGUID() {
		return beneficiarySysGUID;
	}

	public void setBeneficiarySysGUID(String beneficiarySysGUID) {
		this.beneficiarySysGUID = beneficiarySysGUID;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBillingDetails() {
		return billingDetails;
	}

	public void setBillingDetails(String billingDetails) {
		this.billingDetails = billingDetails;
	}

	public String getInvoice() {
		return invoice;
	}

	public void setInvoice(String invoice) {
		this.invoice = invoice;
	}

	public String getReceiptEmail() {
		return receiptEmail;
	}

	public void setReceiptEmail(String receiptEmail) {
		this.receiptEmail = receiptEmail;
	}
}
