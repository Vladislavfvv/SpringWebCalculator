package by.tms.configuration;

import by.tms.configuration.interceptor.RegistrationInterceptor;
import by.tms.configuration.interceptor.SecurityInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.servlet.annotation.WebListener;
import java.util.concurrent.atomic.AtomicLong;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "by.tms")
public class WebConfiguration extends WebMvcConfigurerAdapter {
    @Autowired
    RegistrationInterceptor registrationInterceptor;

    @Autowired
    SecurityInterceptor securityInterceptor;

    @Bean
    AtomicLong userIdGenerator() {
        return new AtomicLong(0);
    }

    @Bean
    AtomicLong operationIdGenerator() {
        return new AtomicLong(0);
    }

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setSuffix(".jsp");
        internalResourceViewResolver.setPrefix("/pages/");
        return internalResourceViewResolver;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(registrationInterceptor)
                .addPathPatterns("/registration");
        registry.addInterceptor(securityInterceptor)
                .addPathPatterns("/**").excludePathPatterns("/registration", "/authorisation");
    }
}
