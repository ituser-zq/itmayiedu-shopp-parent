package com.jxau.enums;

import lombok.Getter;

/**
 * @PackageName:com.jxau.enums
 * @ClassName:ProductStatusEnum
 * @Description: 商品转态枚举
 * @Author: ZQ
 * @Date:2019/05/01 19:53
 */
@Getter
public enum ProductStatusEnum implements CodeEnum {
    UP(0,"在架"),
    DOWN(1,"下架")
    ;

    private Integer code;

    private  String message;

    ProductStatusEnum(Integer code,String message){
        this.code =code;
        this.message= message;
    }

}
