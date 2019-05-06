package com.jxau.service.impl;

import com.jxau.domain.SellerInfo;
import com.jxau.repository.SellerInfoDao;
import com.jxau.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @PackageName:com.jxau.service.impl
 * @ClassName:SellerServiceImpl
 * @Description:
 * @Author: ZQ
 * @Date:2019/05/06 14:28
 */
@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerInfoDao sellerInfoDao;

    @Override
    public SellerInfo findSellerInfoByOpenId(String openid) {

        return sellerInfoDao.findByOpenId(openid);

    }
}
