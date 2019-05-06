package com.jxau.domain;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * @PackageName:com.jxau.dataobject
 * @ClassName:ProductCategory
 * @Description: 类目表product_category  @DynamicUpdate自动更新
 * @Author: ZQ
 * @Date:2019/05/01 16:12
 */
@Entity
@Data
@DynamicUpdate
public class ProductCategory {

    //主键

    @Id
    @GeneratedValue
    private Integer categoryId;

    private String categoryName;

    private Integer categoryType;

    private Date createTime;

    private Date updateTime;

    public ProductCategory(){

    }
    public ProductCategory(String categoryName, Integer categoryType){
            this.categoryName = categoryName;
            this.categoryType = categoryType;
    }


    @Override
    public String toString() {
        return "ProductCategory{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", categoryType=" + categoryType +
                '}';
    }
}
