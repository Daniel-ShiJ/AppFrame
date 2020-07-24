package com.example.king.netWork;

import android.util.Log;

import com.example.king.netWork.response.IResponse;
import com.example.king.view.IView;
import com.google.gson.Gson;
import com.google.gson.JsonParseException;

import org.json.JSONException;

import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.UnknownHostException;
import java.text.ParseException;

import io.reactivex.observers.DisposableObserver;
import retrofit2.HttpException;

public abstract class BaseObserver<T> extends DisposableObserver<IResponse<T>> {
    private static final String TAG = "BaseObserver";
    /**
     * 网络连接失败  无网
     */
    public static final int NETWORK_ERROR = 100000;
    /**
     * 解析数据失败
     */
    public static final int PARSE_ERROR = 1008;
    /**
     * 网络问题
     */
    public static final int BAD_NETWORK = 1007;
    /**
     * 连接错误
     */
    public static final int CONNECT_ERROR = 1006;
    /**
     * 连接超时
     */
    public static final int CONNECT_TIMEOUT = 1005;

    public BaseObserver() {
    }

    @Override
    public void onNext(IResponse<T> response) {
        try {
            if (response.getStatus().getStatus_code() == 0) {
                onSuccess(response);
            } else {
                onError(response.getStatus().getStatus_reason());
            }
        } catch (Exception e) {
            e.printStackTrace();
            onError(e.toString());
        }
    }

    @Override
    public void onError(Throwable e) {
        if (e instanceof HttpException) {
            //   HTTP错误
            onException(BAD_NETWORK);
        } else if(e instanceof UnknownHostException) {
            //没有网络
            onException(NETWORK_ERROR);
        }else if (e instanceof ConnectException) {
            //   连接错误
            onException(CONNECT_ERROR);
        } else if (e instanceof InterruptedIOException) {
            //  连接超时
            onException(CONNECT_TIMEOUT);
        } else if (e instanceof JsonParseException
                || e instanceof JSONException
                || e instanceof ParseException) {
            //  解析错误
            onException(PARSE_ERROR);
            e.printStackTrace();
        } else {
            if (e != null) {
                onError(e.toString());
            } else {
                onError("未知错误");
            }
        }
    }

    private void onException(int unknownError) {
        switch (unknownError) {
            case CONNECT_ERROR:
                onError("连接错误");
                break;
            case CONNECT_TIMEOUT:
                onError("连接超时");
                break;
            case BAD_NETWORK:
                onError("网络超时");
                break;
            case NETWORK_ERROR:
                onError("无法连接网络");
                break;
            case PARSE_ERROR:
                onError("数据解析失败");
                break;
            default:
                onError("其他错误");
                break;
        }
    }
    //消失写到这 有一定的延迟  对dialog显示有影响
    @Override
    public void onComplete() {
       /* if (view != null) {
            view.hideLoading();
        }*/
    }
    public abstract void onSuccess(IResponse<T> data);
    public abstract void onError(String msg);
}