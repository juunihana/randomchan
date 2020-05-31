package org.projects.randomchan.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.Objects;

@Configuration
@Primary
@PropertySource({"classpath:application.yml"})
public class DatabaseConfig {
    private final Environment environment;

    @Autowired
    public DatabaseConfig(Environment environment) {
        this.environment = environment;
    }

    @Bean
    public DataSource userDataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName(Objects.requireNonNull(environment.getProperty("spring.datasource.driverClassName")));
        driverManagerDataSource.setUrl(environment.getProperty("spring.datasource.url"));
        driverManagerDataSource.setUsername(environment.getProperty("spring.datasource.username"));
        driverManagerDataSource.setPassword(environment.getProperty("spring.datasource.password"));
        return driverManagerDataSource;
    }
}