package com.stitchingRetriever.stitchBuilderAPI.stitchBuilderAPI.model;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {
    @Bean
    public DataSource datasource() {
        return DataSourceBuilder.create()
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .url("jdbc:mysql://localhost:3306/DBStitchGuideBuilder?useSSL=false")
                .username("root")
                .password("pupperlupin")
                .build();
    }
}
