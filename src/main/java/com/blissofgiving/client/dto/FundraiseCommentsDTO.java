package com.blissofgiving.client.dto;

import java.sql.Timestamp;

public class FundraiseCommentsDTO {
    private String fundRaiseCommentSysGuid;
    private String fundraiseSysGuid;
    private String fundraiseComment;
    private String createdUser;
    private Timestamp createdDate;
    private String lastUpdateUser;
    private Timestamp lastUpdateDate;

    public String getFundRaiseCommentSysGuid() {
        return fundRaiseCommentSysGuid;
    }

    public void setFundRaiseCommentSysGuid(String fundRaiseCommentSysGuid) {
        this.fundRaiseCommentSysGuid = fundRaiseCommentSysGuid;
    }

    public String getFundraiseSysGuid() {
        return fundraiseSysGuid;
    }

    public void setFundraiseSysGuid(String fundraiseSysGuid) {
        this.fundraiseSysGuid = fundraiseSysGuid;
    }

    public String getFundraiseComment() {
        return fundraiseComment;
    }

    public void setFundraiseComment(String fundraiseComment) {
        this.fundraiseComment = fundraiseComment;
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

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public Timestamp getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Timestamp lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }
}
