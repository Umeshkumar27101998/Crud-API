package com.example.crud.controller;

import com.example.crud.model.dto.InvoiceInfo;
import com.example.crud.model.response.CrudResponse;
import com.example.crud.service.InvoiceCrudService;
import com.example.crud.utils.Validation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


@RestController
@RequestMapping("v2/Crud_operations")
@RequiredArgsConstructor
public class InvoiceCrudController {

    private final InvoiceCrudService invoiceCrudService;

    private final Validation validation;

    @GetMapping(value = "/invoice", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CrudResponse> fetchInvoice(@RequestParam("user_id") String userId) throws Exception {
        if (StringUtils.isEmpty(userId)) {
            throw new Exception("user_id is either empty or null");
        }

        var response = invoiceCrudService.getInvoiceResponseByUserId(userId);

        var crudResponse =
                CrudResponse.builder()
                        .status(HttpStatus.OK.value())
                        .data(response)
                        .message("success")
                        .build();

        return ResponseEntity.status(crudResponse.getStatus()).body(crudResponse);
    }

    @PostMapping(value = "/invoice",
                produces = MediaType.APPLICATION_JSON_VALUE,
                consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CrudResponse> createInvoice(@RequestBody InvoiceInfo invoiceInfo) throws Exception {

//        String regex = "^$|[(6-9){1} (0-9){9}]{10}";
//        Pattern pattern = Pattern.compile(regex);
//        Matcher matcher = pattern.matcher(invoiceInfo.getMobileNo());

        if(! validation.validateMobileNo(invoiceInfo.getMobileNo())) {
            var crudResponse =
                    CrudResponse.builder()
                            .status(HttpStatus.NOT_FOUND.value())
                            .data(null)
                            .error("Invalid Mobile Number Entered")
                            .build();

            return ResponseEntity.status(crudResponse.getStatus()).body(crudResponse);
        }
        var response = invoiceCrudService.createInvoicing(invoiceInfo);

        var crudResponse =
                CrudResponse.builder()
                        .status(HttpStatus.OK.value())
                        .data(response)
                        .message("success")
                        .build();

        return ResponseEntity.status(crudResponse.getStatus()).body(crudResponse);
    }

    @PutMapping(value = "/invoice",
                produces = MediaType.APPLICATION_JSON_VALUE,
                consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CrudResponse> updateInvoice(@RequestParam("user_id") String userId,
                                                      @RequestBody InvoiceInfo invoiceInfo) throws Exception {
//        String regex = "^$|[(6-9){1} (0-9){9}]{10}";
//        Pattern pattern = Pattern.compile(regex);
//        Matcher matcher = pattern.matcher(invoiceInfo.getMobileNo());

        if(! validation.validateMobileNo(invoiceInfo.getMobileNo())) {
            var crudResponse =
                    CrudResponse.builder()
                            .status(HttpStatus.NOT_FOUND.value())
                            .data(null)
                            .error("Invalid Mobile Number Entered")
                            .build();

            return ResponseEntity.status(crudResponse.getStatus()).body(crudResponse);
        }
        var response = invoiceCrudService.updateInvoiceInfo(userId, invoiceInfo);

        var crudResponse =
                CrudResponse.builder()
                        .status(HttpStatus.OK.value())
                        .data(response)
                        .message("success")
                        .build();

        return ResponseEntity.status(crudResponse.getStatus()).body(crudResponse);
    }

    @DeleteMapping(value = "/invoice",
                   produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CrudResponse> deleteMapping(@RequestParam("user_id") String userId) throws Exception {
        invoiceCrudService.deleteInvoice(userId);

        var crudResponse =
                CrudResponse.builder()
                        .status(HttpStatus.OK.value())
                        .data(null)
                        .message("success")
                        .build();

        return ResponseEntity.status(crudResponse.getStatus()).body(crudResponse);
    }
}
