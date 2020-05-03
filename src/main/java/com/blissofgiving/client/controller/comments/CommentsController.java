package com.blissofgiving.client.controller.comments;

import com.blissofgiving.client.dto.FundraiseCommentsDTO;
import com.blissofgiving.exception.BlissofgivingClientException;
import com.blissofgiving.service.comments.api.CommentsClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000"})
public class CommentsController {

    @Autowired
    private CommentsClientService commentsClientService;

    @RequestMapping(path = "/api/rest/v1/fundraiseComments", method = RequestMethod.POST)
    public void createFundraiseComments(@RequestBody List<FundraiseCommentsDTO> fundraiseCommentsDTOList) throws BlissofgivingClientException {
        try {
            commentsClientService.createFundraiseComments(fundraiseCommentsDTOList);
        } catch (BlissofgivingClientException e) {
            e.printStackTrace();//TODO Shashi
        }
    }
}
