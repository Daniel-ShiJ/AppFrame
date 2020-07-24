package com.example.king.testjava;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.databinding.DataBindingUtil;
import com.example.king.model.entities.AppCfg;
import com.example.king.presenter.GetVersionPresenter;
import com.example.king.testjava.databinding.GetVersionLayoutBinding;
import com.example.king.view.BaseActivity;
import com.example.king.view.IGetVersionView;

/**
 * 示例类
 */
public class GetVersionActivity extends BaseActivity implements IGetVersionView<AppCfg> {
    private static final String TAG = "GetVersionActivity";
    private GetVersionPresenter getVersionPresenter;
    private GetVersionLayoutBinding getVersionLayoutBinding;

    @Override
    protected int initPageLayoutID() {
        return R.layout.get_version_layout;
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        getVersionLayoutBinding = DataBindingUtil.setContentView(this,initPageLayoutID());
        getVersionPresenter = new GetVersionPresenter(this);
    }

    @Override
    public void requestDataSuccess(AppCfg appCfg) {
        Log.d(TAG,appCfg.toString());
        if(null != appCfg)
            getVersionLayoutBinding.setAppData(appCfg);//通过DataBinding，绑定Model
    }

    public void getVersion(View v){
        getVersionPresenter.getVersion();
    }
}
