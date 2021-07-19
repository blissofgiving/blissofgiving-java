package com.blissofgiving.client.controller.beneficiary;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blissofgiving.client.dto.BeneficiaryDTO;
import com.blissofgiving.exception.BlissofgivingClientException;
import com.blissofgiving.service.beneficiary.api.BeneficiaryClientService;

@RestController
@CrossOrigin(origins = {"http://blissofgiving-react-app.s3-website.us-east-2.amazonaws.com"})
public class BeneficiaryController {

	@Autowired
	BeneficiaryClientService beneficiaryClientService;

	@RequestMapping(path = "/api/rest/v1/beneficiary", method = RequestMethod.GET)
	public BeneficiaryDTO getBeneficiaryById(@RequestParam(value = "beneficiarySysGuid") String beneficiarySysGuid, HttpServletRequest request) throws BlissofgivingClientException {
		String userId = request.getUserPrincipal().getName();
		BeneficiaryDTO beneficiaryDTO = beneficiaryClientService.getBeneficiaryById(beneficiarySysGuid, userId);
		return beneficiaryDTO;
	}

	@RequestMapping(path = "/api/rest/v1/beneficiary/payments", method = RequestMethod.GET)
	public BeneficiaryDTO getBeneficiaryWithPaymentById(@RequestParam(value = "beneficiarySysGuid") String beneficiarySysGuid, HttpServletRequest request) throws BlissofgivingClientException {
		String userId = request.getUserPrincipal().getName();
		BeneficiaryDTO beneficiaryDTO = beneficiaryClientService.getBeneficiaryWithPaymentById(beneficiarySysGuid, userId);
		return beneficiaryDTO;
	}

	@RequestMapping(path = "/api/rest/v1/beneficiary", method = RequestMethod.POST)
	public String createBeneficiary(@RequestBody BeneficiaryDTO beneficiaryDTO, HttpServletRequest request ){
		return beneficiaryClientService.createBeneficiary(beneficiaryDTO);
	}

	@RequestMapping(path = "/api/rest/v1/beneficiary", method = RequestMethod.PUT)
	public void updateBeneficiary(@RequestBody BeneficiaryDTO beneficiaryDTO, HttpServletRequest request ){
		String userId = request.getUserPrincipal().getName();
		beneficiaryClientService.updateBeneficiary(beneficiaryDTO, userId);
	}

	@RequestMapping(path = "/api/rest/v1/beneficiary", method = RequestMethod.DELETE)
	public void deleteBeneficiary(@RequestParam(value = "beneficiarySysGuid") String beneficiarySysGuid) throws BlissofgivingClientException {
		try {
			beneficiaryClientService.deleteBeneficiary(beneficiarySysGuid);
		} catch (BlissofgivingClientException e) {
			e.printStackTrace();//TODO Shashi
		}
	}
}
