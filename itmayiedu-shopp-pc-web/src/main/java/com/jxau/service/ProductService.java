package com.jxau.service;

import com.jxau.domain.ProductInfo;
import com.jxau.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @PackageName:com.jxau.service
 * @ClassName:ProductService
 * @Description:
 * @Author: ZQ
 * @Date:2019/05/01 19:47
 */
public interface ProductService {

    ProductInfo findOne(String productId);

    List<ProductInfo> findUpAll();

    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    //加库存
    void increaseStock(List<CartDTO> cartDTOList);

    //减库存
    void decreaseStock(List<CartDTO> cartDTOList);

    //商品上架
    ProductInfo onSale(String productId);

    //商品下架
    ProductInfo offSale(String productId);



}
