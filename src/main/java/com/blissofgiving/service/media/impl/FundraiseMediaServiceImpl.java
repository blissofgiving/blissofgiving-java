package com.blissofgiving.service.media.impl;

import com.blissofgiving.model.FundraiseMedia;
import com.blissofgiving.repository.FundraiserMediaRepository;
import com.blissofgiving.service.media.api.FundraiseMediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FundraiseMediaServiceImpl implements FundraiseMediaService {

    @Autowired
    private FundraiserMediaRepository fundraiseMediaRespository;

    @Override
    public void createFundraiseMedia(final FundraiseMedia fundraiseMedia) {
        fundraiseMediaRespository.insert(fundraiseMedia);
    }
}
