package com.example.king.view;

import com.example.king.netWork.response.IResponse;

public interface IView {
    //根据项目，自定义添加公共方法
    void showLoading();
    void hideLoading();
    void showError(String msg);
    void onErrorCode(IResponse model);
    void showProgress();
    void hideProgress();
    void onProgress(int progress);
}
