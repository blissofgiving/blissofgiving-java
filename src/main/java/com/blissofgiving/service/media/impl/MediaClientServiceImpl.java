package com.blissofgiving.service.media.impl;

import com.blissofgiving.client.dto.MediaDTO;
import com.blissofgiving.model.BeneficiaryMedia;
import com.blissofgiving.model.FundraiseMedia;
import com.blissofgiving.service.media.api.BeneficiaryMediaService;
import com.blissofgiving.service.media.api.FundraiseMediaService;
import com.blissofgiving.service.media.api.MediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Timestamp;

@Service
public class MediaClientServiceImpl {

    public static final String TYPE_PHOTO = "PHOTO";
    public static final String TYPE_VIDEO = "VIDEO";

    @Autowired
    MediaService mediaService;

    @Autowired
    BeneficiaryMediaService beneficiaryMediaService;

    @Autowired
    FundraiseMediaService fundraiseMediaService;

    public String addMedia(MediaDTO mediaDTO, String imagetype, String lastUpdatedUser, MultipartFile mediafile) {
        String mediaId = mediaService.addMedia(mediaDTO.getTitle(), imagetype, mediafile);
        mediaDTO.setLastUpdateUser(lastUpdatedUser);
        mediaDTO.setMediaSysGuid(mediaId);
        if ("FUNDRAISE".equalsIgnoreCase(mediaDTO.getOrigin())) {
            FundraiseMedia fundraiseMedia = convertToFundraiseMedia(mediaDTO);
            fundraiseMediaService.createFundraiseMedia(fundraiseMedia);
        }
        if ("BENEFICIARY".equalsIgnoreCase(mediaDTO.getOrigin())) {
            BeneficiaryMedia beneficiaryMedia = convertToBeneficiaryMedia(mediaDTO);
            beneficiaryMediaService.createBeneficiaryMedia(beneficiaryMedia);
        }
        return mediaId;
    }

    private FundraiseMedia convertToFundraiseMedia(MediaDTO mediaDTO) {
        FundraiseMedia media = new FundraiseMedia();
        media.setMediaSysGuid(mediaDTO.getMediaSysGuid());
        media.setFundraiseSysGuid(mediaDTO.getSourceSysGuid());
        media.setLastUpdateUser(mediaDTO.getLastUpdateUser());
        media.setLastUpdateTimestamp(new Timestamp(System.currentTimeMillis()));
        return media;
    }

    private BeneficiaryMedia convertToBeneficiaryMedia(MediaDTO mediaDTO) {
        BeneficiaryMedia media = new BeneficiaryMedia();
        media.setMediaSysGuid(mediaDTO.getMediaSysGuid());
        media.setBeneficiarySysGuid(mediaDTO.getSourceSysGuid());
        media.setLastUpdateUser(mediaDTO.getLastUpdateUser());
        media.setLastUpdateTimestamp(new Timestamp(System.currentTimeMillis()));
        return media;
    }
}
