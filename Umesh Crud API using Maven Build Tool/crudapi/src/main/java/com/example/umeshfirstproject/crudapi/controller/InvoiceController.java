package com.example.umeshfirstproject.crudapi.controller;

import com.example.umeshfirstproject.crudapi.model.dto.InvoiceRequestDto;
import com.example.umeshfirstproject.crudapi.model.response.InvoiceCrudResponse;
import com.example.umeshfirstproject.crudapi.model.response.ResponseDto;
import com.example.umeshfirstproject.crudapi.service.InvoiceCrudService;
import com.example.umeshfirstproject.crudapi.utils.Validation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v5/Umeshcrud_operations")
@RequiredArgsConstructor
public class InvoiceController {

    private final InvoiceCrudService invoiceCrudService;

    private final Validation validation;

    @GetMapping(value = "/invoice", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDto> fetchInvoice(@RequestParam("user_id") String userId) throws Exception {
        if (StringUtils.isEmpty(userId)) {
            var responseDto =
                    ResponseDto.builder()
                            .status(HttpStatus.NOT_FOUND.value())
                            .data(null)
                            .message("failure")
                            .error("Invalid User ID : Cannot be fetched")
                            .build();
            return ResponseEntity.status(responseDto.getStatus()).body(responseDto);
        }
        InvoiceCrudResponse response;
        try{
             response = invoiceCrudService.getInvoiceResponseByUserId(userId);
        }

        catch(Exception e)
        {
            var responseDto =
                    ResponseDto.builder()
                            .status(HttpStatus.NOT_FOUND.value())
                            .data(null)
                            .message("failure")
                            .error("Invalid User ID : Cannot be fetched")
                            .build();

            return ResponseEntity.status(responseDto.getStatus()).body(responseDto);
        }

        var responseDto =
                ResponseDto.builder()
                        .status(HttpStatus.OK.value())
                        .data(response)
                        .message("success")
                        .build();

        return ResponseEntity.status(responseDto.getStatus()).body(responseDto);


    }

    @PostMapping(value = "/invoice",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDto> createInvoice(@RequestBody InvoiceRequestDto invoiceRequestDto) throws Exception {

//        String regex = "^$|[(6-9){1} (0-9){9}]{10}";
//        Pattern pattern = Pattern.compile(regex);
//        Matcher matcher = pattern.matcher(invoiceInfo.getMobileNo());

        if(! validation.validateMobileNo(invoiceRequestDto.getMobileNo())) {
            var responseDto =
                    ResponseDto.builder()
                            .status(HttpStatus.NOT_FOUND.value())
                            .data(null)
                            .error("Invalid Mobile Number Entered")
                            .build();

            return ResponseEntity.status(responseDto.getStatus()).body(responseDto);
        }
        var response = invoiceCrudService.createInvoicing(invoiceRequestDto);

        var responseDto =
                ResponseDto.builder()
                        .status(HttpStatus.OK.value())
                        .data(response)
                        .message("success")
                        .build();

        return ResponseEntity.status(responseDto.getStatus()).body(responseDto);
    }

    @PutMapping(value = "/invoice",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDto> updateInvoice(@RequestParam("user_id") String userId,
                                                      @RequestBody InvoiceRequestDto invoiceRequestDto) throws Exception {
//        String regex = "^$|[(6-9){1} (0-9){9}]{10}";
//        Pattern pattern = Pattern.compile(regex);
//        Matcher matcher = pattern.matcher(invoiceInfo.getMobileNo());

        if(! validation.validateMobileNo(invoiceRequestDto.getMobileNo())) {
            var responseDto =
                    ResponseDto.builder()
                            .status(HttpStatus.NOT_FOUND.value())
                            .data(null)
                            .error("Invalid Mobile Number Entered")
                            .build();

            return ResponseEntity.status(responseDto.getStatus()).body(responseDto);
        }
        var response = invoiceCrudService.updateInvoiceInfo(userId, invoiceRequestDto);

        var responseDto =
                ResponseDto.builder()
                        .status(HttpStatus.OK.value())
                        .data(response)
                        .message("success")
                        .build();

        return ResponseEntity.status(responseDto.getStatus()).body(responseDto);
    }

    @DeleteMapping(value = "/invoice",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDto> deleteMapping(@RequestParam("user_id") String userId) throws Exception {
        try{
            invoiceCrudService.deleteInvoice(userId);
        }

        catch(Exception e){
            var responseDto =
                    ResponseDto.builder()
                            .status(HttpStatus.NOT_FOUND.value())
                            .data(null)
                            .message("failure")
                            .error("Invalid User ID : Cannot be deleted")
                            .build();

            return ResponseEntity.status(responseDto.getStatus()).body(responseDto);
        }


        var responseDto =
                ResponseDto.builder()
                        .status(HttpStatus.OK.value())
                        .data(null)
                        .message("success")
                        .build();

        return ResponseEntity.status(responseDto.getStatus()).body(responseDto);
    }


}
