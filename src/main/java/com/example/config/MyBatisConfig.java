package com.example.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
@ComponentScan("com.example")
@PropertySource( "classpath:jdbc.properties" )
public class MyBatisConfig {
    @Value( "${jdbc.driver}" )
    private String driver;
    @Value( "${jdbc.url}" )
    private String url;
    @Value ("${jdbc.username}")
    private String username;
    @Value( "${jdbc.password}" )
    private String password;
    @Bean
    public DataSource dataSource(){
        DruidDataSource dataSource = new DruidDataSource( );
        dataSource.setDriverClassName( driver );
        dataSource.setUrl( url );
        dataSource.setUsername( username );
        dataSource.setPassword( password );

        return dataSource;

    }
    @Bean
    public static SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean( );
        sqlSessionFactoryBean.setDataSource( dataSource );
        return sqlSessionFactoryBean.getObject();
    }
    @Bean
    public static MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer configurer = new MapperScannerConfigurer( );
        configurer.setBasePackage( "com.example.dao" );
        return configurer;
    }




}
