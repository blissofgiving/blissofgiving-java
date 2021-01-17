package com.blissofgiving.service.beneficiary.impl;

import com.blissofgiving.client.dto.BeneficiaryDTO;
import com.blissofgiving.exception.BlissofgivingServiceException;
import com.blissofgiving.model.Beneficiary;
import com.blissofgiving.service.beneficiary.api.BeneficiaryClientService;
import com.blissofgiving.service.beneficiary.api.BeneficiaryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BeneficiaryClientServiceImpl implements BeneficiaryClientService {

    @Autowired
    private BeneficiaryService beneficiaryService;

    @Override
    public void createBeneficiary(final BeneficiaryDTO beneficiaryDTO) throws BlissofgivingServiceException {
        try {
            Beneficiary beneficiary = new Beneficiary();
            BeanUtils.copyProperties(beneficiaryDTO, beneficiary);
            beneficiaryService.createBeneficiary(beneficiary);
        } catch (Exception e) {
            throw new BlissofgivingServiceException(e);
        }
    }


}
