package com.core.pilot.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@Slf4j
public class Datasource {


    @Bean
    public DataSource dataSourcePostgres(){
        log.info("creating postgres datasource bean");
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:postgresql://localhost:5432/postgres");
        config.setUsername("springboot");
        config.setPassword("root");
        config.setDriverClassName("org.postgresql.Driver");

        // Optional HikariCP settings
        config.setMaximumPoolSize(2); // Maximum number of connections in the pool
        config.setMinimumIdle(1);     // Minimum idle connections
        config.setIdleTimeout(30000); // 30 seconds idle timeout
        config.setMaxLifetime(1800000); // 30 minutes max lifetime for a connection

        // Create DataSource
        return new HikariDataSource(config);
    }

}
