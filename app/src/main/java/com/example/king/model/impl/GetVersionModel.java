package com.example.king.model.impl;

import android.util.Log;

import com.example.king.GsonSingleton;
import com.example.king.callBack.CallBack;
import com.example.king.model.IGetVersionModel;
import com.example.king.netWork.ApiRetrofit;
import com.example.king.netWork.DisposableManager;
import com.example.king.netWork.BaseObserver;
import com.example.king.netWork.request.IRequest;
import com.example.king.netWork.response.IResponse;

import java.util.HashMap;

/**
 * Created by Fat Man
 * on 2020/7/24
 */
public class GetVersionModel extends DisposableManager implements IGetVersionModel {
    private String TAG = "GetVersionModel";
    private IRequest iRequest;

    @Override
    public void getVersion(CallBack callBack) {
        iRequest = ApiRetrofit.getInstance().getIRequest();

        HashMap<String, Object> param = new HashMap<>();
        param.put("param", GsonSingleton.getInstance().toJson(new HashMap<>()));
        //这里还可以把公共参数，进行封装->自定义OKHttp的ParamsInterceptor拦截器

        addDisposable(iRequest.getVersion("config.version.update", param), new BaseObserver() {
            @Override
            public void onSuccess(IResponse data) {
                removeDisposable();
                Log.e(TAG, "onSuccess" + data.getResult());
                callBack.onSuccess(data);
            }

            @Override
            public void onError(String msg) {
                removeDisposable();
                callBack.onError(msg);
            }
        });
    }
}
