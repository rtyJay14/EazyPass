package com.android.eazypass.sqlite;

import java.util.ResourceBundle;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DatabaseAdapter {

	// Variable to hold the database instance
	public SQLiteDatabase db;
	// Context of the application using the database.
	private final Context context;
	// Database open/upgrade helper
	private DatabaseHelper dbHelper;
	
	private ResourceBundle props;

	public DatabaseAdapter(Context _context) {
		context = _context;
		props = ResourceBundle.getBundle("com.android.eazypass.sqlite.database");
		dbHelper = new DatabaseHelper(context, props.getString("database.name") , null,
				Integer.parseInt(props.getString("database.version")));		
	}

	public DatabaseAdapter open() throws SQLException {
		db = dbHelper.getWritableDatabase();
		return this;
	}
	
	public SQLiteDatabase getDatabaseInstance() {
		return db;
	}

	public void close() {
		db.close();
	}

}
