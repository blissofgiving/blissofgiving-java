package com.blissofgiving.service.fundraise.api;

import com.blissofgiving.exception.BlissofgivingServiceException;
import com.blissofgiving.model.Fundraise;

import java.util.List;

public interface FundraiseService {

    String createFundraise(Fundraise fundraise) throws BlissofgivingServiceException;

    Fundraise getFundraiseByID(String fundraiseID) throws BlissofgivingServiceException;

    List<Fundraise> getAllFundraiseByUserName(String fundraiseUserName) throws BlissofgivingServiceException;

    List<Fundraise> getActiveFundraisesByUserName(String fundraiseUserName) throws BlissofgivingServiceException;

    void deleteFundraise(String fundraiseID) throws BlissofgivingServiceException;
}
