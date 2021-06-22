package com.blissofgiving.dao;

import com.blissofgiving.dynamodbmodel.Beneficiary;

public interface BeneficiaryDAO {
	void createBeneficiary(Beneficiary beneficiary);

	Beneficiary getBeneficiaryById(String beneficiarySysGuid);


	void updateBeneficiary(Beneficiary beneficiary);

	void deleteBeneficiary(String beneficiarySysGuid);
}
