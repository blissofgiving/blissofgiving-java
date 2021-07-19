package com.blissofgiving.client.dto;


import java.util.Date;
import java.util.List;

public class FundraiseDTO {
	private String fundraiseSysGUID;
	private String fundraiseTitle;
	private String fundraiseDescription;
	private Double fundraiseTotal;
	private String fundraiseType;
	private Boolean fundraiseStatus;
	private Date startDate;
	private Date endDate;
	private String createdUser;
	private Date createdDate;
	private List<String> fundRaiseMediaLinks;

	public String getFundraiseSysGUID() {
		return fundraiseSysGUID;
	}

	public void setFundraiseSysGUID(String fundraiseSysGUID) {
		this.fundraiseSysGUID = fundraiseSysGUID;
	}

	public String getFundraiseTitle() {
		return fundraiseTitle;
	}

	public void setFundraiseTitle(String fundraiseTitle) {
		this.fundraiseTitle = fundraiseTitle;
	}

	public String getFundraiseDescription() {
		return fundraiseDescription;
	}

	public void setFundraiseDescription(String fundraiseDescription) {
		this.fundraiseDescription = fundraiseDescription;
	}

	public Double getFundraiseTotal() {
		return fundraiseTotal;
	}

	public void setFundraiseTotal(Double fundraiseTotal) {
		this.fundraiseTotal = fundraiseTotal;
	}

	public String getFundraiseType() {
		return fundraiseType;
	}

	public void setFundraiseType(String fundraiseType) {
		this.fundraiseType = fundraiseType;
	}

	public Boolean getFundraiseStatus() {
		return fundraiseStatus;
	}

	public void setFundraiseStatus(Boolean fundraiseStatus) {
		this.fundraiseStatus = fundraiseStatus;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
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

	public List<String> getFundRaiseMediaLinks() {
		return fundRaiseMediaLinks;
	}

	public void setFundRaiseMediaLinks(List<String> fundRaiseMediaLinks) {
		this.fundRaiseMediaLinks = fundRaiseMediaLinks;
	}
}
