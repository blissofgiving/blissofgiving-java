package com.blissofgiving.dao;

import java.util.List;

import com.blissofgiving.dynamodbmodel.FundraiseComment;

public interface FundaraiseCommentsDAO {
	void createFundraiseComment(FundraiseComment fundraiseComment);

	void createFundraiseComments(List<FundraiseComment> fundraiseCommentsList);
}
