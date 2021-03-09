package com.blissofgiving.service.fundraise.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blissofgiving.client.dto.FundraiseDTO;
import com.blissofgiving.dynamodbmodel.Fundraise;
import com.blissofgiving.exception.BlissofgivingClientException;
import com.blissofgiving.exception.BlissofgivingServiceException;
import com.blissofgiving.service.fundraise.api.FundraiseClientService;
import com.blissofgiving.service.fundraise.api.FundraiseService;

@Service
public class FundraiseClientServiceImpl implements FundraiseClientService {

    @Autowired
    private FundraiseService fundraiseService;

    @Override
    public String createFundraise(final FundraiseDTO fundRaiseDTO, String user) throws BlissofgivingClientException {
        String fundraiseSysGuid = null;
        Fundraise fundraise = new Fundraise();
        try {
            fundRaiseDTO.setCreatedUser(user);
            fundRaiseDTO.setCreatedDate(new Timestamp(System.currentTimeMillis()));
            BeanUtils.copyProperties(fundRaiseDTO, fundraise);
            fundraise.setLastUpdateUser(user);
            fundraiseSysGuid = fundraiseService.createFundraise(fundraise);
        } catch (BlissofgivingServiceException e) {
            throw new BlissofgivingClientException(e);
        }
        return fundraiseSysGuid;
    }

    @Override
    public FundraiseDTO getFundraiseByID(String fundraiseId, String userId) throws BlissofgivingClientException {
        FundraiseDTO fundraiseDTO = new FundraiseDTO();
        try {
            Fundraise fundraise = fundraiseService.getFundraiseByID(fundraiseId, userId);
            BeanUtils.copyProperties(fundraise, fundraiseDTO);
        } catch (BlissofgivingServiceException e) {
            throw new BlissofgivingClientException(e);
        }
        return fundraiseDTO;
    }

    @Override
    public List<FundraiseDTO> getActiveFundraisesByUserName(String fundraiseCreatedUser, Boolean active) throws BlissofgivingClientException {
        List<FundraiseDTO> fundraiseDTOList = new ArrayList<FundraiseDTO>();
        try {
            List<Fundraise> fundraiseList = active ? fundraiseService.getActiveFundraisesByUserId(fundraiseCreatedUser) : fundraiseService.getAllFundraiseByUserId(fundraiseCreatedUser);
            fundraiseList.stream().forEach(fundraise -> {
                FundraiseDTO fundraiseDTO = new FundraiseDTO();
                BeanUtils.copyProperties(fundraise, fundraiseDTO);
                fundraiseDTOList.add(fundraiseDTO);
            });
        } catch (BlissofgivingServiceException e) {
            throw new BlissofgivingClientException(e);
        }
        return fundraiseDTOList;
    }

    @Override
    public void deleteFundraise(String fundraiseID) throws BlissofgivingClientException {
        try {
            fundraiseService.deleteFundraise(fundraiseID);
        } catch (BlissofgivingServiceException e) {
            throw new BlissofgivingClientException(e);
        }
    }

    @Override
    public void updateFundraise(FundraiseDTO fundraiseDTO, String user) throws BlissofgivingClientException {
        fundraiseDTO.setCreatedUser(user);
        fundraiseDTO.setCreatedDate(new Timestamp(System.currentTimeMillis()));

        Fundraise fundraise = new Fundraise();
        BeanUtils.copyProperties(fundraiseDTO, fundraise);
        fundraise.setLastUpdateUser(user);
        fundraiseService.updateFundraise(fundraise);
    }
}
