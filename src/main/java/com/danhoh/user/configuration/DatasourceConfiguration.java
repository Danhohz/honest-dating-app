package com.danhoh.user.configuration;

import io.r2dbc.postgresql.PostgresqlConnectionConfiguration;
import io.r2dbc.postgresql.PostgresqlConnectionFactory;
import io.r2dbc.spi.ConnectionFactory;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;

@Slf4j
@Configuration
public class DatasourceConfiguration {

    @Bean
    public ConnectionFactory connectionFactory() {
        // todo remove hardcoded values
        return new PostgresqlConnectionFactory(PostgresqlConnectionConfiguration.builder()
                .host("localhost")
                .port(5432)
                .database("application_user")
                .username("postgres")
                .password("postgres")
                .build());
    }

    @Bean
    public R2dbcEntityTemplate r2dbcTemplate() {
        return new R2dbcEntityTemplate(connectionFactory());
    }

    @PostConstruct
    void init() {
    }

}
