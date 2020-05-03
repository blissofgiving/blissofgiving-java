package com.blissofgiving.client.controller.fundraise;

import com.blissofgiving.client.dto.FundraiseCommentsDTO;
import com.blissofgiving.client.dto.FundraiseDTO;
import com.blissofgiving.exception.BlissofgivingClientException;
import com.blissofgiving.service.fundraise.api.FundraiseClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000"})
public class FundraiseControllerImpl implements FundraiseController {

    @Autowired
    FundraiseClientService fundraiseClientService;

    @RequestMapping(path = "/api/rest/v1/fundraise", method = RequestMethod.GET)
    public FundraiseDTO getUser(@RequestParam(value = "fundraiseID") String fundraiseID) throws BlissofgivingClientException {
        FundraiseDTO fundraiseDTO = fundraiseClientService.getFundraiseByID(fundraiseID);
        return fundraiseDTO;
    }

    @RequestMapping(path = "/api/rest/v1/fundraise", method = RequestMethod.POST)
    public void createFundraise(@RequestBody FundraiseDTO fundraiseDTO) throws BlissofgivingClientException {
        try {
            fundraiseClientService.createFundraise(fundraiseDTO);
        } catch (BlissofgivingClientException e) {
            e.printStackTrace();//TODO Shashi
        }
    }

    @RequestMapping(path = "/api/rest/v1/fundraise", method = RequestMethod.DELETE)
    public void deleteFundraise(@RequestParam(value = "fundraiseID") String fundraiseID) throws BlissofgivingClientException {
        try {
            fundraiseClientService.deleteFundraise(fundraiseID);
        } catch (BlissofgivingClientException e) {
            e.printStackTrace();//TODO Shashi
        }
    }
}
