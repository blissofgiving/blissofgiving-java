package com.blissofgiving.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.blissofgiving.dynamodbmodel.BeneficiaryPayment;
import com.blissofgiving.dynamodbrepository.BlissDynamoDBConfig;

@Service
public class PaymentDAOImpl implements PaymentDAO {
	@Autowired
	private BlissDynamoDBConfig blissDynamoDBConfig;

	private DynamoDBMapper getDynamoDBMapper() {
		DynamoDBMapper dynamoDBMapper = blissDynamoDBConfig.dynamoDBMapper(blissDynamoDBConfig.amazonDynamoDB(), blissDynamoDBConfig.dynamoDBMapperConfig());
		return dynamoDBMapper;
	}

	@Override
	public void saveBeneficiaryCharge(BeneficiaryPayment beneficiaryPayment) {
		getDynamoDBMapper().save(beneficiaryPayment);
	}

	@Override
	public List<BeneficiaryPayment> getBeneficiaryPayments(String beneficiarySysGuid) {
		BeneficiaryPayment beneficiaryPayment = new BeneficiaryPayment();
		beneficiaryPayment.setBeneficiarySysGUID(beneficiarySysGuid);

		DynamoDBQueryExpression<BeneficiaryPayment> queryExpression = new DynamoDBQueryExpression<BeneficiaryPayment>()
				.withIndexName("BENEFICIARY_SYS_GUID_INDEX")
				.withHashKeyValues(beneficiaryPayment)
				.withConsistentRead(false);
		List<BeneficiaryPayment> beneficiaryPayments = getDynamoDBMapper().query(BeneficiaryPayment.class, queryExpression);
		return beneficiaryPayments;
	}
}
