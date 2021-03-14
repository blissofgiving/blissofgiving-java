package com.blissofgiving.service.comments.api;

import com.blissofgiving.client.dto.FundraiseCommentsDTO;
import com.blissofgiving.exception.BlissofgivingClientException;

import java.util.List;

public interface FundraiseCommentsClientService {
    void createFundraiseComments(List<FundraiseCommentsDTO> fundraiseCommentsDTOList, String userId) throws BlissofgivingClientException;

    void createFundraiseComment(FundraiseCommentsDTO fundraiseCommentsDTO, String userId) throws BlissofgivingClientException;
}
