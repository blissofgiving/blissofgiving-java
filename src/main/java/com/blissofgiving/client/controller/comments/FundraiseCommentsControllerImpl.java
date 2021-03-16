package com.blissofgiving.client.controller.comments;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blissofgiving.client.dto.FundraiseCommentsDTO;
import com.blissofgiving.exception.BlissofgivingClientException;
import com.blissofgiving.service.comments.api.FundraiseCommentsClientService;

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

    @RequestMapping(path = "/api/rest/v1/fundraiseComments", method = RequestMethod.GET)
    public List<FundraiseCommentsDTO> getFundraiseComments(@RequestParam(value = "fundraiseSysGuid") String fundraiseSysGuid, HttpServletRequest request)throws BlissofgivingClientException {
        try {
            String userId = request.getUserPrincipal().getName();
           return commentsClientService.getFundraiseComments(fundraiseSysGuid, userId);
        }catch (BlissofgivingClientException e){
            e.printStackTrace();//TODO Shashi
        }
        return null;
    }
}
