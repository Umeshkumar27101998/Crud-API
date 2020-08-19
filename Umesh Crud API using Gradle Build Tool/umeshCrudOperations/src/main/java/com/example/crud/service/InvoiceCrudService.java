package com.example.crud.service;

import com.example.crud.model.dto.InvoiceInfo;
import com.example.crud.model.response.InvoiceCrudResponse;

public interface InvoiceCrudService {

    InvoiceCrudResponse getInvoiceResponseByUserId(String userId) throws Exception;

    InvoiceCrudResponse createInvoicing(InvoiceInfo invoiceInfo) throws Exception;

    InvoiceCrudResponse updateInvoiceInfo(String userId, InvoiceInfo invoiceInfo) throws Exception;

    void deleteInvoice(String userId) throws Exception;
}
