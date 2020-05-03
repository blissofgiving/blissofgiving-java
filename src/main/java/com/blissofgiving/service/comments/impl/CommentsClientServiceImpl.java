package com.blissofgiving.service.comments.impl;

import com.blissofgiving.client.dto.FundraiseCommentsDTO;
import com.blissofgiving.exception.BlissofgivingClientException;
import com.blissofgiving.model.FundraiseComments;
import com.blissofgiving.service.comments.api.CommentsClientService;
import com.blissofgiving.service.comments.api.FundraiseCommentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentsClientServiceImpl  implements CommentsClientService {

    @Autowired
    private FundraiseCommentService fundraiseCommentService;

    @Override
    public void createFundraiseComments(final List<FundraiseCommentsDTO> fundraiseCommentsDTOList) throws BlissofgivingClientException {
        List<FundraiseComments> fundraiseCommentsList = new ArrayList<FundraiseComments>();
        try {
            fundraiseCommentsDTOList.stream().forEach(fundraiseCommentsDTO -> {
                FundraiseComments comments = new FundraiseComments();
                BeanUtils.copyProperties(fundraiseCommentsDTO, comments);
                fundraiseCommentsList.add(comments);
            });
            fundraiseCommentService.createFundraiseComments(fundraiseCommentsList);
        } catch (Exception e) {
            throw new BlissofgivingClientException(e);
        }
    }
}
