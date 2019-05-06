package com.jxau.Exception;

import com.jxau.enums.ResultEnum;

/**
 * @PackageName:com.jxau.Exception
 * @ClassName:SellException
 * @Description:
 * @Author: ZQ
 * @Date:2019/05/02 14:56
 */
public class SellException extends RuntimeException {

    private Integer code;

    public SellException(ResultEnum resultEnum){
        super(resultEnum.getMessage());

        this.code = resultEnum.getCode();
    }

    public SellException(Integer code,String message){
       super(message);
        this.code =code;

    }

}
