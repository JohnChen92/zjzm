package com.chzm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableConfigurationProperties
@EnableTransactionManagement
@PropertySource(
		ignoreResourceNotFound = true,
		value = {
			"classpath:/application.properties",
			"classpath:/config/dataSource.properties",
			"classpath:/config/mybatis.properties"
		}
	)
public class Application {

	private static final Logger logger = LoggerFactory.getLogger(Application.class);
	
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
		String[] activeProfiles = ctx.getEnvironment().getActiveProfiles();
	    for (String profile : activeProfiles) {
		    logger.info("Spring Boot use profile:{}" , profile);
	    }
	}
	
	/**测试请求
	 * http://localhost:8080/product/saveProduct?loginOpenId=oF27W5dUjQR5YRN9hiuderAY7lJc&userId=123&picUrl=abc&name=12345&sellPoint=098&num=1&withHoldQuantity=1&status=ture&sortOrder=1&volume=1&price=1&isHpageList=1
	 */
}
