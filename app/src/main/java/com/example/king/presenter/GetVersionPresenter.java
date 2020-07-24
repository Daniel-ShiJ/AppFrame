package com.example.king.presenter;

import android.util.Log;

import com.example.king.GsonSingleton;
import com.example.king.callBack.CallBack;
import com.example.king.model.IGetVersionModel;
import com.example.king.model.entities.AppCfg;
import com.example.king.model.impl.GetVersionModel;
import com.example.king.netWork.response.IResponse;
import com.example.king.view.IGetVersionView;

/**
 * Created by Fat Man
 * on 2020/7/24
 */
public class GetVersionPresenter {
    private static final String TAG = "GetVersionPresenter";
    private IGetVersionModel iGetVersionModel;
    private IGetVersionView iGetVersionView;
    public GetVersionPresenter(IGetVersionView iGetVersionView){
        this.iGetVersionView = iGetVersionView;
        iGetVersionModel = new GetVersionModel();
    }

    public void getVersion(){
        iGetVersionView.showLoading();
        iGetVersionModel.getVersion(new CallBack() {
            @Override
            public void onSuccess(IResponse data) {
                iGetVersionView.hideLoading();
                Log.e(TAG,data.getResult().toString());

                iGetVersionView.requestDataSuccess(GsonSingleton.getInstance().fromJson(GsonSingleton.getInstance().toJson(data.getResult()),AppCfg.class));
            }

            @Override
            public void onError(String msg) {
                iGetVersionView.hideLoading();
                iGetVersionView.showError(msg);
            }
        });
    }
}
