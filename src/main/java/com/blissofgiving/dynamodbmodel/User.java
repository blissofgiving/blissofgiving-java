package com.blissofgiving.dynamodbmodel;

import java.util.Date;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGenerateStrategy;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedTimestamp;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;


@DynamoDBTable(tableName = "USER")
public class User {

	@DynamoDBAutoGeneratedKey
	@DynamoDBAttribute(attributeName = "USER_SYS_GUID")
	private String userSysGUID;

	@DynamoDBHashKey(attributeName = "USER_ID")
	private String userId;

	@DynamoDBAttribute(attributeName = "USER_TYPE")
	private String userType;

	@DynamoDBAttribute(attributeName = "PASSWORD")
	private String password;

	@DynamoDBAttribute(attributeName = "FIRST_NAME")
	private String firstName;

	@DynamoDBAttribute(attributeName = "LAST_NAME")
	private String lastName;

	@DynamoDBAttribute(attributeName = "MIDDLE_NAME")
	private String middleName;

	@DynamoDBAttribute(attributeName = "EMAIL_ID")
	private String emailID;

	@DynamoDBAttribute(attributeName = "PHONE_NUMBER")
	private Long phoneNumber;

	@DynamoDBAttribute(attributeName = "ADDRESS1")
	private String address1;

	@DynamoDBAttribute(attributeName = "ADDRESS2")
	private String address2;

	@DynamoDBAttribute(attributeName = "CITY")
	private String city;

	@DynamoDBAttribute(attributeName = "STATE")
	private String state;

	@DynamoDBAttribute(attributeName = "COUNTRY")
	private String country;

	@DynamoDBAttribute(attributeName = "POSTAL")
	private String postal;

	@DynamoDBAttribute(attributeName = "LAST_UPDATE_USER")
	private String lastUpdateUser;

	@DynamoDBAutoGeneratedTimestamp(strategy = DynamoDBAutoGenerateStrategy.CREATE)
	@DynamoDBAttribute(attributeName = "LAST_UPDATE_DATE")
	private Date lastUpdateDate;


	public String getUserSysGUID() {
		return userSysGUID;
	}

	public void setUserSysGUID(String userSysGUID) {
		this.userSysGUID = userSysGUID;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPostal() {
		return postal;
	}

	public void setPostal(String postal) {
		this.postal = postal;
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
