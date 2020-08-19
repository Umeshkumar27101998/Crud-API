package com.example.crud.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class InvoiceInfo {
    @JsonProperty("user_id")
    String userID;

    @JsonProperty("amount")
    Long amount;

    @JsonProperty("name")
    String name;

    @JsonProperty("mobile_no")
    String mobileNo;
}
