package com.jxau.controllerimpl;

import com.jxau.Exception.SellException;
import com.jxau.domain.ProductCategory;
import com.jxau.domain.ProductInfo;
import com.jxau.form.ProductFrom;
import com.jxau.service.CategoryService;
import com.jxau.service.ProductService;
import com.jxau.until.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * @PackageName:com.jxau.controller
 * @ClassName:SellerProductController
 * @Description:
 * @Author: ZQ
 * @Date:2019/05/05 20:25
 */
@Controller
@RequestMapping("/seller/product")
public class SellerProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page",defaultValue = "1") Integer page,
                             @RequestParam(value = "size",defaultValue = "10") Integer size,
                             Map<String, Object> map){

        PageRequest request = new PageRequest(page-1,size);

        Page<ProductInfo> productInfoPage = productService.findAll(request);

        map.put("productInfoPage",productInfoPage);
        map.put("currentPage",page);
        map.put("size",size);
        return new ModelAndView("product/list",map);


    }

    @GetMapping("/onsale")
    public ModelAndView onSale(@RequestParam("productId") String productId,
                               Map<String,Object> map){

        try {
            productService.onSale(productId);
        }catch (SellException e){
            map.put("msg",e.getMessage());
            map.put("url","/sell/seller/product/list");
            return new ModelAndView("common/error",map);
        }

        map.put("url","/sell/seller/product/list");
        return new ModelAndView("common/success");

    }

    @GetMapping("/offsale")
    public ModelAndView offSale(@RequestParam("productId") String productId,
                               Map<String,Object> map){

        try {
            productService.offSale(productId);
        }catch (SellException e){
            map.put("msg",e.getMessage());
            map.put("url","/sell/seller/product/list");
            return new ModelAndView("common/error",map);
        }

        map.put("url","/sell/seller/product/list");
        return new ModelAndView("common/success");

    }

    @GetMapping("index")
    public ModelAndView index(@RequestParam(value = "productId",required = false) String productId,
                                Map<String,Object> map){
        if(!StringUtils.isEmpty(productId)){
            ProductInfo productInfo = productService.findOne(productId);
            map.put("productInfo",productInfo);
        }

        //查询所有的类目
        List<ProductCategory> categoryList = categoryService.findAll();
        map.put("categoryList",categoryList);
        return new ModelAndView("product/index",map);

    }

    @PostMapping("/save")
    public ModelAndView save(@Valid ProductFrom form,
                             BindingResult bindingResult,
                             Map<String, Object> map){
    if(bindingResult.hasErrors()){
        map.put("msg",bindingResult.getFieldError().getDefaultMessage());
        map.put("url","/sell/seller/product/index");
        return new ModelAndView("common/error",map);
    }


        ProductInfo productInfo = new ProductInfo();
        try {
            //为空则为增加
            if(!StringUtils.isEmpty(form.getProductId())){
                 productInfo = productService.findOne(form.getProductId());

            }else {
                form.setProductId(KeyUtil.getUniqueKey());
            }

            BeanUtils.copyProperties(form,productInfo);
            productService.save(productInfo);
        }catch (SellException e){
            map.put("msg",e.getMessage());
            map.put("url","/sell/seller/product/index");
            return new ModelAndView("common/error",map);
        }
        map.put("url","/sell/seller/product/list");

        return new ModelAndView("common/success",map);

    }


}
