package com.jxau.VO;

import lombok.Data;

/**
 * @PackageName:com.jxau.VO
 * @ClassName:ResultVO
 * @Description: 返回视图
 * @Author: ZQ
 * @Date:2019/05/01 22:15
 */
@Data
public class ResultVO<T> {

    private Integer code;

    private String message;

    private T data;

    public ResultVO(){

    }

    public ResultVO(Integer code, String message ,T data){
        this.code = code;
        this.message = message;
        this.data =data;
    }

}
