package com.blissofgiving.service.fundraise.api;

import com.blissofgiving.exception.BlissofgivingServiceException;
import com.blissofgiving.model.FundraiseComments;

import java.util.List;

public interface FundraiseCommentService {
    void createFundraiseComments(List<FundraiseComments> fundraiseCommentsList) throws BlissofgivingServiceException;
}
