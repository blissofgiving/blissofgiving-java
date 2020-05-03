package com.blissofgiving.service.media.impl;

import com.blissofgiving.exception.BlissofgivingRuntimeException;
import com.blissofgiving.exception.BlissofgivingServiceException;
import com.blissofgiving.model.Photos;
import com.blissofgiving.model.Video;
import com.blissofgiving.repository.PhotoRepository;
import com.blissofgiving.service.media.api.MediaService;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.gridfs.model.GridFSFile;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class MediaServiceImpl implements MediaService {

    @Autowired
    private GridFsTemplate gridFsTemplate;

    @Autowired
    private GridFsOperations operations;

    @Autowired
    private PhotoRepository photoRepo;

    @Override
    public String addMedia(String title, String type, MultipartFile file)throws BlissofgivingServiceException {
        String mediaObjectId=null;
        try {
            if (type.equalsIgnoreCase("PHOTO")) {
                mediaObjectId = addPhoto(title, file);
            } else {
                mediaObjectId = addVideo(title, file);
            }
        }catch(Exception e){
            throw new BlissofgivingServiceException(e);
        }
        return mediaObjectId;
    }

    @Override
    public String addVideo(String title, MultipartFile file) throws IOException {
        DBObject metaData = new BasicDBObject();
        metaData.put("type", "video");
        metaData.put("title", title);
        ObjectId id = gridFsTemplate.store(
                file.getInputStream(), file.getName(), file.getContentType(), metaData);
        return id.toString();
    }

    @Override
    public String addPhoto(String title, MultipartFile file) throws IOException {
        Photos photo = new Photos(title);
        photo.setImage(
                new Binary(BsonBinarySubType.BINARY, file.getBytes()));
        photo = photoRepo.insert(photo);
        return photo.getId();
    }

    @Override
    public Video getVideo(String id) throws IllegalStateException, IOException {
        GridFSFile file = gridFsTemplate.findOne(new Query(Criteria.where("_id").is(id)));
        Video video = new Video();
        video.setTitle(file.getMetadata().get("title").toString());
        video.setStream(operations.getResource(file).getInputStream());
        return video;
    }

    @Override
    public Photos getPhoto(String id) {
        return photoRepo.findById(id).get();
    }
}
