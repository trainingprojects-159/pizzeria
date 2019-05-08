package com.mphasis.pizzeria.configurations;
import java.util.Properties;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
@Configuration
@EnableWebMvc
@EnableAspectJAutoProxy
@EnableTransactionManagement
@ComponentScan(basePackages = "com.mphasis.pizzeria.*")
public class AppConfig {
@Bean
	public DriverManagerDataSource getDatSource()
	{
		DriverManagerDataSource d =new DriverManagerDataSource();
		d.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		d.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		d.setUsername("pizzeria");
		d.setPassword("123");
		return d;
	}
	@Bean
	public LocalSessionFactoryBean getSessionFactoryBean()
	{
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(getDatSource());
		sessionFactory.setPackagesToScan("com.mphasis.pizzeria.entities");
		
		//sessionFactory.setAnnotatedClasses(Employee1.class);
		//sessionFactory.setAnnotatedClasses(Department1.class);
		Properties properties = new Properties();
		properties.put("hibernate.dialect", "org.hibernate.dialect.OracleDialect");
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		sessionFactory.setHibernateProperties(properties);
		return sessionFactory;
		
	}
	
	@Bean
	public HibernateTransactionManager getHibernateTransactionManger(SessionFactory s) {
		HibernateTransactionManager hibernateTransactionManager=new HibernateTransactionManager();
		hibernateTransactionManager.setSessionFactory(s);
		return hibernateTransactionManager;
	}
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedMethods("HEAD","GET","POST","PUT","DELETE")
				.allowedHeaders("Origin", "X-Requested-With", "Content-Type","Accept");
			}
		};
	}

	
}
