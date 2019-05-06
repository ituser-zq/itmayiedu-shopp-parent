package com.jxau.form;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @PackageName:com.jxau.form
 * @ClassName:ProductFrom
 * @Description:
 * @Author: ZQ
 * @Date:2019/05/05 21:30
 */
@Data
public class ProductFrom {

    private String productId;

    /** 名字. */
    private String productName;

    /** 单价. */
    private BigDecimal productPrice;

    /** 库存. */
    private Integer productStock;

    /** 描述. */
    private String productDescription;

    /** 小图. */
    private String productIcon;

    /** 类目编号. */
    private Integer categoryType;
}
