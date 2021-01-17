package com.blissofgiving.service.fundraise.api;

import com.blissofgiving.client.dto.FundraiseDTO;
import com.blissofgiving.exception.BlissofgivingClientException;

import java.util.List;

public interface FundraiseClientService {

    public String createFundraise(FundraiseDTO fundRaiseDTO, String user) throws BlissofgivingClientException;

    FundraiseDTO getFundraiseByID(String fundraiseID) throws BlissofgivingClientException;

    List<FundraiseDTO> getActiveFundraisesByUserName(String fundraiseCreatedUser, Boolean active) throws BlissofgivingClientException;

    void deleteFundraise(String fundraiseID) throws BlissofgivingClientException;
}
