package com.example.king.netWork.request;

import com.example.king.netWork.response.IResponse;

import java.util.HashMap;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface IRequest {

    @FormUrlEncoded
    @POST("api/api")
    Observable<IResponse> getVersion(@Field("method") String method, @FieldMap(encoded = true) HashMap<String, Object> params);

}
