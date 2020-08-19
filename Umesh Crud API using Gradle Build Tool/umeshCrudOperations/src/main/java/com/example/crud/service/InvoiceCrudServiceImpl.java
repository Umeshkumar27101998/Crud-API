package com.example.crud.service;

import com.example.crud.model.dto.InvoiceInfo;
import com.example.crud.model.entity.UserInvoiceEntity;
import com.example.crud.model.response.InvoiceCrudResponse;
import com.example.crud.repository.UserInvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class InvoiceCrudServiceImpl implements InvoiceCrudService{

    private final UserInvoiceRepository userInvoiceRepository;

    @Override
    public InvoiceCrudResponse getInvoiceResponseByUserId(String userId) throws Exception {
        var invoiceDetailsFromDB = userInvoiceRepository.findById(userId);
        if (invoiceDetailsFromDB.isPresent()){
            var invoiceDetails = invoiceDetailsFromDB.get();
            return InvoiceCrudResponse.builder()
                    .userID(invoiceDetails.getUserID())
                    .amount(invoiceDetails.getAmount())
                    .name(invoiceDetails.getName())
                    .mobileNo(invoiceDetails.getMobileNo())
                    .build();
        }
        throw new Exception("User Invoice Not found from database");
    }

    @Override
    public InvoiceCrudResponse createInvoicing(InvoiceInfo invoiceInfo) throws Exception {

        var userInvoiceEntity = UserInvoiceEntity.builder()
                .userID(invoiceInfo.getUserID())
                .amount(invoiceInfo.getAmount())
                .name(invoiceInfo.getName())
                .mobileNo(invoiceInfo.getMobileNo())
                .build();

        userInvoiceRepository.save(userInvoiceEntity);

        return InvoiceCrudResponse.builder()
                .userID(userInvoiceEntity.getUserID())
                .amount(userInvoiceEntity.getAmount())
                .name(userInvoiceEntity.getName())
                .mobileNo(userInvoiceEntity.getMobileNo())
                .build();
    }

    @Override
    public InvoiceCrudResponse updateInvoiceInfo(String userId, InvoiceInfo invoiceInfo) throws Exception {
        var userInvoiceEntity = userInvoiceRepository.findById(userId)
                .orElseThrow(() -> new Exception("User Not found in db ::" + userId));

        userInvoiceEntity.setAmount(invoiceInfo.getAmount());
        userInvoiceEntity.setName(invoiceInfo.getName());
        userInvoiceEntity.setMobileNo(invoiceInfo.getMobileNo());
        userInvoiceRepository.save(userInvoiceEntity);

        return InvoiceCrudResponse.builder()
                .userID(userInvoiceEntity.getUserID())
                .amount(userInvoiceEntity.getAmount())
                .name(userInvoiceEntity.getName())
                .mobileNo(userInvoiceEntity.getMobileNo())
                .build();
    }

    @Override
    public void deleteInvoice(String userId) throws Exception {
        var userInvoiceEntity = userInvoiceRepository.findById(userId)
                .orElseThrow(() -> new Exception("User Not found in db ::" + userId));

        userInvoiceRepository.delete(userInvoiceEntity);
    }
}
