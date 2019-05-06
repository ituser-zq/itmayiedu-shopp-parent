package com.jxau.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jxau.enums.ProductStatusEnum;
import com.jxau.until.EnumUtil;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;


/**
 * @PackageName:com.jxau.repository
 * @ClassName:ProductInfo
 * @Description:
 * @Author: ZQ
 * @Date:2019/05/01 19:01
 */

@Entity
@Data
@DynamicUpdate
public class ProductInfo {

    public ProductInfo(){

    }

    @Id
    private String productId;

    private  String productName;

    private BigDecimal productPrice;

    private Integer productStock;

    private String productDescription;

    private String productIcon;

    private Integer productStatus = ProductStatusEnum.UP.getCode();

    private Integer categoryType;

    private Date createTime;

    private Date updateTime;


    @JsonIgnore
    public ProductStatusEnum getProductStatusEnum(){

        return EnumUtil.getByCode(productStatus,ProductStatusEnum.class);

    }

}
