package br.com.desafio.spotippos.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import br.com.desafio.spotippos.controller.PropertiesController;
import br.com.desafio.spotippos.model.Boundaries;
import br.com.desafio.spotippos.model.Point;
import br.com.desafio.spotippos.model.Property;
import br.com.desafio.spotippos.model.Province;
import br.com.desafio.spotippos.repository.PropertiesRepository;
import br.com.desafio.spotippos.service.PropertiesService;

@EnableWebMvc
@ComponentScan(basePackageClasses={Property.class, Province.class, Boundaries.class, Point.class,  
		PropertiesController.class, PropertiesService.class, PropertiesRepository.class})
public class AppWebConfiguration {

	@Bean
	public InternalResourceViewResolver internalResourceViewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	@Bean
	public MessageSource messageSource(){
		ReloadableResourceBundleMessageSource bundle = new ReloadableResourceBundleMessageSource();
		bundle.setBasename("/WEB-INF/messages.properties");
		bundle.setDefaultEncoding("UTF-8");
		bundle.setCacheSeconds(1);
		return bundle;
	}
}
