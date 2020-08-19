package com.example.umeshfirstproject.crudapi.service;

import com.example.umeshfirstproject.crudapi.model.dto.InvoiceRequestDto;
import com.example.umeshfirstproject.crudapi.model.response.InvoiceCrudResponse;
import com.example.umeshfirstproject.crudapi.model.dto.InvoiceRequestDto;
import com.example.umeshfirstproject.crudapi.model.response.InvoiceCrudResponse;

public interface InvoiceCrudService {

    InvoiceCrudResponse getInvoiceResponseByUserId(String userId) throws Exception;

    InvoiceCrudResponse createInvoicing(InvoiceRequestDto invoiceInfo) throws Exception;

    InvoiceCrudResponse updateInvoiceInfo(String userId, InvoiceRequestDto invoiceInfo) throws Exception;

    void deleteInvoice(String userId) throws Exception;
}
