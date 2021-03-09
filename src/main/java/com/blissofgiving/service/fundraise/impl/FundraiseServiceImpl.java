package com.blissofgiving.service.fundraise.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blissofgiving.dao.FundraiseDAO;
import com.blissofgiving.dynamodbmodel.Fundraise;
import com.blissofgiving.exception.BlissofgivingServiceException;
import com.blissofgiving.service.fundraise.api.FundraiseService;

@Service
public class FundraiseServiceImpl implements FundraiseService {

    @Autowired
    private FundraiseDAO fundraiseDAO;

    @Override
    public String createFundraise(final Fundraise fundraise) throws BlissofgivingServiceException {
        Fundraise fundraiseCreated = null;

        String key = UUID.randomUUID().toString();
        try {
            fundraise.setFundraiseSysGUID(key);
             fundraiseDAO.createFundraise(fundraise);
        } catch (Exception e) {
            throw new BlissofgivingServiceException(e);
        }
        return key;
    }

    @Override
    public Fundraise getFundraiseByID(String fundraiseID, String userId) throws BlissofgivingServiceException {
        try {
            return fundraiseDAO.getFundraiseById(fundraiseID, userId);
        } catch (Exception e) {
            throw new BlissofgivingServiceException(e);
        }
    }

    @Override
    public List<Fundraise> getAllFundraiseByUserId(String fundraiseUserId) throws BlissofgivingServiceException {
        try {
            return fundraiseDAO.getAllFundraiseByUserId(fundraiseUserId);
        } catch (Exception e) {
            throw new BlissofgivingServiceException(e);
        }
    }
    @Override
    public List<Fundraise> getActiveFundraisesByUserId(String fundraiseUserId) throws BlissofgivingServiceException {
        try {
            return fundraiseDAO.findActiveFundraiseByUserId(fundraiseUserId);
        } catch (Exception e) {
            throw new BlissofgivingServiceException(e);
        }
    }

    @Override
    public void deleteFundraise(final String fundraiseID) throws BlissofgivingServiceException {
        try {
            fundraiseDAO.deleteById(fundraiseID);
        } catch (Exception e) {
            throw new BlissofgivingServiceException(e);
        }
    }

    @Override
    public void updateFundraise(Fundraise fundraise) {
        fundraiseDAO.updateFundraise(fundraise);
    }
}
