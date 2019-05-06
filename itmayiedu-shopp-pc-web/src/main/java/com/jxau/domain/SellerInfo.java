package com.jxau.domain;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @PackageName:com.jxau.repository
 * @ClassName:SellerInfo
 * @Description:
 * @Author: ZQ
 * @Date:2019/05/06 14:06
 */
@Entity
@Data
@DynamicUpdate
public class SellerInfo {

    @Id
    private String sellerId;

    private String username;

    private String password;

    private String openId;

}
