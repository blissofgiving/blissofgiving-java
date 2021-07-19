package com.blissofgiving.dao;

import java.util.List;

import com.blissofgiving.dynamodbmodel.BeneficiaryPayment;

public interface PaymentDAO {

	void saveBeneficiaryCharge(BeneficiaryPayment beneficiaryPayment);

	List<BeneficiaryPayment> getBeneficiaryPayments(String beneficiarySysGuid);
}
