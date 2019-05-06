package com.jxau.controllerimpl;

import com.jxau.Exception.SellException;
import com.jxau.dto.OrderDTO;
import com.jxau.enums.ResultEnum;
import com.jxau.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @PackageName:com.jxau.controller
 * @ClassName:SellerOrderController
 * @Description:
 * @Author: ZQ
 * @Date:2019/05/05 15:36
 */
@Controller
@RequestMapping("/seller/order")
@Slf4j
public class SellerOrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page",defaultValue = "1" ) Integer page,
                             @RequestParam(value = "size",defaultValue = "8") Integer size,
                             Map<String ,Object> map){

        PageRequest request = new PageRequest(page-1,size);

        Page<OrderDTO> orderDTOPage = orderService.findList(request);

        map.put("orderDTOPage",orderDTOPage);
        map.put("currentPage",page);
        map.put("size",size);
        return new ModelAndView("order/list",map);

    }

    @GetMapping("/cancel")
    public ModelAndView cancel(@RequestParam("orderId") String orderId,Map<String ,Object> map){

        OrderDTO orderDTO = new OrderDTO();
      try {
           orderDTO = orderService.findOne(orderId);
           orderService.cancel(orderDTO);
      }catch (SellException e){
          if(orderDTO == null){
              log.error("##########订单取消，查询不到订单#########");

              map.put("msg", e.getMessage());
              map.put("url","/sell/seller/order/list");
              return new ModelAndView("common/error",map);
          }
      }
      map.put("msg", ResultEnum.ORDER_CANCEL_SUCCESS.getMessage());
      map.put("url","/sell/seller/order/list");

       return new ModelAndView("common/success",map);
    }

    @GetMapping("/detail")
    public ModelAndView detail(@RequestParam("orderId") String orderId,Map map){

        OrderDTO orderDTO = new OrderDTO();
        try {
            orderDTO = orderService.findOne(orderId);
        }catch (SellException e){
            log.info("#########查询订单详情发生异常######");
            map.put("msg",e.getMessage());
            map.put("url","/sell/seller/order/list");

            return new ModelAndView("common/error",map);
        }

        map.put("orderDTO",orderDTO);
        return new ModelAndView("order/detail",map);

    }

    @GetMapping("/finish")
    public ModelAndView finish(@RequestParam("orderId") String orderId,Map<String,Object> map){

        OrderDTO orderDTO = new OrderDTO();
        try {
            orderDTO = orderService.findOne(orderId);
            orderService.finish(orderDTO);
        }catch (SellException e){
            if(orderDTO == null){
                log.error("##########订单完结操作异常#########");

                map.put("msg", e.getMessage());
                map.put("url","/sell/seller/order/list");
                return new ModelAndView("common/error",map);
            }
        }
        map.put("msg", ResultEnum.ORDER_FINISH_SUCCESS.getMessage());
        map.put("url","/sell/seller/order/list");

        return new ModelAndView("common/success",map);
    }


}
