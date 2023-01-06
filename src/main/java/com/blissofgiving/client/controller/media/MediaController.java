package com.blissofgiving.client.controller.media;

import javax.servlet.http.HttpServletRequest;

import com.blissofgiving.client.dto.MediaDTO;
import com.blissofgiving.service.media.impl.MediaClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin(origins = {"http://blissofgiving-react-app.s3-website.us-east-2.amazonaws.com"})
public class MediaController {

    @Autowired
    MediaClientServiceImpl mediaClientService;

    @PostMapping("/api/rest/v1/photos/add")
    public String addPhoto(@RequestParam(value = "origin") String origin, @RequestParam(value = "title") String title, MultipartFile file, final HttpServletRequest request){
        String lastUpdateduser=request.getUserPrincipal().getName();
        MediaDTO mediaDTO = new MediaDTO();
        mediaDTO.setOrigin(origin);
        mediaDTO.setTitle(title);
        String shareLink = mediaClientService.addMedia(mediaDTO,MediaClientServiceImpl.TYPE_PHOTO,lastUpdateduser,file);
        return shareLink;
    }

    @PostMapping("/api/rest/v1/videos/add")
    public String addVideo(@RequestBody MediaDTO mediaDTO,MultipartFile file,final HttpServletRequest request) {
        String lastUpdateduser=request.getUserPrincipal().getName();
        String shareLink = mediaClientService.addMedia(mediaDTO,MediaClientServiceImpl.TYPE_VIDEO,lastUpdateduser,file);
        return shareLink;
    }

    @GetMapping("/api/rest/v1/photos/get")
    public String getPhoto(@RequestParam(value = "photoID") String photoID) throws Exception {
        String mediaLink = mediaClientService.getMediaLink(photoID);
        return mediaLink;
    }
}
