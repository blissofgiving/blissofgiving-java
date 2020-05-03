package com.blissofgiving.service.fundraise.api;

import com.blissofgiving.client.dto.FundraiseCommentsDTO;
import com.blissofgiving.client.dto.FundraiseDTO;
import com.blissofgiving.exception.BlissofgivingClientException;

import java.util.List;

public interface FundraiseClientService {

    public String createFundraise(FundraiseDTO fundRaiseDTO) throws BlissofgivingClientException;

    FundraiseDTO getFundraiseByID(String fundraiseID) throws BlissofgivingClientException;

    void deleteFundraise(String fundraiseID) throws BlissofgivingClientException;

    public void createFundraiseComments(List<FundraiseCommentsDTO> fundraiseCommentsDTOList) throws BlissofgivingClientException;
}
