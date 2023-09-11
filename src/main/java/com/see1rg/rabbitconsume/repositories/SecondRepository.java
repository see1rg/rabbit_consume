package com.see1rg.rabbitconsume.repositories;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SecondRepository {
    private final JdbcTemplate secondJdbcTemplate;
    private final Logger logger = LoggerFactory.getLogger(SecondRepository.class);

    public SecondRepository(@Qualifier("secondJdbcTemplate") JdbcTemplate secondJdbcTemplate) {
        this.secondJdbcTemplate = secondJdbcTemplate;
    }

    public void save(String message) {
        logger.info("save " + message);
        secondJdbcTemplate.update(FirstRepository.INSERT_SQL, message);
    }
}
