package com.apispring.api;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

//Connect SQL
@Configuration
public class DatasourceConfig {
    @Bean
    public DataSource dataSource()
    {
        DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
        dataSourceBuilder.url("jdbc:mysql://localhost:3306/springdb");
        dataSourceBuilder.username("root");
        dataSourceBuilder.password("");
        return dataSourceBuilder.build();
    }
}
