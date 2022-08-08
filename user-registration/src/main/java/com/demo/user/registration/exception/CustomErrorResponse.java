package com.demo.user.registration.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class CustomErrorResponse {

    String errorCode;
    String errorMsg;
    int status;

    public CustomErrorResponse(String errorCode, String errorMsg) {
        super();
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }
}
