package com.example.king.netWork.Interceptor;

import com.example.king.GsonSingleton;
import com.example.king.ParamSingleton;

import java.io.IOException;
import java.util.HashMap;

import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 参数拦截
 */
public class ParamsInterceptor implements Interceptor {
    private static final String METHOD_GET = "GET";
    private static final String METHOD_POST = "POST";

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Request.Builder requestBuilder = request.newBuilder();
        HttpUrl.Builder urlBuilder = request.url().newBuilder();

        if (METHOD_GET.equals(request.method())) { // GET方法
            // 通过urlBuilder.addEncodedQueryParameter可以添加一些公共get参数
            HttpUrl httpUrl = urlBuilder.build();
            // 将最终的url填充到request中
            requestBuilder.url(httpUrl);
        } else if (METHOD_POST.equals(request.method())) { // POST方法
            HashMap<String, Object> publicMap = ParamSingleton.getInstance();//获取公共参数，这里根据请求文档，来封装

            //新建一个构造器
            FormBody.Builder bodyBuilder = new FormBody.Builder();
            // 把已有的post参数添加到新的构造器
            if (request.body() instanceof FormBody) {
                FormBody formBody = (FormBody) request.body();
                for (int i = 0; i < formBody.size(); i++) {
                    if (i == 0) {
                        publicMap.put("method", formBody.encodedValue(i));//提取方法名
                    }
                    bodyBuilder.addEncoded(formBody.encodedName(i), formBody.encodedValue(i));
                }
            }
            bodyBuilder.addEncoded("public", GsonSingleton.getInstance().toJson(publicMap));
            //可以通过bodyBuilder.addEncoded，增加参数
            FormBody newBody = bodyBuilder.build();
            // 将最终的表单body填充到request中
            requestBuilder.post(newBody);
        }

        // 这里我们可以添加header
        requestBuilder.addHeader("platform", "android");
        requestBuilder.addHeader("version", "1.0.0");
        requestBuilder.addHeader("xuid", "");
        requestBuilder.addHeader("udid", "");
        return chain.proceed(requestBuilder.build());
    }

}
