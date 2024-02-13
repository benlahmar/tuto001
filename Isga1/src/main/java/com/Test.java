package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.dao.UserDao;
import com.util.DBInteraction;

public class Test {

	public static void main(String[] args) {
		
		UserDao dao=new UserDao();
		dao.adduser("mm", "ff");
		

	}

}
