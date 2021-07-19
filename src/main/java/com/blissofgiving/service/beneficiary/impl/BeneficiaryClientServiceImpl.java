package com.blissofgiving.service.beneficiary.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blissofgiving.client.dto.BeneficiaryDTO;
import com.blissofgiving.client.dto.BeneficiaryPaymentDTO;
import com.blissofgiving.dynamodbmodel.Beneficiary;
import com.blissofgiving.dynamodbmodel.BeneficiaryPayment;
import com.blissofgiving.exception.BlissofgivingClientException;
import com.blissofgiving.exception.BlissofgivingServiceException;
import com.blissofgiving.paymentgetway.PaymentService;
import com.blissofgiving.service.beneficiary.api.BeneficiaryClientService;
import com.blissofgiving.service.beneficiary.api.BeneficiaryService;

@Service
public class BeneficiaryClientServiceImpl implements BeneficiaryClientService {

    @Autowired
    private BeneficiaryService beneficiaryService;

    @Autowired
    PaymentService paymentService;

    @Override
    public String createBeneficiary(final BeneficiaryDTO beneficiaryDTO) throws BlissofgivingServiceException {
        try {
            Beneficiary beneficiary = new Beneficiary();
            BeanUtils.copyProperties(beneficiaryDTO, beneficiary);
            return beneficiaryService.createBeneficiary(beneficiary);
        } catch (Exception e) {
            throw new BlissofgivingServiceException(e);
        }
    }

    @Override
    public BeneficiaryDTO getBeneficiaryById(String beneficiarySysGuid, String userId) throws BlissofgivingClientException {
        Beneficiary beneficiary = beneficiaryService.getBeneficiaryById(beneficiarySysGuid);

        BeneficiaryDTO beneficiaryDTO = new BeneficiaryDTO();
        BeanUtils.copyProperties(beneficiary, beneficiaryDTO);
        return beneficiaryDTO;
    }

    @Override
    public BeneficiaryDTO getBeneficiaryWithPaymentById(String beneficiarySysGuid, String userId) throws BlissofgivingClientException {
        // Get beneficiary info
        Beneficiary beneficiary = beneficiaryService.getBeneficiaryById(beneficiarySysGuid);
        BeneficiaryDTO beneficiaryDTO = new BeneficiaryDTO();
        BeanUtils.copyProperties(beneficiary, beneficiaryDTO);

        //Get beneficiary payments
        List<BeneficiaryPayment> beneficiaryPayments = paymentService.getBeneficiaryPayments(beneficiarySysGuid);

        List<BeneficiaryPaymentDTO> beneficiaryPaymentDTOs = new ArrayList<>();
        BeneficiaryPaymentDTO beneficiaryPaymentDTO = new BeneficiaryPaymentDTO();
        beneficiaryPayments.forEach(beneficiaryPayment -> {
            BeanUtils.copyProperties(beneficiaryPayment, beneficiaryPaymentDTO);
            beneficiaryPaymentDTOs.add(beneficiaryPaymentDTO);
        });
        beneficiaryDTO.setBeneficiaryPaymentDTOs(beneficiaryPaymentDTOs);

        return beneficiaryDTO;
    }

    @Override
    public void updateBeneficiary(BeneficiaryDTO beneficiaryDTO, String userId) throws BlissofgivingClientException {
        try {
            Beneficiary beneficiary = new Beneficiary();
            BeanUtils.copyProperties(beneficiaryDTO, beneficiary);
            beneficiary.setLastUpdateUser(userId);
            beneficiaryService.updateBeneficiary(beneficiary);
        } catch (Exception e) {
            throw new BlissofgivingServiceException(e);
        }
    }

    @Override
    public void deleteBeneficiary(String beneficiarySysGuid) throws BlissofgivingClientException {
        beneficiaryService.deleteBeneficiary(beneficiarySysGuid);
    }
}
