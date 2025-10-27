package com.example.FoodOrder;

import lombok.Data;
import org.springframework.http.HttpMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
@Data
public class ResponseInfo {

    private HttpStatus httpStatus;
    private String httpMessage;
    private HttpStatusCode statusCode;
}
