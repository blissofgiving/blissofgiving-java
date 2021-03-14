package com.blissofgiving.service.comments.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blissofgiving.client.dto.FundraiseCommentsDTO;
import com.blissofgiving.dynamodbmodel.FundraiseComment;
import com.blissofgiving.exception.BlissofgivingClientException;
import com.blissofgiving.service.comments.api.FundraiseCommentsClientService;
import com.blissofgiving.service.comments.api.FundraiseCommentService;

@Service
public class FundraiseCommentsClientServiceImpl implements FundraiseCommentsClientService {

    @Autowired
    private FundraiseCommentService fundraiseCommentService;

    @Override
    public void createFundraiseComments(final List<FundraiseCommentsDTO> fundraiseCommentsDTOList, String userId) throws BlissofgivingClientException {
        List<FundraiseComment> fundraiseCommentsList = new ArrayList<FundraiseComment>();
        try {
            fundraiseCommentsDTOList.stream().forEach(fundraiseCommentsDTO -> {
                FundraiseComment fundraiseComment = new FundraiseComment();
                fundraiseCommentsDTO.setCreatedUser(userId);
                fundraiseCommentsDTO.setCreatedDate(new Timestamp(System.currentTimeMillis()));

                BeanUtils.copyProperties(fundraiseCommentsDTO, fundraiseComment);
                fundraiseComment.setLastUpdateUser(userId);

                fundraiseCommentsList.add(fundraiseComment);
            });
            fundraiseCommentService.createFundraiseComments(fundraiseCommentsList);
        } catch (Exception e) {
            throw new BlissofgivingClientException(e);
        }
    }

    @Override
    public void createFundraiseComment(final FundraiseCommentsDTO fundraiseCommentsDTO, String userId) throws BlissofgivingClientException {
        FundraiseComment fundraiseComment = new FundraiseComment();
        try {
            fundraiseCommentsDTO.setCreatedUser(userId);
            fundraiseCommentsDTO.setCreatedDate(new Timestamp(System.currentTimeMillis()));

            BeanUtils.copyProperties(fundraiseCommentsDTO, fundraiseComment);
            fundraiseComment.setLastUpdateUser(userId);

            fundraiseCommentService.createFundraiseComment(fundraiseComment);

        } catch (Exception e) {
            throw new BlissofgivingClientException(e);
        }
    }
}
