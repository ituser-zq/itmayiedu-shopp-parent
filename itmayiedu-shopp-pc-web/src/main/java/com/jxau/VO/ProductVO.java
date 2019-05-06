package com.jxau.VO;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @PackageName:com.jxau.VO
 * @ClassName:ProductVO
 * @Description:
 * @Author: ZQ
 * @Date:2019/05/01 22:27
 */
@Data
public class ProductVO {

    @JsonProperty("name")
    private  String categoryName;

    @JsonProperty("type")
    private Integer catrgoryType;

    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;

}
