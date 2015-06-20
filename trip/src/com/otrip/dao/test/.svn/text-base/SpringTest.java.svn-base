package com.otrip.dao.test;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.otrip.dao.ws.impl.WsDestinationDaoImpl;
import com.otrip.webservice.trip.acti.actiImpl.GetActiWsImpl;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value="src")

@ContextConfiguration("classpath*:spring-test.xml")
public class SpringTest extends AbstractJUnit4SpringContextTests{

	private static GetActiWsImpl ga;
	
	private MockMvc mockMvc;
	
	@Before
	public void before()
	{
		mockMvc = MockMvcBuilders.webAppContextSetup((WebApplicationContext) this.applicationContext).build();
	}
	@Test
	public void test()
	{
		try {
			//ga=new GetActiWsImpl();
			WsDestinationDaoImpl wd=new WsDestinationDaoImpl();
			if(this.applicationContext.getBean("sessionFactory")==null);
			{
				
				System.out.println("error");
			}
			
			wd.findOtActiDestinationByPosition(113.324334, 30.270059, "城市");
			//ga.getIndexActi("23", "43");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
