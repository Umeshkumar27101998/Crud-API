package com.example.umeshfirstproject.crudapi.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@Component
public class ResponseDto {

    @JsonProperty("status")
    Integer status;

    @JsonProperty("message")
    String message;

    @JsonProperty("data")
    Object data;

    @JsonProperty("error")
    String error;



    public ResponseDto setResponse(Integer status, Object data, String message, String error)
    {
//        var responseDto =
        return ResponseDto.builder()
                        .status(status)
                        .data(data)
                        .message(message)
                        .error(error)
                        .build();
//        return ResponseEntity.setResponse(.body(responseDto);
    }
    @Override
    public String toString() {
        return "CrudResponse{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", data=" + data +
                ", error='" + error + '\'' +
                '}';
    }
}

