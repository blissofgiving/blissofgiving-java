package com.blissofgiving.client.controller.media;

import com.blissofgiving.client.dto.MediaDTO;
import com.blissofgiving.service.media.api.MediaService;
import com.blissofgiving.service.media.impl.MediaClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
@CrossOrigin(origins = {"http://localhost:3000"})
public class MediaController {

    @Autowired
    MediaClientServiceImpl mediaClientService;

    @PostMapping("/photos/add")
    public String addPhoto(@RequestBody MediaDTO mediaDTO,final HttpServletRequest request)
            throws IOException {
        String lastUpdateduser=request.getUserPrincipal().getName();
        String shareLink = mediaClientService.addMedia(mediaDTO,MediaClientServiceImpl.TYPE_PHOTO,lastUpdateduser);
        return shareLink;
    }

    @PostMapping("/videos/add")
    public String addVideo(@RequestBody MediaDTO mediaDTO,final HttpServletRequest request) throws IOException {
        String lastUpdateduser=request.getUserPrincipal().getName();
        String shareLink = mediaClientService.addMedia(mediaDTO,MediaClientServiceImpl.TYPE_VIDEO,lastUpdateduser);
        return shareLink;
    }
}
