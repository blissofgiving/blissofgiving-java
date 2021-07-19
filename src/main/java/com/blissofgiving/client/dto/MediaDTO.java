package com.blissofgiving.client.dto;

import java.sql.Timestamp;

public class MediaDTO {

    private String title;
    private String mediaLink;
    private String origin;
    private String sourceSysGuid;
    private String lastUpdateUser;
    private Timestamp lastUpdateTimestamp;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMediaLink() {
        return mediaLink;
    }

    public void setMediaLink(String mediaLink) {
        this.mediaLink = mediaLink;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getSourceSysGuid() {
        return sourceSysGuid;
    }

    public void setSourceSysGuid(String sourceSysGuid) {
        this.sourceSysGuid = sourceSysGuid;
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
