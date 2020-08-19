package com.example.umeshfirstproject.crudapi.service;

import com.example.umeshfirstproject.crudapi.model.dto.InvoiceRequestDto;
import com.example.umeshfirstproject.crudapi.model.entity.InvoiceEntity;
import com.example.umeshfirstproject.crudapi.model.response.InvoiceCrudResponse;
import com.example.umeshfirstproject.crudapi.repository.UserInvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
    public InvoiceCrudResponse createInvoicing(InvoiceRequestDto invoiceRequestDto) throws Exception {

        var invoiceEntity = InvoiceEntity.builder()
                .userID(invoiceRequestDto.getUserID())
                .amount(invoiceRequestDto.getAmount())
                .name(invoiceRequestDto.getName())
                .mobileNo(invoiceRequestDto.getMobileNo())
                .build();

        userInvoiceRepository.save(invoiceEntity);

        return InvoiceCrudResponse.builder()
                .userID(invoiceEntity.getUserID())
                .amount(invoiceEntity.getAmount())
                .name(invoiceEntity.getName())
                .mobileNo(invoiceEntity.getMobileNo())
                .build();
    }

    @Override
    public InvoiceCrudResponse updateInvoiceInfo(String userId, InvoiceRequestDto invoiceRequestDto) throws Exception {
        var invoiceEntity = userInvoiceRepository.findById(userId)
                .orElseThrow(() -> new Exception("User Not found in db ::" + userId));

        invoiceEntity.setAmount(invoiceRequestDto.getAmount());
        invoiceEntity.setName(invoiceRequestDto.getName());
        invoiceEntity.setMobileNo(invoiceRequestDto.getMobileNo());
        userInvoiceRepository.save(invoiceEntity);

        return InvoiceCrudResponse.builder()
                .userID(invoiceEntity.getUserID())
                .amount(invoiceEntity.getAmount())
                .name(invoiceEntity.getName())
                .mobileNo(invoiceEntity.getMobileNo())
                .build();
    }

    @Override
    public void deleteInvoice(String userId) throws Exception {
        var invoiceEntity = userInvoiceRepository.findById(userId)
                .orElseThrow(() -> new Exception("User Not found in db ::" + userId));

        userInvoiceRepository.delete(invoiceEntity);
    }


}
