package com.blissofgiving.service.media.api;

import java.util.List;

import com.blissofgiving.dynamodbmodel.FundraiseMedia;
import com.blissofgiving.exception.BlissofgivingServiceException;

public interface FundraiseMediaService {

    void createFundraiseMedia(FundraiseMedia fundraiseMedia) throws BlissofgivingServiceException;

	void updateFundraiseMedia(FundraiseMedia fundraiseMedia) throws BlissofgivingServiceException;

	void deleteFundraiseMedia(String fundraiseID) throws BlissofgivingServiceException;

	List<FundraiseMedia> getFundraiseMedia(String fundraiseID) throws BlissofgivingServiceException;
}
