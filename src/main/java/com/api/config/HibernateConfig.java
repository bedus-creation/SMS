package com.api.config;

import org.apache.commons.dbcp2.BasicDataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = {"com.api.dto"})
@EnableTransactionManagement
public class HibernateConfig {

    public final static String DATABASE_URL="jdbc:h2:tcp://localhost/~/spring";
    public final static String DATABASE_DRIVER="org.h2.Driver";
    public final static String DATABASE_DIALECT="org.hibernate.dialect.H2Dialect";
    public final static String DATABASE_USERNAME="sa";
    public final static String DATABASE_PASSWORD="";

    @Bean
    public DataSource getDataSource(){
        BasicDataSource dataSource=new BasicDataSource();

        dataSource.setDriverClassName(DATABASE_DRIVER);
        dataSource.setUrl(DATABASE_URL);
        dataSource.setUsername(DATABASE_USERNAME);
        dataSource.setPassword(DATABASE_PASSWORD);

        return dataSource;
    }


    @Bean
    public SessionFactory getSessionFactory(DataSource datasource){
        LocalSessionFactoryBuilder builder=new LocalSessionFactoryBuilder(datasource);
        builder.addProperties(getHibernateProperties());
        builder.scanPackages("com.api.dto");
        return builder.buildSessionFactory();
    }

    private Properties getHibernateProperties() {
        Properties properties=new Properties();
        properties.put("hibernate.dialect",DATABASE_DIALECT);
        properties.put("hibernate.show_sql","true");
        properties.put("hibernate.format_sql","true");
        return properties;
    }

    @Bean
    public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory){
        HibernateTransactionManager transactionManager=new HibernateTransactionManager(sessionFactory);
        return transactionManager;
    }

}
