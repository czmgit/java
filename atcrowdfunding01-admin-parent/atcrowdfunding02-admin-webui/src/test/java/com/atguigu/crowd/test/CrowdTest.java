package com.atguigu.crowd.test;

import static org.hamcrest.CoreMatchers.nullValue;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.atguigu.crowd.entity.Admin;
import com.atguigu.crowd.mapper.AdminMapper;
import com.atguigu.crowd.service.api.AdminService;

//�����ϱ�Ǳ�Ҫ��ע�⣬spring����junit
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-persist-mybatis.xml","classpath:spring-persist-tx.xml"})
public class CrowdTest {
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private AdminMapper adminMapper;
	
	@Autowired
	private AdminService adminService;
	
	@Test
	public void testTX() {
		Admin admin = new Admin(null, "cat", "11222222", "è","cat@123.com", null);
		adminService.saveAdmin(admin);
	//	throw new RuntimeException();
	}
	
	@Test
	public void testlog() {
		//1.��ȡlogger�������ﴫ���class������ǵ�ǰ��ӡ��־����
		Logger logger = LoggerFactory.getLogger(CrowdTest.class);
		//2.���ݲ�ͬ��־�����ӡ��־
		logger.debug("hello log!");	
		logger.info("info logger");
		logger.warn("warn logger");
		logger.error("error logger");
	}
	
	@Test
	public void testInsertAdmin() {
		Admin admin = new Admin(null,"tom","123123","��ķ","tom@163.com",null);
		adminMapper.insert(admin);
		//throw new RuntimeException();
		
		//sysout��������һ��IO������ͨ��IO�Ĳ����ǱȽ��������ܵģ������Ŀ�е�sysout�ܶ࣬��ô�����ܵ�Ӱ��ͱȽϴ���
		//System.out.println("��Ӱ���������"+insert);
	}
	@Test
	public void testConnection() throws SQLException {
		Connection connection = dataSource.getConnection();
		System.out.println("234234:"+connection);
	}
}