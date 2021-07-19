package com.blissofgiving.service.media.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blissofgiving.dao.media.FundraiseMediaDAO;
import com.blissofgiving.dynamodbmodel.FundraiseMedia;
import com.blissofgiving.exception.BlissofgivingServiceException;
import com.blissofgiving.service.media.api.FundraiseMediaService;

@Service
public class FundraiseMediaServiceImpl implements FundraiseMediaService {

	@Autowired
	private FundraiseMediaDAO fundraiseMediaDAO;

	@Override
	public void createFundraiseMedia(final FundraiseMedia fundraiseMedia) throws BlissofgivingServiceException {
		try {
			fundraiseMediaDAO.createFundraiseMedia(fundraiseMedia);
		} catch (Exception e) {
			throw new BlissofgivingServiceException(e);
		}
	}

	@Override
	public void updateFundraiseMedia(final FundraiseMedia fundraiseMedia) throws BlissofgivingServiceException {
		try {
			fundraiseMediaDAO.updateFundraise(fundraiseMedia);
		} catch (Exception e) {
			throw new BlissofgivingServiceException(e);
		}
	}

	@Override
	public void deleteFundraiseMedia(final String fundraiseID) throws BlissofgivingServiceException {
		try {
			fundraiseMediaDAO.deleteFundraiseMediaById(fundraiseID);
		} catch (Exception e) {
			throw new BlissofgivingServiceException(e);
		}
	}

	@Override
	public List<FundraiseMedia> getFundraiseMedia(final String fundraiseID) throws BlissofgivingServiceException {
		try {
			return fundraiseMediaDAO.getFundraiseMediaById(fundraiseID);
		} catch (Exception e) {
			throw new BlissofgivingServiceException(e);
		}
	}
}
