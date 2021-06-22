package com.blissofgiving.service.beneficiary.api;

import com.blissofgiving.client.dto.BeneficiaryDTO;
import com.blissofgiving.exception.BlissofgivingClientException;

public interface BeneficiaryClientService {

    String createBeneficiary(BeneficiaryDTO beneficiaryDTO) throws BlissofgivingClientException;

    BeneficiaryDTO getBeneficiaryById(String beneficiarySysGuid, String userId) throws BlissofgivingClientException;

    void updateBeneficiary(BeneficiaryDTO beneficiaryDTO, String userId) throws BlissofgivingClientException;

    void deleteBeneficiary(String beneficiarySysGuid) throws  BlissofgivingClientException;
}
