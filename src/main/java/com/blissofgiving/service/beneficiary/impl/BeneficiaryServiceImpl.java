package com.blissofgiving.service.beneficiary.impl;

import com.blissofgiving.exception.BlissofgivingServiceException;
import com.blissofgiving.model.Beneficiary;
import com.blissofgiving.repository.BeneficiaryRepository;
import com.blissofgiving.repository.BeneficiaryTestimonialsRepository;
import com.blissofgiving.service.beneficiary.api.BeneficiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BeneficiaryServiceImpl implements BeneficiaryService {

    @Autowired
    private BeneficiaryRepository beneficiaryRepository;

    @Autowired
    private BeneficiaryTestimonialsRepository beneficiaryTestimonialsRepository;

    @Override
    public void createBeneficiary(final Beneficiary beneficiary) throws BlissofgivingServiceException {
        try {
            beneficiaryRepository.insert(beneficiary);
        } catch (Exception e) {
            throw new BlissofgivingServiceException(e);
        }
    }
}
