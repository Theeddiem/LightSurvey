package com.eddieknaz.springboot.fastsurvey.exception;

import java.util.Date;

public class ErrorDetails {

    private int status;
    private String message;
    private Date timeStamp;

    public ErrorDetails(){}

    public ErrorDetails(int status, String message, Date timeStamp) {
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
    }

    public int getStauts() {
        return status;
    }

    public void setStauts(int stauts) {
        this.status = stauts;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }
}
