package com.zanqian.framework.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author GanQuan
 * @date 2025-05-28 17:45
 */
@Configuration
@MapperScan("com.zanqian.modules.mapper.**")
public class MybatisPlusConfig {
}
