package com.jxau.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jxau.Exception.SellException;
import com.jxau.domain.OrderDetail;
import com.jxau.dto.OrderDTO;
import com.jxau.enums.ResultEnum;
import com.jxau.form.OrderForm;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @PackageName:com.jxau.converter
 * @ClassName:OrderDetailToOrderDTOConverter
 * @Description:
 * @Author: ZQ
 * @Date:2019/05/02 21:36
 */
@Slf4j
public class OrderDetailToOrderDTOConverter {

    public static OrderDTO convert(OrderForm orderForm) {
        Gson gson = new Gson();
        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());

        List<OrderDetail> orderDetailList = new ArrayList<>();
        try {
            orderDetailList = gson.fromJson(orderForm.getItems(),
                    new TypeToken<List<OrderDetail>>() {
                    }.getType());
        } catch (Exception e) {
            log.error("【对象转换】错误, string={}", orderForm.getItems());
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        orderDTO.setOrderDetailList(orderDetailList);

        return orderDTO;
    }

}
