package com.blissofgiving.client.controller.fundraise;

import com.blissofgiving.client.dto.FundraiseDTO;
import com.blissofgiving.exception.BlissofgivingClientException;
import com.blissofgiving.service.fundraise.api.FundraiseClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000"})
public class FundraiseControllerImpl implements FundraiseController {

    @Autowired
    FundraiseClientService fundraiseClientService;

    @RequestMapping(path = "/api/rest/v1/fundraise", method = RequestMethod.GET)
    public FundraiseDTO getFundraiseByID(@RequestParam(value = "fundraiseID") String fundraiseID) throws BlissofgivingClientException {
        FundraiseDTO fundraiseDTO = fundraiseClientService.getFundraiseByID(fundraiseID);
        return fundraiseDTO;
    }

    @RequestMapping(path = "/api/rest/v1/fundraise/username", method = RequestMethod.GET)
    public List<FundraiseDTO> getActiveFundraisesByUserName(@RequestParam(value = "fundraiseCreatedUser") String fundraiseCreatedUser,@RequestParam(value = "active") Boolean active) throws BlissofgivingClientException {
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

    @RequestMapping(path = "/api/rest/v1/fundraise", method = RequestMethod.DELETE)
    public void deleteFundraise(@RequestParam(value = "fundraiseID") String fundraiseID) throws BlissofgivingClientException {
        try {
            fundraiseClientService.deleteFundraise(fundraiseID);
        } catch (BlissofgivingClientException e) {
            e.printStackTrace();//TODO Shashi
        }
    }
}
