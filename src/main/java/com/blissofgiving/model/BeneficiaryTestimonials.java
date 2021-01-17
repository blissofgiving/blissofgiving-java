package com.blissofgiving.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Timestamp;

@Document(collection = "BENEFICIARY_TESTIMONIALS")
public class BeneficiaryTestimonials {
    @Id
    private String testimonialSysGuid;
    @Indexed
    private String fundraiseSysGuid;
    @Indexed
    private String beneficiarysysGuid;
    private Double testimonialLikes;
    private String testimonialData;
    private String lastUpdateUser;
    private Timestamp lastUpdateTimestamp;

    public String getTestimonialSysGuid() {
        return testimonialSysGuid;
    }

    public void setTestimonialSysGuid(String testimonialSysGuid) {
        this.testimonialSysGuid = testimonialSysGuid;
    }

    public String getFundraiseSysGuid() {
        return fundraiseSysGuid;
    }

    public void setFundraiseSysGuid(String fundraiseSysGuid) {
        this.fundraiseSysGuid = fundraiseSysGuid;
    }

    public String getBeneficiarysysGuid() {
        return beneficiarysysGuid;
    }

    public void setBeneficiarysysGuid(String beneficiarysysGuid) {
        this.beneficiarysysGuid = beneficiarysysGuid;
    }

    public Double getTestimonialLikes() {
        return testimonialLikes;
    }

    public void setTestimonialLikes(Double testimonialLikes) {
        this.testimonialLikes = testimonialLikes;
    }

    public String getTestimonialData() {
        return testimonialData;
    }

    public void setTestimonialData(String testimonialData) {
        this.testimonialData = testimonialData;
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
