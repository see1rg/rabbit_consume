package com.esee1rg.rabbitappconsume.repositories;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ThirdRepository {
    private final JdbcTemplate thirdJdbcTemplate;
    private final Logger logger = LoggerFactory.getLogger(ThirdRepository.class);

    public ThirdRepository(@Qualifier("thirdJdbcTemplate") JdbcTemplate thirdJdbcTemplate) {
        this.thirdJdbcTemplate = thirdJdbcTemplate;
    }

    public void save(String message) {
        logger.info("save " + message);
        thirdJdbcTemplate.update(FirstRepository.INSERT_SQL, message);
    }
}
