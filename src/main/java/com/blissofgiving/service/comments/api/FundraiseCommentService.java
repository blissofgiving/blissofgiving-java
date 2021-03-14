package com.blissofgiving.service.comments.api;

import com.blissofgiving.exception.BlissofgivingServiceException;
import com.blissofgiving.dynamodbmodel.FundraiseComment;

import java.util.List;

public interface FundraiseCommentService {

    void createFundraiseComments(List<FundraiseComment> fundraiseCommentsList) throws BlissofgivingServiceException;

    void createFundraiseComment(FundraiseComment fundraiseComment) throws BlissofgivingServiceException;
}
