package com.idle.app;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 用来配置spring和junit整合，junit启动时加载springIOC容器
 * @author lee
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件的位置
@ContextConfiguration({"classpath:/persistence-context.xml", "classpath:/servlet-context.xml", "file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class BaseTest {
	
}
