package com.blissofgiving.service.comments.api;

import com.blissofgiving.client.dto.FundraiseCommentsDTO;
import com.blissofgiving.exception.BlissofgivingClientException;

import java.util.List;

public interface CommentsClientService {
    void createFundraiseComments(List<FundraiseCommentsDTO> fundraiseCommentsDTOList) throws BlissofgivingClientException;

    void createFundraiseComment(FundraiseCommentsDTO fundraiseCommentsDTO) throws BlissofgivingClientException;
}
