package com.blissofgiving.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class FundraiseMedia implements Serializable {
	private String fundraiseSysGuid;
	private String mediaSysGuid;
	private String lastUpdateUser;
	private Timestamp lastUpdateTimestamp;
	private String fundRaiseMediaLink;

	public String getFundraiseSysGuid() {
		return fundraiseSysGuid;
	}

	public void setFundraiseSysGuid(String fundraiseSysGuid) {
		this.fundraiseSysGuid = fundraiseSysGuid;
	}

	public String getMediaSysGuid() {
		return mediaSysGuid;
	}

	public void setMediaSysGuid(String mediaSysGuid) {
		this.mediaSysGuid = mediaSysGuid;
	}

	public String getLastUpdateUser() {
		return lastUpdateUser;
	}

	public void setLastUpdateUser(String lastUpdateUser) {
		this.lastUpdateUser = lastUpdateUser;
	}

	public Timestamp getLastUpdateTimestamp() {
		return lastUpdateTimestamp;
	}

	public void setLastUpdateTimestamp(Timestamp lastUpdateTimestamp) {
		this.lastUpdateTimestamp = lastUpdateTimestamp;
	}

	public String getFundRaiseMediaLink() {
		return fundRaiseMediaLink;
	}

	public void setFundRaiseMediaLink(String fundRaiseMediaLink) {
		this.fundRaiseMediaLink = fundRaiseMediaLink;
	}
}
