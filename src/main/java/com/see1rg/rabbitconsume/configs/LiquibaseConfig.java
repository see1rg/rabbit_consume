package com.see1rg.rabbitconsume.configs;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class LiquibaseConfig {
    private static final String CLASSPATH = "classpath:liquibase/changelog-master.yml";

    @Bean
    public SpringLiquibase firstLiquibase(@Qualifier("firstDataSource") DataSource firstDataSource) {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setDataSource(firstDataSource);
        liquibase.setChangeLog(CLASSPATH);
        return liquibase;
    }

    @Bean
    public SpringLiquibase secondLiquibase(@Qualifier("secondDataSource") DataSource secondDataSource) {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setDataSource(secondDataSource);
        liquibase.setChangeLog(CLASSPATH);
        return liquibase;
    }

    @Bean
    public SpringLiquibase thirdLiquibase(@Qualifier("thirdDataSource") DataSource thirdDataSource) {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setDataSource(thirdDataSource);
        liquibase.setChangeLog(CLASSPATH);
        return liquibase;
    }
}