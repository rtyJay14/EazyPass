package com.android.eazypass.sqlite.dao.interfaces;

import com.android.eazypass.sqlite.entity.User;

public interface UserDAO {
	public void save(User user);

	public void update(User user);

	public void deleteByUsername(String username);

	public User findByUsername(String username);
	
}
