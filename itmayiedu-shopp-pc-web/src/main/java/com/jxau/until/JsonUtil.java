package com.jxau.until;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @PackageName:com.jxau.until
 * @ClassName:JsonUtil
 * @Description:
 * @Author: ZQ
 * @Date:2019/05/04 17:50
 */
public class JsonUtil {

    public static String toJson(Object object){

        GsonBuilder gsonBuilder = new GsonBuilder();

        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        return gson.toJson(object);



    }

}
