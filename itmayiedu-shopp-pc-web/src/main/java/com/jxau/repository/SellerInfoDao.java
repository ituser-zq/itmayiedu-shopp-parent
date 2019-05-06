package com.jxau.repository;

import com.jxau.domain.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @PackageName:com.jxau.repository
 * @ClassName:SellerInfoDao
 * @Description:
 * @Author: ZQ
 * @Date:2019/05/06 14:08
 */

public interface SellerInfoDao extends JpaRepository<SellerInfo,String> {

    SellerInfo findByOpenId(String openId);

}
