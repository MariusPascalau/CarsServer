package org.example.config;

public class CarException extends Exception {
    private Integer status;

    public CarException(String message, Integer status) {
        super(message);
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
