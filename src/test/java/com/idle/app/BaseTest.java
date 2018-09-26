package com.idle.app;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import junit.framework.TestCase;

/**
 * @author lee
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/persistence-context.xml", "classpath:/servlet-context.xml", "file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class BaseTest extends TestCase{
	
}
