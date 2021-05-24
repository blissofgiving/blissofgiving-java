package com.blissofgiving.dao.beneficiary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.blissofgiving.dynamodbrepository.BlissDynamoDBConfig;
import com.blissofgiving.model.Beneficiary;

@Service
public class BeneficiaryDAOImpl implements BeneficiaryDAO{

	@Autowired
	private BlissDynamoDBConfig blissDynamoDBConfig;

	private DynamoDBMapper getDynamoDBMapper() {
		DynamoDBMapper dynamoDBMapper = blissDynamoDBConfig.dynamoDBMapper(blissDynamoDBConfig.amazonDynamoDB(), blissDynamoDBConfig.dynamoDBMapperConfig());
		return dynamoDBMapper;
	}

	@Override
	public void createBeneficiary(Beneficiary beneficiary) {
		getDynamoDBMapper().save(beneficiary);
	}
}
