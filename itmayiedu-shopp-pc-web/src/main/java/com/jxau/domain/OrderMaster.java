package com.jxau.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.jxau.enums.OrderStatusEnum;
import com.jxau.enums.PayStatusEnum;
import com.jxau.serializer.DateToSerializer;
import com.jxau.until.EnumUtil;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @PackageName:com.jxau.dataobject
 * @ClassName:OrederMaster
 * @Description:
 * @Author: ZQ
 * @Date:2019/05/02 13:19
 */

@Entity
@Data
@DynamicUpdate
public class OrderMaster {

    @Id
    private String orderId;

    private String buyerName;

    private  String buyerPhone;

    private  String buyerAddress;

    private String buyerOpenid;

    private BigDecimal orderAmount;

    //订单状态，默认为新下单
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();

    //支付状态，默认为未支付
    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    @JsonSerialize(using = DateToSerializer.class)
    private Date createTime;

    @JsonSerialize(using = DateToSerializer.class)
    private Date updateTime;


    public OrderMaster(){

    }

    @JsonIgnore
    public OrderStatusEnum getOrderStatusEnum(){
        return EnumUtil.getByCode(orderStatus, OrderStatusEnum.class);
    }

    //忽略该属性信息传输到json格式中
    @JsonIgnore
    public PayStatusEnum getPayStatusEnum(){
        return EnumUtil.getByCode(payStatus, PayStatusEnum.class);
    }


}
