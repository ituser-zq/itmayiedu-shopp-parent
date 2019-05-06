package com.jxau.enums;

import lombok.Getter;

/**
 *
 * @PackageName: com.jxau.enums
 * @ClassName: OrderStatusEnum.java
 * @Description:
 * @Author: ZQ
 * @Date: 2019/05/02 13:23
 *
 */
@Getter
public enum OrderStatusEnum implements CodeEnum {

    NEW(0,"新订单"),
    FINISHEN(1,"完结"),
    CANCEL(2,"已取消"),
    ;

    private  Integer code;

    private String message;

    OrderStatusEnum(Integer code,String message){
       this.code=code;
       this.message=message;
   }
}
