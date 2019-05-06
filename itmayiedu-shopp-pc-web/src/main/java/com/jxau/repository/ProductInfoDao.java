package com.jxau.repository;

import com.jxau.domain.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @PackageName:com.jxau.repository
 * @ClassName:ProductInfoDao
 * @Description:
 * @Author: ZQ
 * @Date:2019/05/01 19:05
 */
public interface ProductInfoDao extends JpaRepository<ProductInfo,String> {

    List<ProductInfo> findByProductStatus(Integer productStatus);

}
