package com.jxau.service;

import com.jxau.domain.SellerInfo;

/**
 * @PackageName:com.jxau.service
 * @ClassName:SellerService
 * @Description:
 * @Author: ZQ
 * @Date:2019/05/06 14:27
 */
public interface SellerService {

    SellerInfo findSellerInfoByOpenId(String openid);

}
