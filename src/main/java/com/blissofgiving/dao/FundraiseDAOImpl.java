package com.blissofgiving.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.blissofgiving.dynamodbmodel.Fundraise;
import com.blissofgiving.dynamodbrepository.BlissDynamoDBConfig;

@Service
public class FundraiseDAOImpl implements FundraiseDAO {

	@Autowired
	private BlissDynamoDBConfig blissDynamoDBConfig;

	private DynamoDBMapper getDynamoDBMapper() {
		DynamoDBMapper dynamoDBMapper = blissDynamoDBConfig.dynamoDBMapper(blissDynamoDBConfig.amazonDynamoDB(), blissDynamoDBConfig.dynamoDBMapperConfig());
		return dynamoDBMapper;
	}

	@Override
	public void createFundraise(Fundraise fundraise) throws SQLException {
		getDynamoDBMapper().save(fundraise);
	}

	@Override
	public Fundraise getFundraiseById(String fundraiseId, String userId) {
		DynamoDBMapper dynamoDBMapper = getDynamoDBMapper();
		Fundraise fundraise =  dynamoDBMapper.load(Fundraise.class, fundraiseId);
		return fundraise;
	}

	@Override
	public void deleteById(String fundraiseID) {
		Fundraise fundraise = new Fundraise();
		fundraise.setFundraiseSysGUID(fundraiseID);
		getDynamoDBMapper().delete(fundraise);
	}

	@Override
	public void updateFundraise(Fundraise fundraise){
		getDynamoDBMapper().save(fundraise);
	}

	@Override
	public List<Fundraise> findActiveFundraiseByUserId(String fundraiseUserId) {
		Fundraise fundraise = new Fundraise();
		fundraise.setCreatedUser(fundraiseUserId);

		DynamoDBQueryExpression<Fundraise> queryExpression = new DynamoDBQueryExpression<Fundraise>()
				.withIndexName("CREATED_USER_INDEX")
				.withHashKeyValues(fundraise)
				.withConsistentRead(false);
		List<Fundraise> fundraiseList = getDynamoDBMapper().query(Fundraise.class, queryExpression);
		List<Fundraise> activeFundraiseList = new ArrayList<>();
		for (Fundraise fundraise1 :
				fundraiseList) {
			if(fundraise1.getFundraiseStatus() != null && fundraise1.getFundraiseStatus()){
				activeFundraiseList.add(fundraise1);
			}
		}
		return  activeFundraiseList;
	}

	@Override
	public List<Fundraise> getAllFundraiseByUserId(String fundraiseUserId) {
		Fundraise fundraise = new Fundraise();
		fundraise.setCreatedUser(fundraiseUserId);

		DynamoDBQueryExpression<Fundraise> queryExpression = new DynamoDBQueryExpression<Fundraise>()
				.withIndexName("CREATED_USER_INDEX")
				.withHashKeyValues(fundraise)
				.withConsistentRead(false);
		List<Fundraise> fundraiseList = getDynamoDBMapper().query(Fundraise.class, queryExpression);
		return fundraiseList;
	}
}
