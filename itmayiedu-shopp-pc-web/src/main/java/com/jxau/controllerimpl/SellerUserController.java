package com.jxau.controllerimpl;

import com.jxau.config.ProjectUrlConfig;
import com.jxau.constant.Constant;
import com.jxau.domain.SellerInfo;
import com.jxau.enums.ResultEnum;
import com.jxau.service.SellerService;
import com.jxau.until.CookieUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.UUID;

/**
 * @PackageName:com.jxau.controller
 * @ClassName:SellerUserController
 * @Description:
 * @Author: ZQ
 * @Date:2019/05/06 15:01
 */
@Controller
@RequestMapping("/seller")
@Slf4j
public class SellerUserController {

    /**
     * 登录，登出采用微信三方扫码登录
     */

    @Autowired
    private SellerService sellerService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private ProjectUrlConfig projectUrlConfig;

    @GetMapping("/login")
    public ModelAndView login(@RequestParam("openid") String openid, Map<String ,Object> map, HttpServletResponse response){

        //openid校验数据库
        SellerInfo sellerInfo =sellerService.findSellerInfoByOpenId(openid);
        if(sellerInfo == null){
            map.put("msg", ResultEnum.LOGIN_FAIL.getMessage());
            map.put("url", "/sell/seller/order/list");
            return new ModelAndView("common/error");
        }
        ///设置token到redis
        String token = UUID.randomUUID().toString();

        redisTemplate.opsForValue().set(String.format(Constant.TOKEN_PREFIX,token),openid, Constant.EXPIRE);

        //设置token到cookie
        CookieUtil.set(response, Constant.TOKEN_PREFIX,token, Constant.EXPIRE);

        return new ModelAndView("redirect:" +projectUrlConfig.getSell() +"/sell/seller/order/list");

    }

    @GetMapping("/logout")
    public ModelAndView logout(HttpServletResponse response, HttpServletRequest request,Map map){

       Cookie cookie = CookieUtil.get(request,Constant.TOKEN);
        if(cookie != null ){
            redisTemplate.opsForValue().getOperations().delete(String.format(Constant.TOKEN_PREFIX,cookie));

            CookieUtil.set(response,Constant.TOKEN,null,0);
        }
        map.put("msg", ResultEnum.LOGOUT_SUCCESS.getMessage());
        map.put("url",projectUrlConfig.getSell()+"/sell/login");
        return new ModelAndView("common/success",map);
    }

}
