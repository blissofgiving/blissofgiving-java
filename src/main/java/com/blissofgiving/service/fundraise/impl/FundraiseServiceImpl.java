package com.blissofgiving.service.fundraise.impl;

import com.blissofgiving.exception.BlissofgivingServiceException;
import com.blissofgiving.model.Fundraise;
import com.blissofgiving.repository.FundraiseRespository;
import com.blissofgiving.service.fundraise.api.FundraiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FundraiseServiceImpl implements FundraiseService {

    @Autowired
    private FundraiseRespository repository;

    @Override
    public String createFundraise(final Fundraise fundraise) throws BlissofgivingServiceException {
        Fundraise fundraiseCreated = null;
        try {
            fundraiseCreated = repository.insert(fundraise);
        } catch (Exception e) {
            throw new BlissofgivingServiceException(e);
        }
        return fundraiseCreated.getFundraiseSysGUID();
    }

    @Override
    public Fundraise getFundraiseByID(String fundraiseID) throws BlissofgivingServiceException {
        try {
            return repository.findById(fundraiseID).get();
        } catch (Exception e) {
            throw new BlissofgivingServiceException(e);
        }
    }

    @Override
    public List<Fundraise> getAllFundraiseByUserName(String fundraiseUserName) throws BlissofgivingServiceException {
        try {
            return repository.findByUsername(fundraiseUserName);
        } catch (Exception e) {
            throw new BlissofgivingServiceException(e);
        }
    }
    @Override
    public List<Fundraise> getActiveFundraisesByUserName(String fundraiseUserName) throws BlissofgivingServiceException {
        try {
            return repository.findActivefundraiseByUsername(fundraiseUserName,new Date(System.currentTimeMillis()));
        } catch (Exception e) {
            throw new BlissofgivingServiceException(e);
        }
    }

    @Override
    public void deleteFundraise(final String fundraiseID) throws BlissofgivingServiceException {
        try {
            repository.deleteById(fundraiseID);
        } catch (Exception e) {
            throw new BlissofgivingServiceException(e);
        }
    }
}
