package com.jxau.dto;

import lombok.Data;

/**
 * @PackageName:com.jxau.dto
 * @ClassName:CartDTO
 * @Description:
 * @Author: ZQ
 * @Date:2019/05/02 15:20
 */
@Data
public class CartDTO {

    private String productId;

    private Integer productQuantity;


    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
