package com.blissofgiving.service.fundraise.impl;

import com.blissofgiving.client.dto.FundraiseDTO;
import com.blissofgiving.exception.BlissofgivingClientException;
import com.blissofgiving.exception.BlissofgivingServiceException;
import com.blissofgiving.model.Fundraise;
import com.blissofgiving.service.fundraise.api.FundraiseClientService;
import com.blissofgiving.service.fundraise.api.FundraiseService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FundraiseClientServiceImpl implements FundraiseClientService {

    @Autowired
    private FundraiseService fundraiseService;

    @Override
    public String createFundraise(final FundraiseDTO fundRaiseDTO) throws BlissofgivingClientException {
        String fundraiseSysGuid = null;
        Fundraise fundraise = new Fundraise();
        try {
            BeanUtils.copyProperties(fundRaiseDTO, fundraise);
            fundraiseSysGuid = fundraiseService.createFundraise(fundraise);
        } catch (BlissofgivingServiceException e) {
            throw new BlissofgivingClientException(e);
        }
        return fundraiseSysGuid;
    }

    @Override
    public FundraiseDTO getFundraiseByID(String fundraiseID) throws BlissofgivingClientException {
        FundraiseDTO fundraiseDTO = new FundraiseDTO();
        try {
            Fundraise fundraise = fundraiseService.getFundraiseByID(fundraiseID);
            BeanUtils.copyProperties(fundraise, fundraiseDTO);
        } catch (BlissofgivingServiceException e) {
            throw new BlissofgivingClientException(e);
        }
        return fundraiseDTO;
    }

    @Override
    public void deleteFundraise(String fundraiseID) throws BlissofgivingClientException {
        try {
            fundraiseService.deleteFundraise(fundraiseID);
        } catch (BlissofgivingServiceException e) {
            throw new BlissofgivingClientException(e);
        }
    }
}
