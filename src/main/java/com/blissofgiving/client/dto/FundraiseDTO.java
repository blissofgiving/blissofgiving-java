package com.blissofgiving.client.dto;

import java.sql.Date;
import java.sql.Timestamp;

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
    private String lastUpdateUser;
    private Timestamp createdTimestamp;
    private Timestamp lastUpdateTimestamp;

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

    public String getLastUpdateUser() {
        return lastUpdateUser;
    }

    public void setLastUpdateUser(String lastUpdateUser) {
        this.lastUpdateUser = lastUpdateUser;
    }

    public Timestamp getCreatedTimestamp() {
        return createdTimestamp;
    }

    public void setCreatedTimestamp(Timestamp createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    public Timestamp getLastUpdateTimestamp() {
        return lastUpdateTimestamp;
    }

    public void setLastUpdateTimestamp(Timestamp lastUpdateTimestamp) {
        this.lastUpdateTimestamp = lastUpdateTimestamp;
    }
}
