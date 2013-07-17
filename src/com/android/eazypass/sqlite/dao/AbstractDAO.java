package com.android.eazypass.sqlite.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public abstract class AbstractDAO {
	private SQLiteDatabase db;
	private Context context;
	
	protected AbstractDAO(SQLiteDatabase db) {
		this(db, null);
	}
	
	protected AbstractDAO(SQLiteDatabase db, Context context) {
		this.db = db;
		this.context = context;
	}
	
	public SQLiteDatabase getDb() {
		return db;
	}
	
	public void setDb(SQLiteDatabase db) {
		this.db = db;
	}
	
	public void setContext(Context context) {
		this.context = context;
	}
	
	public Context getContext() {
		return context;
	}
}
