package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.User;
import com.util.DBInteraction;

public class UserDao implements IUser{

	@Override
	public int adduser(User u) {
		DBInteraction.connect();
		int nb=DBInteraction.Maj("insert into user(lg,ps) values ('"+u.getLg()+"','"+u.getPass()+"')");
		DBInteraction.disconnect();
		return nb;
	}

	@Override
	public int adduser(String lg, String ps) {
		DBInteraction.connect();
		int nb=DBInteraction.Maj("insert into user(lg,ps) values ('"+lg+"','"+ps+"')");
		DBInteraction.disconnect();
		return nb;
	}

	@Override
	public User findById(int id) {
		User u=null;
		DBInteraction.connect();
		ResultSet rs = DBInteraction.Select("select * from user where id="+id);
		try {
			if(rs.next())
			{
				u=new User();
				u.setLg(rs.getString("lg"));
				u.setPass(rs.getString("ps"));
				u.setId(id);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBInteraction.disconnect();
		
		return u;
	}

	@Override
	public List<User> allUsers() {
		
		List<User> us=new ArrayList<User>();
		DBInteraction.connect();
		ResultSet rs = DBInteraction.Select("select * from user ");
		try {
			while(rs.next())
			{
				User u=new User();
				u.setLg(rs.getString("lg"));
				u.setPass(rs.getString("ps"));
				u.setId(rs.getInt("id"));
				us.add(u);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBInteraction.disconnect();
		return us;
	}

}
