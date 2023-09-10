package com.esee1rg.rabbitappconsume.configs;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean
    @Qualifier("firstDataSource")
    @ConfigurationProperties(prefix = "first.datasource")
    DataSource firstDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @Qualifier("secondDataSource")
    @ConfigurationProperties(prefix = "second.datasource")
    DataSource secondDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @Qualifier("thirdDataSource")
    @ConfigurationProperties(prefix = "third.datasource")
    DataSource thirdDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @Qualifier("firstDataSource")
    JdbcTemplate firstJdbcTemplate(@Qualifier("firstDataSource") DataSource firstDataSource) {
        return new JdbcTemplate(firstDataSource);
    }

    @Bean
    @Qualifier("secondDataSource")
    JdbcTemplate secondJdbcTemplate(@Qualifier("secondDataSource") DataSource secondDataSource) {
        return new JdbcTemplate(secondDataSource);
    }

    @Bean
    @Qualifier("thirdDataSource")
    JdbcTemplate thirdJdbcTemplate(@Qualifier("thirdDataSource") DataSource thirdDataSource) {
        return new JdbcTemplate(thirdDataSource);
    }
}
