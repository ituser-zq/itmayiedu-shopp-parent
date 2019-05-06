package com.jxau.repository;

import com.jxau.domain.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @PackageName:com.jxau.repository
 * @ClassName:ProductCategoryRepository
 * @Description:
 * @Author: ZQ
 * @Date:2019/05/01 16:22
 */
public interface ProductCategoryDao extends JpaRepository<ProductCategory,Integer> {

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
