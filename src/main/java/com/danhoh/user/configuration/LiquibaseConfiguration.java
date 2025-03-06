package com.danhoh.user.configuration;

import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class LiquibaseConfiguration {

    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource")
    public DataSourceProperties dataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    public DataSource dataSource() {
        PGSimpleDataSource dataSource = new PGSimpleDataSource();

        dataSource.setURL(dataSourceProperties().getUrl());
        dataSource.setUser(dataSourceProperties().getUsername());
        dataSource.setPassword(dataSourceProperties().getPassword());

        return dataSource;
    }
}
