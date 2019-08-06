package com.chzm.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

@Configuration
@AutoConfigureAfter(MybatisAutoConfiguration.class)
@MapperScan("com.chzm.dao")
public class MybatisConfig {
	
	private static final Logger logger = LoggerFactory.getLogger(MybatisConfig.class);
	
	@Autowired
	private DataSource dataSource;
	
	@Bean
    @ConditionalOnMissingBean
    public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
    	logger.info("sqlSessionFactoryBean Create ! dateSource :{}",dataSource);
    	SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        
        //设置数据源
        bean.setDataSource(dataSource.druidDataSource());
        
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            bean.setMapperLocations(resolver.getResources("classpath:mapper/*.xml"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    
        return bean.getObject();
    }
}
