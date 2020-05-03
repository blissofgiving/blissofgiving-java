package com.blissofgiving.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.sql.Timestamp;

@Document(collection = "FUNDRAISE_MEDIA")
public class FundraiseMedia implements Serializable {

    @Id
    private String fundraiseMediaSysGuid;
    @Indexed
    private String fundraiseSysGuid;
    private String mediaSysGuid;
    private String lastUpdateUser;
    private Timestamp lastUpdateTimestamp;

    public String getFundraiseMediaSysGuid() {
        return fundraiseMediaSysGuid;
    }

    public void setFundraiseMediaSysGuid(String fundraiseMediaSysGuid) {
        this.fundraiseMediaSysGuid = fundraiseMediaSysGuid;
    }

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
}
