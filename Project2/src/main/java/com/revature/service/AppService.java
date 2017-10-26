package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.Dao;

@Service()
public class AppService {
	
	@Autowired
	Dao dao;

}
