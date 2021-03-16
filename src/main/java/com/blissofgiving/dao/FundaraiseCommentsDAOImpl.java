package com.blissofgiving.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.blissofgiving.dynamodbmodel.Fundraise;
import com.blissofgiving.dynamodbmodel.FundraiseComment;
import com.blissofgiving.dynamodbrepository.BlissDynamoDBConfig;

@Service
public class FundaraiseCommentsDAOImpl implements FundaraiseCommentsDAO {

	@Autowired
	private BlissDynamoDBConfig blissDynamoDBConfig;

	private DynamoDBMapper getDynamoDBMapper() {
		DynamoDBMapper dynamoDBMapper = blissDynamoDBConfig.dynamoDBMapper(blissDynamoDBConfig.amazonDynamoDB(), blissDynamoDBConfig.dynamoDBMapperConfig());
		return dynamoDBMapper;
	}

	@Override
	public void createFundraiseComment(FundraiseComment fundraiseComment) {
		getDynamoDBMapper().save(fundraiseComment);
	}

	@Override
	public void createFundraiseComments(List<FundraiseComment> fundraiseCommentsList) {
		getDynamoDBMapper().batchSave(fundraiseCommentsList);
	}

	@Override
	public List<FundraiseComment> getFundraiseComments(String fundraiseSysGuid, String userId) {
		FundraiseComment fundraiseComment = new FundraiseComment();
		fundraiseComment.setFundraiseSysGuid(fundraiseSysGuid);
		fundraiseComment.setCreatedUser(userId);
		//TODO adding userId doesn't have any affect on results. check once.

		DynamoDBQueryExpression<FundraiseComment> queryExpression = new DynamoDBQueryExpression<FundraiseComment>()
				.withIndexName("FUNDRAISE_SYS_GUID_INDEX")
				.withHashKeyValues(fundraiseComment)
				.withConsistentRead(false);
		List<FundraiseComment> fundraiseCommentList = getDynamoDBMapper().query(FundraiseComment.class, queryExpression);
		return fundraiseCommentList;
	}
}
