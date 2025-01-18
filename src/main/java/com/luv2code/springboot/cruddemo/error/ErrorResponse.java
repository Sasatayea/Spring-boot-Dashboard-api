package com.luv2code.springboot.cruddemo.error;

import java.time.LocalDateTime;
import java.util.List;

public class ErrorResponse {

    private Boolean success ;
    private String message ;
    private List<String> details ;
    private LocalDateTime dateTime ;
    private  int statusCodeValue ;

    public int getStatusCodeValue() {
        return statusCodeValue;
    }

    public void setStatusCodeValue(int statusCodeValue) {
        this.statusCodeValue = statusCodeValue;
    }

    public ErrorResponse() {
        super();
        // TODO Auto-generated constructor stub
    }


    public ErrorResponse(String message, List<String> details) {
        super();
        this.message = message;
        this.details = details;
        this.success = Boolean.FALSE ;
        this.dateTime = LocalDateTime.now();
    }


    public Boolean getSuccess() {
        return success;
    }


    public void setSuccess(Boolean success) {
        this.success = success;
    }


    public String getMessage() {
        return message;
    }


    public void setMessage(String message) {
        this.message = message;
    }


    public List<String> getDetails() {
        return details;
    }


    public void setDetails(List<String> details) {
        this.details = details;
    }


    public LocalDateTime getDateTime() {
        return dateTime;
    }


    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
