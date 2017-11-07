package com.revature.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.revature.beans.LaneType;
import com.revature.service.AppService;
 
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/beans.xml"})
public class ServiceTest {

	@Autowired
	AppService service;

	@Test
	public void logsExist() {
		assertNotNull(service.getLogList());
	}
	
	@Test
	public void laneExist() {
		LaneType testLane = new LaneType(1, null);
		assertNotNull(service.getLane(testLane));
		// converts the object to a string because even of the object is the same won't pass the test. 
		assertEquals(new LaneType(1, "Backlog").toString(), service.getLane(testLane).toString());
	}

}
