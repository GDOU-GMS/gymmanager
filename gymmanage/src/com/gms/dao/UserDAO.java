package com.gms.dao;

import java.util.List;

import com.gms.domain.User;

public interface UserDAO {
	public abstract boolean deleteUser(int id);

	public abstract List<User> getUsers(String studentNo, String name,
			String academy);
	public abstract List<User> getAllUsers();

}