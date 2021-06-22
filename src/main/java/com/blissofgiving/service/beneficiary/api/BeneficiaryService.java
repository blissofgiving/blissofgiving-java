package com.blissofgiving.service.beneficiary.api;

import com.blissofgiving.dynamodbmodel.Beneficiary;
import com.blissofgiving.exception.BlissofgivingServiceException;

public interface BeneficiaryService {
    String createBeneficiary(Beneficiary beneficiary) throws BlissofgivingServiceException;

    Beneficiary getBeneficiaryById(String beneficiarySysGUID) throws BlissofgivingServiceException;

	void updateBeneficiary(Beneficiary beneficiary) throws BlissofgivingServiceException;

	void deleteBeneficiary(String beneficiarySysGuid) throws BlissofgivingServiceException;
}
