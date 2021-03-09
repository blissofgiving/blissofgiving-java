package com.blissofgiving.service.fundraise.api;

import java.util.List;

import com.blissofgiving.client.dto.FundraiseDTO;
import com.blissofgiving.exception.BlissofgivingClientException;

public interface FundraiseClientService {

    public String createFundraise(FundraiseDTO fundRaiseDTO, String user) throws BlissofgivingClientException;

    FundraiseDTO getFundraiseByID(String fundraiseId, String userId) throws BlissofgivingClientException;

    List<FundraiseDTO> getActiveFundraisesByUserName(String fundraiseCreatedUser, Boolean active) throws BlissofgivingClientException;

    void deleteFundraise(String fundraiseID) throws BlissofgivingClientException;

    void updateFundraise(FundraiseDTO fundraiseDTO, String user) throws BlissofgivingClientException;
}
