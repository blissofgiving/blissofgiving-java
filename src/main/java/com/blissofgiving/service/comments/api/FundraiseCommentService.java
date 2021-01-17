package com.blissofgiving.service.comments.api;

import com.blissofgiving.exception.BlissofgivingServiceException;
import com.blissofgiving.model.FundraiseComments;

import java.util.List;

public interface FundraiseCommentService {

    void createFundraiseComments(List<FundraiseComments> fundraiseCommentsList) throws BlissofgivingServiceException;

    void createFundraiseComment(FundraiseComments fundraiseComment) throws BlissofgivingServiceException;
}
