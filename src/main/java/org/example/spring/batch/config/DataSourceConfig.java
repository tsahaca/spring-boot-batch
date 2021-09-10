package org.example.spring.batch.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.autoconfigure.batch.BatchDataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean
    @ConfigurationProperties(prefix="spring.datasource-batch")
    public DataSourceProperties batchDataSourceProperties(){
        return new DataSourceProperties();
    }

    @Bean
    @BatchDataSource
    @ConfigurationProperties(prefix="spring.datasource-batch.configuration")
    public DataSource h2dataSource(){
        return batchDataSourceProperties().initializeDataSourceBuilder().type(HikariDataSource.class).build();

    }

    @Bean
    @ConfigurationProperties(prefix="spring.datasource")
    @Primary
    public DataSourceProperties primaryDataSourceProperties(){
        return new DataSourceProperties();
    }

    @Bean
    @ConfigurationProperties(prefix="spring.datasource.configuration")
    @Primary
    public DataSource primary(){
        return primaryDataSourceProperties().initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }
}
