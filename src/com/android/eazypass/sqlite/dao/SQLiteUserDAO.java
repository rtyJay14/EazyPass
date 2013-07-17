package com.android.eazypass.sqlite.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.android.eazypass.sqlite.dao.interfaces.UserDAO;
import com.android.eazypass.sqlite.entity.User;

public class SQLiteUserDAO extends AbstractDAO implements UserDAO {
	
	String tempUsername, tempEmail;
	
	public SQLiteUserDAO(SQLiteDatabase db) {
		super(db);
	}

	@Override
	public void save(User user) {
		if (user == null) {
			throw new IllegalArgumentException("User instance cannot be null");
		}
		
		ContentValues newValues = new ContentValues();
		// Assign values for each row.
		newValues.put("USERNAME", user.getUsername());
		newValues.put("PASSWORD", user.getPassword());
//		newValues.put("EMAIL", user.getEmail());

		// Insert the row into your table
		getDb().insert("LOGIN", null, newValues);
	}

	@Override
	public void update(User user) {
		if (user == null) {
			throw new IllegalArgumentException("User instance cannot be null");
		}
		// Define the updated row content.
		ContentValues updatedValues = new ContentValues();
		// Assign values for each row.
		updatedValues.put("USERNAME", user.getUsername());
		updatedValues.put("PASSWORD", user.getPassword());
		updatedValues.put("EMAIL", user.getEmail());

		String where = "USERNAME = ?";
		getDb().update("LOGIN", updatedValues, where,
				new String[] { user.getUsername() });

	}

	@Override
	public void deleteByUsername(String username) {
		checkUsername(username);
		
		String where = "USERNAME=?";
		int numberOFEntriesDeleted = getDb().delete("LOGIN", where,
				new String[] { username });

		if (numberOFEntriesDeleted == 0) {
			throw new RuntimeException("Failed to delete user account.");
		}

	}

	@Override
	public User findByUsername(String username) {
		checkUsername(username);
		
		Cursor cursor = getDb().query("LOGIN", null, " USERNAME=?",
				new String[] { username }, null, null, null);
		if (cursor.getCount() < 1) // UserName Not Exist
		{
			cursor.close();
			throw new RuntimeException("Username not found.");
		}
		cursor.moveToFirst();
		String tempPassword = cursor.getString(cursor
				.getColumnIndex("PASSWORD"));
		tempUsername = cursor.getString(cursor
				.getColumnIndex("USERNAME"));
		cursor.close();

		User user = new User();
		user.setUsername(tempUsername);
		user.setPassword(tempPassword);

		return user;
	}
	
	private void checkUsername(String username) {
		if(username == null || username.trim().equals("")) {
			throw new IllegalArgumentException("Username cannot be left blank.");
		}
	}
}
