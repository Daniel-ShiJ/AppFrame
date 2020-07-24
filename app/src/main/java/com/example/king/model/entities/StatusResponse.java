package com.example.king.model.entities;

import java.io.Serializable;

public class StatusResponse implements Serializable {
    private static final long serialVersionUID = -2720390393826835878L;
    private int status_code;
    private String status_reason;
    public int getStatus_code() {
        return status_code;
    }

    public void setStatus_code(int status_code) {
        this.status_code = status_code;
    }

    public String getStatus_reason() {
        return status_reason;
    }

    public void setStatus_reason(String status_reason) {
        this.status_reason = status_reason;
    }

}
