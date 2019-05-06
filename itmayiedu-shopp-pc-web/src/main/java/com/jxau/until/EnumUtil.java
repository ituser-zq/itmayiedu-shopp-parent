package com.jxau.until;

import com.jxau.enums.CodeEnum;


/**
 * @PackageName:com.jxau.until
 * @ClassName:EnumUtil
 * @Description:    枚举装换工具类
 * @Author: ZQ
 * @Date:2019/05/05 16:05
 */
public class EnumUtil {
    public static < T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass){

        for (T each: enumClass.getEnumConstants() ) {
            if (code.equals(each.getCode())){
                return  each;
            }
        }
        return null;
    }

}
