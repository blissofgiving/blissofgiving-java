package com.blissofgiving.client.controller.fundraise;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blissofgiving.client.dto.FundraiseDTO;
import com.blissofgiving.exception.BlissofgivingClientException;
import com.blissofgiving.service.fundraise.api.FundraiseClientService;

@RestController
@CrossOrigin(origins = {"http://blissofgiving-react-app.s3-website.us-east-2.amazonaws.com"})
public class FundraiseControllerImpl implements FundraiseController {

    @Autowired
    FundraiseClientService fundraiseClientService;

    @RequestMapping(path = "/api/rest/v1/fundraise", method = RequestMethod.GET)
    public FundraiseDTO getFundraiseByID(@RequestParam(value = "fundraiseId") String fundraiseId, HttpServletRequest request) throws BlissofgivingClientException {
        String userId = request.getUserPrincipal().getName();
        FundraiseDTO fundraiseDTO = fundraiseClientService.getFundraiseByID(fundraiseId, userId);
        return fundraiseDTO;
    }

    @RequestMapping(path = "/api/rest/v1/fundraise/userId", method = RequestMethod.GET)
    public List<FundraiseDTO> getActiveFundraisesByUserId(@RequestParam(value = "fundraiseCreatedUser") String fundraiseCreatedUser,@RequestParam(value = "active") Boolean active) throws BlissofgivingClientException {
        List<FundraiseDTO> fundraiseDTOList = fundraiseClientService.getActiveFundraisesByUserName(fundraiseCreatedUser,active);
        return fundraiseDTOList;
    }

    @RequestMapping(path = "/api/rest/v1/fundraise", method = RequestMethod.POST)
    public String createFundraise(@RequestBody FundraiseDTO fundraiseDTO, HttpServletRequest request) throws BlissofgivingClientException {
        String fundraiseId = null;
        try {
            String user = request.getUserPrincipal().getName();
            fundraiseId = fundraiseClientService.createFundraise(fundraiseDTO, user);
        } catch (BlissofgivingClientException e) {
            e.printStackTrace();//TODO Shashi
        }
        return fundraiseId;
    }

    @RequestMapping(path = "/api/rest/v1/fundraise", method = RequestMethod.PUT)
    public void updateFundraise(@RequestBody FundraiseDTO fundraiseDTO, HttpServletRequest request) throws BlissofgivingClientException {
        String fundraiseId = null;
        try {
            String user = request.getUserPrincipal().getName();
             fundraiseClientService.updateFundraise(fundraiseDTO, user);
        } catch (BlissofgivingClientException e) {
            e.printStackTrace();//TODO Shashi
        }
    }

    @RequestMapping(path = "/api/rest/v1/fundraise", method = RequestMethod.DELETE)
    public void deleteFundraise(@RequestParam(value = "fundraiseId") String fundraiseId) throws BlissofgivingClientException {
        try {
            fundraiseClientService.deleteFundraise(fundraiseId);
        } catch (BlissofgivingClientException e) {
            e.printStackTrace();//TODO Shashi
        }
    }
}
