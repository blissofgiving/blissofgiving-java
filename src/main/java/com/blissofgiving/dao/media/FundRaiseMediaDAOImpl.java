package com.blissofgiving.dao.media;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.blissofgiving.dynamodbmodel.FundraiseMedia;
import com.blissofgiving.dynamodbrepository.BlissDynamoDBConfig;

@Service
public class FundRaiseMediaDAOImpl implements FundraiseMediaDAO {

	@Autowired
	private BlissDynamoDBConfig blissDynamoDBConfig;

	private DynamoDBMapper getDynamoDBMapper() {
		DynamoDBMapper dynamoDBMapper = blissDynamoDBConfig.dynamoDBMapper(blissDynamoDBConfig.amazonDynamoDB(), blissDynamoDBConfig.dynamoDBMapperConfig());
		return dynamoDBMapper;
	}

	@Override
	public void createFundraiseMedia(FundraiseMedia fundraiseMedia) throws SQLException {
		getDynamoDBMapper().save(fundraiseMedia);
	}

	@Override
	public List<FundraiseMedia> getFundraiseMediaById(String fundraiseId) {
		FundraiseMedia fundraiseMedia = new FundraiseMedia();
		fundraiseMedia.setFundraiseSysGuid(fundraiseId);

		DynamoDBQueryExpression<FundraiseMedia> queryExpression = new DynamoDBQueryExpression<FundraiseMedia>()
				.withIndexName("FUNDRAISE_SYS_INDEX")
				.withHashKeyValues(fundraiseMedia)
				.withConsistentRead(false);
		List<FundraiseMedia> fundraiseMediaList = getDynamoDBMapper().query(FundraiseMedia.class, queryExpression);
		return fundraiseMediaList;
	}

	@Override
	public void deleteFundraiseMediaById(String fundraiseID) {
		FundraiseMedia fundraise = new FundraiseMedia();
		fundraise.setFundraiseSysGuid(fundraiseID);
		getDynamoDBMapper().delete(fundraise);
	}

	@Override
	public void updateFundraise(FundraiseMedia fundraise) {
		getDynamoDBMapper().save(fundraise);
	}

}

