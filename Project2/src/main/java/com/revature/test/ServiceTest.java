package com.revature.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.revature.beans.Board;
import com.revature.beans.LaneType;
import com.revature.beans.RoleType;
import com.revature.beans.ScrumUser;
import com.revature.beans.Story;
import com.revature.beans.Task;
import com.revature.service.AppService;
 
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/beans.xml"})
public class ServiceTest {

	@Autowired
	AppService service;

	@Test
	public void manyLogsExist() {
		assertNotNull(service.getLogList());
	}
	
	@Test
	public void manyUsersExist() {
		assertNotNull(service.getAllUserList());
	}
	
	@Test
	public void manyLaneTypesExist() {
		assertNotNull(service.getLaneTypeList());
	}
	
	@Test
	public void LaneExist() {
		LaneType testLane = new LaneType(1, null);
		// converts the object to a string because even of the object is the same won't pass the test. 
		assertEquals(new LaneType(1, "Backlog").toString(), service.getLane(testLane).toString());
	}
	
	@Test 
	public void BoardExist() {
		Board testBoard = new Board(2);
		// converts the object to a string because even of the object is the same won't pass the test. 
		assertEquals(new Board(2, "Allen Test").toString(), service.getBoardDetails(testBoard).toString());
	}
	
	@Test 
	public void userNotOnBoardExist() {
		Board testBoard = new Board(2);
		// converts the object to a string because even of the object is the same won't pass the test. 
		assertNotNull(service.getUsersNotOnBoard(testBoard));
	}
	
	@Test 
	public void userOnBoardExist() {
		Board testBoard = new Board(2);
		// converts the object to a string because even of the object is the same won't pass the test. 
		assertNotNull(service.getUserList(testBoard));
	}
	
	@Test
	public void userExist() {
		ScrumUser testSu = new ScrumUser(4, null, null, null, null, null);
		RoleType RT = new RoleType(4, "QA");
		ScrumUser SU = new ScrumUser(4, RT, "QA", "Test", "qa", "qa");
		// converts the object to a string because even of the object is the same won't pass the test. 
		assertEquals(SU.toString(), service.getScrumUserById(testSu).toString());
	}
	
	@Test
	public void userNameExist() {
		ScrumUser testSu = new ScrumUser("qa", "qa");
		RoleType RT = new RoleType(4, "QA");
		ScrumUser SU = new ScrumUser(4, RT, "QA", "Test", "qa", "qa");
		// converts the object to a string because even of the object is the same won't pass the test. 
		assertEquals(SU.toString(), service.getScrumUserByUsername(testSu).toString());
	}
}
