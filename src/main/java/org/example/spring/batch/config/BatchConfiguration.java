package org.example.spring.batch.config;

import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Use this config for spring batch to use a Map based JobRepository (instead of database)
 */
@Configuration
public class BatchConfiguration extends DefaultBatchConfigurer {

    @Override
    public void setDataSource(DataSource dataSource) {
        /**
         * override to do not set datasource even if a datasource exist.
         * initialize will use a Map based JobRepository (instead of database)
         *
         */
    }

}
