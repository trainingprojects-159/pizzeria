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
import com.mphasis.pizzeria.entities.Admin;
import com.mphasis.pizzeria.entities.Customer;
import com.mphasis.pizzeria.entities.Orders;
import com.mphasis.pizzeria.entities.PizzaItems;
import com.mphasis.pizzeria.entities.PizzaStore;
import com.mphasis.pizzeria.entities.ShoppingCart;
import com.mphasis.pizzeria.entities.Toppings;
@Configuration
@EnableWebMvc
@EnableAspectJAutoProxy
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
		
		sessionFactory.setAnnotatedClasses(Admin.class);
		sessionFactory.setAnnotatedClasses(Customer.class);
		sessionFactory.setAnnotatedClasses(Orders.class);
		sessionFactory.setAnnotatedClasses(PizzaItems.class);
		sessionFactory.setAnnotatedClasses(PizzaStore.class);
		sessionFactory.setAnnotatedClasses(ShoppingCart.class);
		sessionFactory.setAnnotatedClasses(Toppings.class);
		Properties properties = new Properties();
		properties.put("hibernate.dialect", "org.hibernate.dialect.OracleDialect");
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		sessionFactory.setHibernateProperties(properties);
		return sessionFactory;
		
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
