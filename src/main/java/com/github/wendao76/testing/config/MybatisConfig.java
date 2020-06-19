package com.github.wendao76.testing.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.optimize.JsqlParserCountOptimize;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.github.wendao76.testing.config.property.JdbcProperties;
import com.github.wendao76.testing.entity.mybatis.MyMetaObjectHandler;
import com.zaxxer.hikari.HikariDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * mybatis配置文件
 *
 * @author wendao76
 * @version 1.0
 * @description 类描述信息
 * @className MybatisConfig
 * @date 2020-6-19 10:36
 */
@Configuration
@MapperScan("com.github.wendao76.testing.dao")
public class MybatisConfig {
	@Autowired
	JdbcProperties jdbcProperties;

	@Bean
	public DataSource dataSource() {
		HikariDataSource hikariDataSource = new HikariDataSource();
		hikariDataSource.setDriverClassName(jdbcProperties.getDriverClassName());
		hikariDataSource.setJdbcUrl(jdbcProperties.getUrl());
		hikariDataSource.setUsername(jdbcProperties.getUsername());
		hikariDataSource.setPassword(jdbcProperties.getPassword());
		return hikariDataSource;
	}

	/**
	 * @param
	 * @Description 分页插件配置
	 * @Return com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor
	 * @Author lys
	 * @Date 2020-5-27 9:19
	 **/
	@Bean
	@ConditionalOnMissingBean(PaginationInterceptor.class)
	public PaginationInterceptor paginationInterceptor() {
		PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
		// 设置请求的页面大于最大页后操作， true调回到首页，false 继续请求  默认false
		// paginationInterceptor.setOverflow(false);
		// 设置最大单页限制数量，默认 500 条，-1 不受限制
		paginationInterceptor.setLimit(-1);
		// 开启 count 的 join 优化,只针对部分 left join
		paginationInterceptor.setCountSqlParser(new JsqlParserCountOptimize(true));
		return paginationInterceptor;
	}

	@Bean
	@ConditionalOnMissingBean(MyMetaObjectHandler.class)
	public MyMetaObjectHandler mybatisObjectHandler() {
		return new MyMetaObjectHandler();
	}

	@Bean
	public ObjectMapper getObjectMapper() {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.LOWER_CAMEL_CASE);
		return objectMapper;
	}
}
