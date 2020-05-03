package com.blissofgiving.service.media.impl;

import com.blissofgiving.model.BeneficiaryMedia;
import com.blissofgiving.repository.BeneficiaryMediaRepository;
import com.blissofgiving.service.media.api.BeneficiaryMediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BeneficiaryMediaServiceImpl implements BeneficiaryMediaService {

    @Autowired
    private BeneficiaryMediaRepository beneficiaryMediaRepository;

    @Override
    public void createBeneficiaryMedia(BeneficiaryMedia media){
        beneficiaryMediaRepository.insert(media);
    }
}
