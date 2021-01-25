package com.blissofgiving.service.comments.impl;

import com.blissofgiving.exception.BlissofgivingServiceException;
import com.blissofgiving.model.FundraiseComments;
import com.blissofgiving.repository.FundraiseCommentsRespository;
import com.blissofgiving.service.comments.api.FundraiseCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FundraiseCommentServiceImpl implements FundraiseCommentService {

    @Autowired
    private FundraiseCommentsRespository fundraiseCommentsRespository;

    @Override
    public void createFundraiseComments(List<FundraiseComments> fundraiseCommentsList) throws BlissofgivingServiceException {
        try {
            fundraiseCommentsRespository.saveAll(fundraiseCommentsList);
        } catch (Exception e) {
            throw new BlissofgivingServiceException(e);
        }
    }

    @Override
    public void createFundraiseComment(FundraiseComments fundraiseComment) throws BlissofgivingServiceException {
        try {
            fundraiseCommentsRespository.insert(fundraiseComment);
        } catch (Exception e) {
            throw new BlissofgivingServiceException(e);
        }
    }
}