package com.blissofgiving.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import java.io.Serializable;
import java.sql.Timestamp;

public class BeneficiaryMedia implements Serializable {

    @Id
    private String beneficiaryMediaSysGuid;
    @Indexed
    private String beneficiarySysGuid;
    private String mediaSysGuid;
    private String lastUpdateUser;
    private Timestamp lastUpdateTimestamp;

    public String getBeneficiaryMediaSysGuid() {
        return beneficiaryMediaSysGuid;
    }

    public void setBeneficiaryMediaSysGuid(String beneficiaryMediaSysGuid) {
        this.beneficiaryMediaSysGuid = beneficiaryMediaSysGuid;
    }

    public String getBeneficiarySysGuid() {
        return beneficiarySysGuid;
    }

    public void setBeneficiarySysGuid(String beneficiarySysGuid) {
        this.beneficiarySysGuid = beneficiarySysGuid;
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
