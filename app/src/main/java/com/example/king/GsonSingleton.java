package com.example.king;

import com.google.gson.Gson;

/**
 * Created by Fat Man
 * on 2020/7/24
 */
public class GsonSingleton {
    private GsonSingleton(){
    }
    public static Gson getInstance(){
        return GsonSingletonHolder.gson;
    }
    private static class GsonSingletonHolder{
        public static Gson gson = new Gson();
    }



}
