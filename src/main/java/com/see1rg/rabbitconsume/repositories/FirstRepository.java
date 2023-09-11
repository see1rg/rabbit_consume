package com.see1rg.rabbitconsume.repositories;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class FirstRepository{

    static final String INSERT_SQL = "INSERT INTO messages (message) VALUES (?)";
    private final JdbcTemplate firstJdbcTemplate;
    private final Logger logger = LoggerFactory.getLogger(FirstRepository.class);

    public FirstRepository(@Qualifier("firstJdbcTemplate") JdbcTemplate firstJdbcTemplate) {
        this.firstJdbcTemplate = firstJdbcTemplate;
    }

    public void save(String message){
        logger.info("save " + message);
        firstJdbcTemplate.update(INSERT_SQL, message);
    }
}
