package com.example.crud.utils;

import com.example.crud.model.response.CrudResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class Validation {
    public boolean validateMobileNo(String mobileNo)
    {
        String regex = "^[6-9]\\d{9}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(mobileNo);

        return matcher.matches();
//        if(!matcher.matches()) {
//            var crudResponse =
//                    CrudResponse.builder()
//                            .status(HttpStatus.NOT_FOUND.value())
//                            .data(null)
//                            .error("Invalid Mobile Number Entered")
//                            .build();
//
//            return ResponseEntity.status(crudResponse.getStatus()).body(crudResponse);
//        }
    }

}
