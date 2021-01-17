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

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

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
            fundRaiseDTO.setCreatedTimestamp(new Timestamp(System.currentTimeMillis()));
            fundRaiseDTO.setLastUpdateUser(user);
            fundRaiseDTO.setLastUpdateTimestamp(new Timestamp(System.currentTimeMillis()));
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
    public List<FundraiseDTO> getActiveFundraisesByUserName(String fundraiseCreatedUser, Boolean active) throws BlissofgivingClientException {
        List<FundraiseDTO> fundraiseDTOList = new ArrayList<FundraiseDTO>();
        try {
            List<Fundraise> fundraiseList = active ? fundraiseService.getActiveFundraisesByUserName(fundraiseCreatedUser) : fundraiseService.getAllFundraiseByUserName(fundraiseCreatedUser);
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
}
