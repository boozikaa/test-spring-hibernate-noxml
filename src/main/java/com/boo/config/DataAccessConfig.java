package com.boo.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.boo.domain.Employee;

@Configuration
@EnableTransactionManagement
@PropertySource({ "classpath:persistence-postgresql.properties" })
@ComponentScan({ "com.boo" })
public class DataAccessConfig {

	@Autowired
	private Environment env;

	@Bean
	public DataSource dataSource() {
		String jdniDataSource = env.getProperty("jndi.datasource");
		System.out.println(jdniDataSource);
		if (jdniDataSource != null && jdniDataSource != "") {
			final JndiDataSourceLookup dsLookup = new JndiDataSourceLookup();
			dsLookup.setResourceRef(true);
			DataSource dataSource = dsLookup.getDataSource(jdniDataSource);
			return dataSource;
		} else {
			final BasicDataSource dataSource = new BasicDataSource();
			dataSource.setDriverClassName(env
					.getProperty("jdbc.driverClassName"));
			dataSource.setUrl(env.getProperty("jdbc.url"));
			dataSource.setUsername(env.getProperty("jdbc.user"));
			dataSource.setPassword(env.getProperty("jdbc.pass"));    
			dataSource.setValidationQuery("select 1");
		    dataSource.setTestOnBorrow(true);
		    dataSource.setTestOnReturn(true);
		    dataSource.setTestWhileIdle(true);
		    dataSource.setTimeBetweenEvictionRunsMillis(1800000);
		    dataSource.setNumTestsPerEvictionRun(3);
		    dataSource.setMinEvictableIdleTimeMillis(1800000);
			return dataSource;
		}
	}

	final Properties hibernateProperties() {
		final Properties hibernateProperties = new Properties();
		/*
		 * hibernateProperties.setProperty("hibernate.hbm2ddl.auto",
		 * env.getProperty("hibernate.hbm2ddl.auto"));
		 */
		hibernateProperties.setProperty("hibernate.dialect",
				env.getProperty("hibernate.dialect"));

		hibernateProperties.setProperty("hibernate.show_sql",
				env.getProperty("hibernate.show_sql"));


		return hibernateProperties;
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		final LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan(new String[] { "com.boo.model" });
		sessionFactory.setAnnotatedClasses(new Class[] { Employee.class });// new
																			// row!!!
		sessionFactory.setHibernateProperties(hibernateProperties());

		return sessionFactory;
	}

	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(
			SessionFactory sessionFactory) {
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory);
		return txManager;
	}
}
