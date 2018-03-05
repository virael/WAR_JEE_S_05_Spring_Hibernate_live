package pl.coderslab.conf;

import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = {"pl.coderslab.dao.impl", "pl.coderslab.controller"})
@EnableWebMvc
public class AppConfiguration {
	
	@Bean
	public LocalEntityManagerFactoryBean entityManagerFactory() {
		final LocalEntityManagerFactoryBean emfb = new LocalEntityManagerFactoryBean();
		emfb.setPersistenceUnitName("bookstorePersistenceUnit");
		return emfb;
	}

	@Bean
	public JpaTransactionManager transactionManager(final EntityManagerFactory emf) {
		final JpaTransactionManager tm = new JpaTransactionManager(emf);
		return tm;
	}
}