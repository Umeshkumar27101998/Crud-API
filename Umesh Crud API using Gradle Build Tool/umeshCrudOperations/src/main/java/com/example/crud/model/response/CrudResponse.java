package com.example.crud.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
public class CrudResponse {
    @JsonProperty("status")
    Integer status;

    @JsonProperty("message")
    String message;

    @JsonProperty("data")
    Object data;

    @JsonProperty("error")
    String error;

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
