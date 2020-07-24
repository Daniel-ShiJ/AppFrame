package com.example.king;

import java.util.HashMap;

/**
 * Created by Fat Man
 * on 2020/7/24
 */
public class ParamSingleton {
    private ParamSingleton(){
    }

    public static HashMap<String,Object> getInstance(){
        ParamSingletonHolder.publicMap.put("token", "cbcfeed666aeddec9c2f0d40f97e1297");
        ParamSingletonHolder.publicMap.put("version", "1.0");
        ParamSingletonHolder.publicMap.put("format", "json");
        return ParamSingletonHolder.publicMap;
    }

    private static class ParamSingletonHolder{
        private static HashMap<String,Object> publicMap = new HashMap();
    }

}
