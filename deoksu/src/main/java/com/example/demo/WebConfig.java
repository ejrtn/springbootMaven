package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.transaction.annotation.EnableTransactionManagement;


import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;

@Configuration
@EnableTransactionManagement
public class WebConfig implements WebMvcConfigurer {
	
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/images/**")
                .addResourceLocations("file:///D:/WorkspaceMaven/sts-4.10.0.RELEASE-workspace/deoksu/src/main/resources/static/images/");
    }
    
    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource)throws Exception{
            SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
            sessionFactory.setDataSource(dataSource);
            
            Resource[] res = new PathMatchingResourcePatternResolver().getResources("classpath:mapper/**/*Mapper.xml");
            
            sessionFactory.setMapperLocations(res);
            
            return sessionFactory.getObject();
    }
 
    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
    
}
