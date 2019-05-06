package com.jxau.dto;

import com.jxau.domain.OrderDetail;
import com.jxau.domain.OrderMaster;
import lombok.Data;

import java.util.List;

/**
 * @PackageName:com.jxau.dto
 * @ClassName:OrderDTO
 * @Description:
 * @Author: ZQ
 * @Date:2019/05/02 14:40
 */
@Data
//@JsonInclude(JsonInclude.Include.NON_NULL)该注解用于实现对json前端为null时不显示
public class OrderDTO extends OrderMaster {

    private List<OrderDetail> orderDetailList;
}
