package com.jxau.controllerimpl;

import com.jxau.Exception.SellException;
import com.jxau.VO.ResultVO;
import com.jxau.converter.OrderDetailToOrderDTOConverter;
import com.jxau.domain.OrderDetail;
import com.jxau.dto.OrderDTO;
import com.jxau.enums.ResultEnum;
import com.jxau.form.OrderForm;
import com.jxau.service.BuyerService;
import com.jxau.service.OrderService;
import com.jxau.until.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @PackageName:com.jxau.controller
 * @ClassName:BuyerOrderController
 * @Description:
 * @Author: ZQ
 * @Date:2019/05/02 20:57
 */
@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class BuyerOrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private BuyerService buyerService;

    //创建订单
    @PostMapping("/create")
    public ResultVO<Map<String, String>> create(@Valid OrderForm orderForm,
                                                BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("【创建订单】参数不正确, orderForm={}", orderForm);
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }

        OrderDTO orderDTO = OrderDetailToOrderDTOConverter.convert(orderForm);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
            log.error("【创建订单】购物车不能为空");
            throw new SellException(ResultEnum.CART_EMPTY);
        }

        OrderDTO createResult = orderService.create(orderDTO);

        Map<String, String> map = new HashMap<>();
        map.put("orderId", createResult.getOrderId());

        return ResultUtil.setResultSuccess(map);
    }

    //订单列表详情
    @GetMapping("/list")
    public ResultVO<List<OrderDetail>> list(@RequestParam("openid") String openid,
                                            @RequestParam(value = "page",defaultValue = "0") Integer page,
                                            @RequestParam(value = "size",defaultValue = "10") Integer size){

    if(StringUtils.isEmpty(openid)){
        log.info("#######OPENID为空#########");
        throw new SellException(ResultEnum.PARAM_ERROR);
    }
        PageRequest request = new PageRequest(page,size);
        Page<OrderDTO> orderDTOPage = orderService.findList(openid,request);

        //时间格式装换

        return ResultUtil.setResultSuccess(orderDTOPage);
    }

    //订单详情
    @GetMapping("/detail")
    public ResultVO<OrderDTO> detail(@RequestParam("openid") String openid,
                                     @RequestParam("orderId") String orderId){

                OrderDTO orderDTO = buyerService.findOrderOne(openid,orderId);

        return ResultUtil.setResultSuccess(orderDTO);
    }

    //取消订单
    @PostMapping("/cancel")
    public ResultVO cancel(@RequestParam("openid") String openid,
                           @RequestParam("orderId") String orderId){


        OrderDTO orderDTO = buyerService.cancelOrder(openid,orderId);

        return ResultUtil.success();
    }

}
