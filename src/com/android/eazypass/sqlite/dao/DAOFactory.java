package com.android.eazypass.sqlite.dao;

import android.content.Context;

public class DAOFactory {
	public static AbstractDAO getDAO(String className, Context context) {
		AbstractDAO dao = null;
		try {
			dao =  (AbstractDAO) Class.forName("com.android.eazypass"
					+ className).newInstance();
			dao.setContext(context);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dao;
	}
}
