package com.jxau.controllerimpl;

import com.jxau.VO.ProductInfoVO;
import com.jxau.VO.ProductVO;
import com.jxau.VO.ResultVO;
import com.jxau.domain.ProductCategory;
import com.jxau.domain.ProductInfo;
import com.jxau.service.CategoryService;
import com.jxau.service.ProductService;
import com.jxau.until.ResultUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @PackageName:com.jxau.controller
 * @ClassName:BuyerProductController
 * @Description:
 * @Author: ZQ
 * @Date:2019/05/01 22:12
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ResultVO list(){
        //1.查询商品
        List<ProductInfo> productInfoList = productService.findUpAll();
        //2.查询类目
        List<Integer> categoryTypeList =productInfoList.stream()
                .map(e -> e.getCategoryType())
                .collect(Collectors.toList());
        List<ProductCategory> ProductCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

;
        //3.数据封装
            //第一层类目封装
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory: ProductCategoryList){
            ProductVO productVO =new ProductVO();
            productVO.setCatrgoryType(productCategory.getCategoryType());
            productVO.setCategoryName(productCategory.getCategoryName());

            //第二层商品详情封装
            List<ProductInfoVO> productInfoVOList =new ArrayList<>();
            for (ProductInfo productInfo: productInfoList){
                //是同一个类型进行封装
                if(productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVO productInfoVO =new ProductInfoVO();
                    //将详情数据复制到视图类
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }

        //返回封装数据
        return ResultUtil.setResultSuccess(productVOList);
    }
}
