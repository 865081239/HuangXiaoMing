package com.User;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Service {
	public List addUsers(){
		List<User> users = new ArrayList<User>();
		User user = new User();
		user.setId("1");
		user.setName("普通员工");
		Date date = new Date();
		user.setDate(date);
		users.add(user);
		User user1 = new User();
		user1.setId("2");;
		user1.setName("经理级");
		user1.setDate(date);
		users.add(user1);
		
		return users;
		//setUsers(users);
	}
}
