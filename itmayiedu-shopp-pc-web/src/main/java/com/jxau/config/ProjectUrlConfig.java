package com.jxau.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @PackageName:com.jxau.config
 * @ClassName:ProjectUrl
 * @Description:
 * @Author: ZQ
 * @Date:2019/05/06 14:53
 */
@Data
@Component
@ConfigurationProperties(prefix = "projectUrl")
public class ProjectUrlConfig {

    private String wechatMpAuthorize;

    private String wechatOpenAuthorize;

    private String sell;

}
