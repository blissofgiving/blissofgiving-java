package com.blissofgiving.service.fundraise.api;

import java.util.List;

import com.blissofgiving.dynamodbmodel.Fundraise;
import com.blissofgiving.exception.BlissofgivingServiceException;

public interface FundraiseService {

    String createFundraise(Fundraise fundraise) throws BlissofgivingServiceException;

    Fundraise getFundraiseByID(String fundraiseID, String userId) throws BlissofgivingServiceException;

    List<Fundraise> getAllFundraiseByUserId(String fundraiseUserName) throws BlissofgivingServiceException;

    List<Fundraise> getActiveFundraisesByUserId(String fundraiseUserName) throws BlissofgivingServiceException;

    void deleteFundraise(String fundraiseID) throws BlissofgivingServiceException;

    void updateFundraise(Fundraise fundraise);
}
