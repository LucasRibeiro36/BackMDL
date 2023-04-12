package br.com.ifba.modulologistica.infrastructure.exception;

import java.util.Date;

public class MessageExceptionHandler {
    private Date timestamp;
    private String message;
    private String status;

    public MessageExceptionHandler(Date date, String message, String status) {
        super();
        this.timestamp = date;
        this.status = status;
        this.message = message;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
