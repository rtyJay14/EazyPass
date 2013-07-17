package com.android.eazypass.sqlite;

import java.util.Enumeration;
import java.util.ResourceBundle;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {
	private ResourceBundle props;

	public DatabaseHelper(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);
		props = ResourceBundle.getBundle("com.android.eazypass.sqlite.database_script");
	}

	// Called when no database exists in disk and the helper class needs
	// to create a new one.
	@Override
	public void onCreate(SQLiteDatabase _db) {
		Enumeration<String> keys = props.getKeys();		
		while (keys.hasMoreElements()) {
			String key = keys.nextElement();
			_db.execSQL(props.getString(key));
		}
	}

	// Called when there is a database version mismatch meaning that the version
	// of the database on disk needs to be upgraded to the current version.
	@Override
	public void onUpgrade(SQLiteDatabase _db, int _oldVersion, int _newVersion) {
		// Log the version upgrade.
		Log.w("TaskDBAdapter", "Upgrading from version " + _oldVersion + " to " + _newVersion + ", which will destroy all old data");

		// Upgrade the existing database to conform to the new version. Multiple
		// previous versions can be handled by comparing _oldVersion and
		// _newVersion
		// values.
		// The simplest case is to drop the old table and create a new one.
		_db.execSQL("DROP TABLE IF EXISTS " + "TEMPLATE");
		// Create a new one.
		onCreate(_db);
	}

}
