package com.chzm.test.config;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.chzm.Application;
import com.chzm.config.DataSource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class druidConfigTest {

	@Autowired
	private DataSource dataSource;
	
	@Test
	public void testDruidConnection() {
		try {
			System.out.println("============================getConnection==========================");
			Connection conn = dataSource.druidDataSource().getConnection();
			System.out.println("============================getConnection==========================");
			System.out.println(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
