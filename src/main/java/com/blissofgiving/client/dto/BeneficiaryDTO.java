package com.blissofgiving.client.dto;

import java.sql.Timestamp;

public class BeneficiaryDTO {

    private String beneficiarySysGuid;
    private String firstName;
    private String lastName;
    private String fundraiseSysGuid;
    private String beneficiaryType;
    private String beneficiaryDetails;
    private String createdUser;
    private String lastUpdateUser;
    private Timestamp createdTimestamp;
    private Timestamp lastUpdateTimestamp;

    public String getBeneficiarySysGuid() {
        return beneficiarySysGuid;
    }

    public void setBeneficiarySysGuid(String beneficiarySysGuid) {
        this.beneficiarySysGuid = beneficiarySysGuid;
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

    public String getFundraiseSysGuid() {
        return fundraiseSysGuid;
    }

    public void setFundraiseSysGuid(String fundraiseSysGuid) {
        this.fundraiseSysGuid = fundraiseSysGuid;
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
