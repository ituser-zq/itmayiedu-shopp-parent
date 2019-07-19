package com.jxau.controllerimpl;

import com.jxau.Exception.SellException;
import com.jxau.dto.OrderDTO;
import com.jxau.enums.ResultEnum;
import com.jxau.service.OrderService;
import com.jxau.service.PayService;
import com.lly835.bestpay.model.PayResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;


/**
 * @PackageName:com.jxau.controller
 * @ClassName:PayController
 * @Description:
 * @Author: ZQ
 * @Date:2019/05/04 16:57
 */
@Controller
@RequestMapping("/pay")
@Slf4j
public class PayController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private PayService payService;

    @GetMapping("/create")
    public ModelAndView create(@RequestParam("orderId") String orderId,
                               @RequestParam("returnUrl") String returnUrl,
                               Map<String ,Object> map){

        //查询订单
       OrderDTO orderDTO =  orderService.findOne(orderId);
        if(orderDTO == null){
            log.info("#########订单不存在######");
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }

        //发起支付
        PayResponse  payResponse =  payService.create(orderDTO);
        map.put("payResponse",payResponse);
        map.put("returnUrl",returnUrl);
        return new ModelAndView("pay/create",map);

    }


    @PostMapping("/notify")
    public ModelAndView notify(@RequestBody String notifyData){


        PayResponse payResponse = payService.notity(notifyData);

        //返回给微信处理请求结果

        return new ModelAndView("pay/success");

    }

}
