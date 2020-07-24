package com.example.king.netWork.response;

import com.example.king.model.entities.StatusResponse;

import java.io.Serializable;

/**
 * 封装解析外层统一部分
 * @param <T>
 */
public class IResponse<T> implements Serializable {
    private static final long serialVersionUID = -5384699880504465942L;
    private StatusResponse status;
    private T result;

    public StatusResponse getStatus() {
        return status;
    }

    public void setStatus(StatusResponse status) {
        this.status = status;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
