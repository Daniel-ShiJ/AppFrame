package com.example.king.callBack;

import com.example.king.netWork.response.IResponse;

public interface CallBack<T> {
    public abstract void onSuccess(IResponse<T> data);
    public abstract void onError(String msg);
}
