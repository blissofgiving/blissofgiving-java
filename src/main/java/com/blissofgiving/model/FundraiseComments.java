package com.blissofgiving.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Timestamp;

@Document(collection = "FUNDRAISE_COMMENTS")
public class FundraiseComments {

    @Id
    private String fundRaiseCommentSysGuid;
    @Indexed
    private String fundraiseSysGuid;
    private String fundraiseComment;
    private String createdUser;
    private String lastUpdateUser;
    private Timestamp createdTimestamp;
    private Timestamp lastUpdateTimestamp;

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
