package com.jxau.until;

import com.jxau.VO.ResultVO;

/**
 * @PackageName:com.jxau.until
 * @ClassName:ResultUtil
 * @Description:
 * @Author: ZQ
 * @Date:2019/05/01 23:16
 */
public class ResultUtil {

    public static ResultVO setResultSuccess(Object data){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMessage("Success");
        resultVO.setData(data);
        return resultVO;
    }

    public static ResultVO success(){
        return setResultSuccess(null);
    }
}
