package com.github.wendao76.testing.config.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * jdbc相关配置文件位置
 *
 * @author wendao76
 */
@Data
@Component
@ConfigurationProperties("spring.datasource")
public class JdbcProperties {
    private String url;
    private String username;
    private String password;
    private String driverClassName;
}
