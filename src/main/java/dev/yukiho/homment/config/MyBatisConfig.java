package dev.yukiho.homment.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("dev.yukiho.homment.db.mapper")
public class MyBatisConfig {
}
