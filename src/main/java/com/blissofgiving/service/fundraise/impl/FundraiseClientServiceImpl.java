package com.blissofgiving.service.fundraise.impl;

import com.blissofgiving.client.dto.FundraiseCommentsDTO;
import com.blissofgiving.client.dto.FundraiseDTO;
import com.blissofgiving.exception.BlissofgivingClientException;
import com.blissofgiving.exception.BlissofgivingServiceException;
import com.blissofgiving.model.Fundraise;
import com.blissofgiving.model.FundraiseComments;
import com.blissofgiving.service.fundraise.api.FundraiseClientService;
import com.blissofgiving.service.fundraise.api.FundraiseCommentService;
import com.blissofgiving.service.fundraise.api.FundraiseService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FundraiseClientServiceImpl implements FundraiseClientService {

    @Autowired
    private FundraiseService fundraiseService;

    @Autowired
    private FundraiseCommentService fundraiseCommentService;

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

    @Override
    public void createFundraiseComments(final List<FundraiseCommentsDTO> fundraiseCommentsDTOList) throws BlissofgivingClientException {
        List<FundraiseComments> fundraiseCommentsList = new ArrayList<FundraiseComments>();
        try {
            fundraiseCommentsDTOList.stream().forEach(fundraiseCommentsDTO -> {
                FundraiseComments comments = new FundraiseComments();
                BeanUtils.copyProperties(fundraiseCommentsDTO, comments);
                fundraiseCommentsList.add(comments);
            });
            fundraiseCommentService.createFundraiseComments(fundraiseCommentsList);
        } catch (BlissofgivingServiceException e) {
            throw new BlissofgivingClientException(e);
        }
    }
}
