package com.blissofgiving.client.controller.comments;

import com.blissofgiving.client.dto.FundraiseCommentsDTO;
import com.blissofgiving.exception.BlissofgivingClientException;
import com.blissofgiving.service.comments.api.CommentsClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://blissofgiving-react-app.s3-website.us-east-2.amazonaws.com"})
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

    @RequestMapping(path = "/api/rest/v1/fundraiseComment", method = RequestMethod.POST)
    public void createFundraiseComments(@RequestBody FundraiseCommentsDTO fundraiseCommentsDTO) throws BlissofgivingClientException {
        try {
            commentsClientService.createFundraiseComment(fundraiseCommentsDTO);
        } catch (BlissofgivingClientException e) {
            e.printStackTrace();//TODO Shashi
        }
    }
}
