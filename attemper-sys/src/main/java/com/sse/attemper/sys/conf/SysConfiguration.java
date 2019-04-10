package com.sse.attemper.sys.conf;

import com.sse.attemper.config.conf.ConfigConfiguration;
import com.sse.attemper.sys.controller.ResourceController;
import com.sse.attemper.sys.controller.TagController;
import com.sse.attemper.sys.controller.TenantController;
import com.sse.attemper.sys.controller.UserController;
import com.sse.attemper.sys.dao.mapper.ResourceMapper;
import com.sse.attemper.sys.dao.mapper.TagMapper;
import com.sse.attemper.sys.dao.mapper.TenantMapper;
import com.sse.attemper.sys.dao.mapper.UserMapper;
import com.sse.attemper.sys.ext.service.SecretService;
import com.sse.attemper.sys.init.CustomPostConstruct;
import com.sse.attemper.sys.service.ResourceService;
import com.sse.attemper.sys.service.TagService;
import com.sse.attemper.sys.service.TenantService;
import com.sse.attemper.sys.service.UserService;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author ldang
 */
@Configuration
@EnableConfigurationProperties(SysProperties.class)
@Import({
        CustomPostConstruct.class,
        ConfigConfiguration.class
})
@ComponentScan(basePackageClasses = {
        //service
        TenantService.class,
        UserService.class,
        ResourceService.class,
        TagService.class,
        SecretService.class,

        //controller
        TenantController.class,
        ResourceController.class,
        UserController.class,
        TagController.class,

        TenantMapper.class,
        ResourceMapper.class,
        UserMapper.class,
        TagMapper.class
})
public class SysConfiguration {
}
