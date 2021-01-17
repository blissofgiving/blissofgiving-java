package com.blissofgiving.service.beneficiary.api;

import com.blissofgiving.exception.BlissofgivingServiceException;
import com.blissofgiving.model.Beneficiary;

public interface BeneficiaryService {
    void createBeneficiary(Beneficiary beneficiary) throws BlissofgivingServiceException;
}
