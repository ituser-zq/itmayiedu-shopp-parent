package com.jxau.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @PackageName:form
 * @ClassName:OrderForm
 * @Description:
 * @Author: ZQ
 * @Date:2019/05/02 21:06
 */
@Data
public class OrderForm {

    @NotEmpty(message = "姓名必填")
    private String name;

    @NotEmpty(message = "手机号必填")
    private String phone;

    @NotEmpty(message = "地址必填")
    private String address;

    @NotEmpty(message = "openid必填")
    private String openid;

    @NotEmpty(message = "购物车必填")
    private String items;

}
