package com.jxau.converter;

import com.jxau.domain.OrderMaster;
import com.jxau.dto.OrderDTO;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @PackageName:com.jxau.converter
 * @ClassName:OrderMasterToOrderDTOConverter
 * @Description:
 * @Author: ZQ
 * @Date:2019/05/02 16:34
 */


public class OrderMasterToOrderDTOConverter {

    public static OrderDTO convert(OrderMaster orderMaster){
        OrderDTO orderDTO =new OrderDTO();
        BeanUtils.copyProperties(orderMaster,orderDTO);

        return orderDTO;

    }

    public static List<OrderDTO> convert(List<OrderMaster> orderMasterList){
        return  orderMasterList.stream()
                .map(e -> convert(e))
                .collect(Collectors.toList());

    }
}
