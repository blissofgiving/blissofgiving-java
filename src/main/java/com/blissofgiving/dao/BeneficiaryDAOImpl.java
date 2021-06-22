package com.blissofgiving.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.blissofgiving.dynamodbmodel.Beneficiary;
import com.blissofgiving.dynamodbrepository.BlissDynamoDBConfig;

@Service
public class BeneficiaryDAOImpl implements BeneficiaryDAO {

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

	@Override
	public Beneficiary getBeneficiaryById(String beneficiarySysGuid) {
		DynamoDBMapper dynamoDBMapper = getDynamoDBMapper();
		Beneficiary beneficiary =  dynamoDBMapper.load(Beneficiary.class, beneficiarySysGuid);
		return beneficiary;
	}

	@Override
	public void updateBeneficiary(Beneficiary beneficiary) {
		getDynamoDBMapper().save(beneficiary);
	}

	@Override
	public void deleteBeneficiary(String beneficiarySysGuid) {
		Beneficiary beneficiary = new Beneficiary();
		beneficiary.setBeneficiarySysGuid(beneficiarySysGuid);
		getDynamoDBMapper().delete(beneficiary);
	}
}
