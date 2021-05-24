package com.blissofgiving.dynamodbmodel;

import java.util.Date;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGenerateStrategy;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedTimestamp;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIndexHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "BENEFICIARY")
public class Beneficiary {

	//Primary Key
	//@DynamoDBAutoGeneratedKey
	@DynamoDBHashKey(attributeName = "BENEFICIARY_SYS_GUID")
	private String beneficiarySysGuid;

	@DynamoDBIndexHashKey(globalSecondaryIndexName = "FUNDRAISE_SYS_GUID_INDEX", attributeName = "FUNDRAISE_SYS_GUID")
	private String fundraiseSysGUID;

	@DynamoDBAttribute(attributeName = "FIRST_NAME")
	private String firstName;

	@DynamoDBAttribute(attributeName = "LAST_NAME")
	private String lastName;

	@DynamoDBAttribute(attributeName = "MIDDLE_NAME")
	private String middleName;

	@DynamoDBAttribute(attributeName = "BENEFICIARY_TYPE")
	private String beneficiaryType;

	@DynamoDBAttribute(attributeName = "BENEFICIARY_DETAILS")
	private String beneficiaryDetails;

	@DynamoDBIndexHashKey( globalSecondaryIndexName = "CREATED_USER_INDEX", attributeName = "CREATED_USER")
	private String createdUser;

	@DynamoDBAttribute(attributeName = "CREATED_DATE")
	private Date createdDate;

	@DynamoDBAttribute(attributeName = "LAST_UPDATE_USER")
	private String lastUpdateUser;

	@DynamoDBAutoGeneratedTimestamp(strategy = DynamoDBAutoGenerateStrategy.CREATE)
	@DynamoDBAttribute(attributeName = "LAST_UPDATE_DATE")
	private Date lastUpdateDate;

	public String getBeneficiarySysGuid() {
		return beneficiarySysGuid;
	}

	public void setBeneficiarySysGuid(String beneficiarySysGuid) {
		this.beneficiarySysGuid = beneficiarySysGuid;
	}

	public String getFundraiseSysGUID() {
		return fundraiseSysGUID;
	}

	public void setFundraiseSysGUID(String fundraiseSysGUID) {
		this.fundraiseSysGUID = fundraiseSysGUID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getBeneficiaryType() {
		return beneficiaryType;
	}

	public void setBeneficiaryType(String beneficiaryType) {
		this.beneficiaryType = beneficiaryType;
	}

	public String getBeneficiaryDetails() {
		return beneficiaryDetails;
	}

	public void setBeneficiaryDetails(String beneficiaryDetails) {
		this.beneficiaryDetails = beneficiaryDetails;
	}

	public String getCreatedUser() {
		return createdUser;
	}

	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getLastUpdateUser() {
		return lastUpdateUser;
	}

	public void setLastUpdateUser(String lastUpdateUser) {
		this.lastUpdateUser = lastUpdateUser;
	}

	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}
}