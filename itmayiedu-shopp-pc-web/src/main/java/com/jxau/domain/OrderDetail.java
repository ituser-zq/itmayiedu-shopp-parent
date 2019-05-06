package com.jxau.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @PackageName:com.jxau.enums
 * @ClassName:OrderDetail
 * @Description:
 * @Author: ZQ
 * @Date:2019/05/02 13:33
 */
@Entity
@Data
public class OrderDetail {

    @Id
    private String detailId;

    private String orderId;

    private String productId;

    private String productName;

    private BigDecimal productPrice;

    private Integer productQuantity;

    private String productIcon;

}
