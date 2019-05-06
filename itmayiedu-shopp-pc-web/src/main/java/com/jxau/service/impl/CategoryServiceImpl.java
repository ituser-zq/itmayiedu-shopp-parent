package com.jxau.service.impl;

import com.jxau.domain.ProductCategory;
import com.jxau.repository.ProductCategoryDao;
import com.jxau.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @PackageName:com.jxau.service.impl
 * @ClassName:CategoryServiceImpl
 * @Description:
 * @Author: ZQ
 * @Date:2019/05/01 18:43
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    ProductCategoryDao productCategoryRepository;

    @Override
    public ProductCategory findOne(Integer categoryId) {
        return productCategoryRepository.findOne(categoryId);
    }

    @Override
    public List<ProductCategory> findAll() {
        return productCategoryRepository.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> category) {
        return productCategoryRepository.findByCategoryTypeIn(category);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return productCategoryRepository.save(productCategory);
    }
}
