package com.jxau.service;

import com.jxau.domain.ProductCategory;

import java.util.List;

/**
 * @PackageName:com.jxau.service
 * @ClassName:CategoryService
 * @Description:
 * @Author: ZQ
 * @Date:2019/05/01 18:39
 */
public interface CategoryService {

    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> category);

    ProductCategory save(ProductCategory productCategory);
}
