package com.blissofgiving.service.beneficiary.api;

import com.blissofgiving.client.dto.BeneficiaryDTO;
import com.blissofgiving.exception.BlissofgivingServiceException;

public interface BeneficiaryClientService {
    void createBeneficiary(BeneficiaryDTO beneficiaryDTO) throws BlissofgivingServiceException;
}
