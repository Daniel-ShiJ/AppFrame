package com.example.king.view;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.king.netWork.response.IResponse;

public abstract class BaseActivity extends Activity implements IView {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initPageLayoutID();
        // 业务逻辑处理
        initData(savedInstanceState);
    }

    protected abstract int initPageLayoutID();

    protected abstract void initData(Bundle savedInstanceState);

    @Override
    public void showLoading() {
        //自定义实现
    }

    @Override
    public void hideLoading() {
//自定义实现
    }

    @Override
    public void showError(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onErrorCode(IResponse model) {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void onProgress(int progress) {

    }
}
