package com.blissofgiving.client.dto;

import org.springframework.web.multipart.MultipartFile;

import java.sql.Timestamp;

public class MediaDTO {

    private String title;
    private MultipartFile file;
    private String mediaSysGuid;
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

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public String getMediaSysGuid() {
        return mediaSysGuid;
    }

    public void setMediaSysGuid(String mediaSysGuid) {
        this.mediaSysGuid = mediaSysGuid;
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
