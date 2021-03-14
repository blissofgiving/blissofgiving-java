package com.blissofgiving.service.comments.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blissofgiving.dao.FundaraiseCommentsDAO;
import com.blissofgiving.dynamodbmodel.FundraiseComment;
import com.blissofgiving.exception.BlissofgivingServiceException;
import com.blissofgiving.service.comments.api.FundraiseCommentService;

@Service
public class FundraiseCommentServiceImpl implements FundraiseCommentService {

    @Autowired
    private FundaraiseCommentsDAO fundaraiseCommentDao;

    @Override
    public void createFundraiseComments(List<FundraiseComment> fundraiseCommentsList) throws BlissofgivingServiceException {
        try {

            fundraiseCommentsList.forEach(fundraiseComment -> {
                String key = UUID.randomUUID().toString();
                fundraiseComment.setFundRaiseCommentSysGuid(key);

            });
            fundaraiseCommentDao.createFundraiseComments(fundraiseCommentsList);
        } catch (Exception e) {
            throw new BlissofgivingServiceException(e);
        }
    }

    @Override
    public void createFundraiseComment(FundraiseComment fundraiseComment) throws BlissofgivingServiceException {
        try {
            String key = UUID.randomUUID().toString();
            fundraiseComment.setFundRaiseCommentSysGuid(key);
            fundaraiseCommentDao.createFundraiseComment(fundraiseComment);
        } catch (Exception e) {
            throw new BlissofgivingServiceException(e);
        }
    }
}
