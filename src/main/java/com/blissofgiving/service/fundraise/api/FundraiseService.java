package com.blissofgiving.service.fundraise.api;

import com.blissofgiving.exception.BlissofgivingServiceException;
import com.blissofgiving.model.Fundraise;

public interface FundraiseService {

    String createFundraise(Fundraise fundraise) throws BlissofgivingServiceException;

    Fundraise getFundraiseByID(String fundraiseID) throws BlissofgivingServiceException;

    void deleteFundraise(String fundraiseID) throws BlissofgivingServiceException;
}
