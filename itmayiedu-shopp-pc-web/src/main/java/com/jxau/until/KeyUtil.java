package com.jxau.until;

import java.util.Random;

/**
 * @PackageName:com.jxau.until
 * @ClassName:KeyUtil
 * @Description:
 * @Author: ZQ
 * @Date:2019/05/02 15:10
 */
public class KeyUtil {
    /**
     * 生成唯一主键
     * @return
     */
    public static synchronized String getUniqueKey(){

        Random random = new Random();

        System.currentTimeMillis();

        Integer number = random.nextInt(900000)+100000;

        return System.currentTimeMillis() + String.valueOf(number);


    }

}
