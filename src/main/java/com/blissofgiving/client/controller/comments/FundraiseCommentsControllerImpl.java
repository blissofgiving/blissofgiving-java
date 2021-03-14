package com.blissofgiving.client.controller.comments;

import com.blissofgiving.client.dto.FundraiseCommentsDTO;
import com.blissofgiving.exception.BlissofgivingClientException;
import com.blissofgiving.service.comments.api.FundraiseCommentsClientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin(origins = {"http://blissofgiving-react-app.s3-website.us-east-2.amazonaws.com"})
public class FundraiseCommentsControllerImpl {

    @Autowired
    private FundraiseCommentsClientService commentsClientService;

    @RequestMapping(path = "/api/rest/v1/fundraiseComments", method = RequestMethod.POST)
    public void createFundraiseComments(@RequestBody List<FundraiseCommentsDTO> fundraiseCommentsDTOList, HttpServletRequest request) throws BlissofgivingClientException {
        try {
            String userId = request.getUserPrincipal().getName();
            commentsClientService.createFundraiseComments(fundraiseCommentsDTOList, userId);
        } catch (BlissofgivingClientException e) {
            e.printStackTrace();//TODO Shashi
        }
    }

    @RequestMapping(path = "/api/rest/v1/fundraiseComment", method = RequestMethod.POST)
    public void createFundraiseComments(@RequestBody FundraiseCommentsDTO fundraiseCommentsDTO, HttpServletRequest request) throws BlissofgivingClientException {
        try {
            String userId = request.getUserPrincipal().getName();
            commentsClientService.createFundraiseComment(fundraiseCommentsDTO, userId);
        } catch (BlissofgivingClientException e) {
            e.printStackTrace();//TODO Shashi
        }
    }
}
