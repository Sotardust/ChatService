package com.dai.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourcePatternUtils;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = { "com.dai.dao" }, sqlSessionFactoryRef = "sqlSessionFactory")
public class DataSourceConfig {

    @Value("${spring.datasource.url}")
    private String dbUrl;
    @Value("${spring.datasource.username}")
    private String dbUser;
    @Value("${spring.datasource.password}")
    private String dbPassword;
    @Value("${spring.datasource.driver-class-name}")
    private String driverName;

    @Autowired
    private ResourceLoader resourceLoader;

    @Bean(name = "dataSource")
    public DataSource settleDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverName);
        dataSource.setUrl(dbUrl);
        dataSource.setUsername(dbUser);
        dataSource.setPassword(dbPassword);
        dataSource.setPoolPreparedStatements(true);
        dataSource.setMaxWait(60000);
        dataSource.setMaxActive(20);
        dataSource.setInitialSize(10);
        dataSource.setMaxPoolPreparedStatementPerConnectionSize(20);
        dataSource.setMinIdle(10);
        dataSource.setMinEvictableIdleTimeMillis(300000);
        dataSource.setTimeBetweenEvictionRunsMillis(60000);
//        dataSource.setValidationQuery("SELECT 1");
        dataSource.setTestWhileIdle(true);
        dataSource.setTestOnReturn(false);
        dataSource.setTestOnBorrow(false);
        return dataSource;
    }

    @Bean(name = "transactionManager")
    public DataSourceTransactionManager settleTransactionManager() {
        return new DataSourceTransactionManager(settleDataSource());
    }

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory settleSqlSessionFactory(@Qualifier("dataSource") DataSource settleDataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(settleDataSource);
        sessionFactory.setMapperLocations(
                ResourcePatternUtils.getResourcePatternResolver(resourceLoader).getResources("classpath:mapper/*.xml"));
        return sessionFactory.getObject();
    }
}