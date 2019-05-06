package com.jxau.until;

/**
 * @PackageName:com.jxau.until
 * @ClassName:MathUtil
 * @Description: 用于转换double与数据库金额BigDecimal的精度的比较
 * @Author: ZQ
 * @Date:2019/05/04 21:47
 */
public class MathUtil {

    private static final Double MONEY_RANGE = 0.01;

    public static Boolean equals(Double d1,Double d2){

        Double result = Math.abs(d1-d2);
        if(result <MONEY_RANGE){
            return true;
        }
        return false;

    }


}
