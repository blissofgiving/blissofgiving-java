package com.blissofgiving.service.beneficiary.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blissofgiving.dao.BeneficiaryDAO;
import com.blissofgiving.dynamodbmodel.Beneficiary;
import com.blissofgiving.exception.BlissofgivingServiceException;
import com.blissofgiving.service.beneficiary.api.BeneficiaryService;

@Service
public class BeneficiaryServiceImpl implements BeneficiaryService {

    @Autowired
    BeneficiaryDAO beneficiaryDAO;

    @Override
    public String createBeneficiary(final Beneficiary beneficiary) throws BlissofgivingServiceException {
        try {
            String key = UUID.randomUUID().toString();
            beneficiary.setBeneficiarySysGuid(key);
            beneficiaryDAO.createBeneficiary(beneficiary);
            return key;
        } catch (Exception e) {
            throw new BlissofgivingServiceException(e);
        }
    }

    @Override
    public Beneficiary getBeneficiaryById(String beneficiarySysGuid) {
       return beneficiaryDAO.getBeneficiaryById(beneficiarySysGuid);
    }

    @Override
    public void updateBeneficiary(Beneficiary beneficiary) throws BlissofgivingServiceException {
        try {
            beneficiaryDAO.updateBeneficiary(beneficiary);
        } catch (Exception e) {
            throw new BlissofgivingServiceException(e);
        }
    }

    @Override
    public void deleteBeneficiary(String beneficiarySysGuid) throws BlissofgivingServiceException {
        try {
            beneficiaryDAO.deleteBeneficiary(beneficiarySysGuid);
        } catch (Exception e) {
            throw new BlissofgivingServiceException(e);
        }
    }
}
