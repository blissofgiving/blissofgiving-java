package com.blissofgiving.service.beneficiary.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blissofgiving.client.dto.BeneficiaryDTO;
import com.blissofgiving.dynamodbmodel.Beneficiary;
import com.blissofgiving.exception.BlissofgivingClientException;
import com.blissofgiving.exception.BlissofgivingServiceException;
import com.blissofgiving.service.beneficiary.api.BeneficiaryClientService;
import com.blissofgiving.service.beneficiary.api.BeneficiaryService;

@Service
public class BeneficiaryClientServiceImpl implements BeneficiaryClientService {

    @Autowired
    private BeneficiaryService beneficiaryService;

    @Override
    public String createBeneficiary(final BeneficiaryDTO beneficiaryDTO) throws BlissofgivingServiceException {
        try {
            Beneficiary beneficiary = new Beneficiary();
            BeanUtils.copyProperties(beneficiaryDTO, beneficiary);
            return beneficiaryService.createBeneficiary(beneficiary);
        } catch (Exception e) {
            throw new BlissofgivingServiceException(e);
        }
    }

    @Override
    public BeneficiaryDTO getBeneficiaryById(String beneficiarySysGuid, String userId) throws BlissofgivingClientException {
        Beneficiary beneficiary = beneficiaryService.getBeneficiaryById(beneficiarySysGuid);

        BeneficiaryDTO beneficiaryDTO = new BeneficiaryDTO();
        BeanUtils.copyProperties(beneficiary, beneficiaryDTO);
        return beneficiaryDTO;
    }

    @Override
    public void updateBeneficiary(BeneficiaryDTO beneficiaryDTO, String userId) throws BlissofgivingClientException {
        try {
            Beneficiary beneficiary = new Beneficiary();
            BeanUtils.copyProperties(beneficiaryDTO, beneficiary);
            beneficiary.setLastUpdateUser(userId);
            beneficiaryService.updateBeneficiary(beneficiary);
        } catch (Exception e) {
            throw new BlissofgivingServiceException(e);
        }
    }

    @Override
    public void deleteBeneficiary(String beneficiarySysGuid) throws BlissofgivingClientException {
        beneficiaryService.deleteBeneficiary(beneficiarySysGuid);
    }
}
