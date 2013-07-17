package com.android.eazypass.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.eazypass.R;
import com.android.eazypass.sqlite.DatabaseAdapter;
import com.android.eazypass.sqlite.dao.SQLiteUserDAO;
import com.android.eazypass.sqlite.dao.interfaces.UserDAO;
import com.android.eazypass.sqlite.entity.User;

public class Register extends Activity {
	private EditText editTextUserName;
	private EditText editTextPassword;
	private EditText editTextConfirmPassword;
	private EditText editEmail, editContact;
	
	private Button btnCreateAccount, cancel;
	
	private DatabaseAdapter databaseAdapter;
	private UserDAO userDAO;
	
	private String username, password, confirmPassword, email, contactNumber;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.signup);

		// get Instance of Database Adapter
		databaseAdapter = new DatabaseAdapter(this);		
		userDAO = new SQLiteUserDAO(databaseAdapter.open().getDatabaseInstance());

		// Get References of Views
		editTextUserName = (EditText) findViewById(R.id.editTextUserName);
		editTextPassword = (EditText) findViewById(R.id.editTextPassword);
		editTextConfirmPassword = (EditText) findViewById(R.id.confirmPassword);
		editEmail = (EditText) findViewById(R.id.email);
		editContact = (EditText) findViewById(R.id.contactNumber);
		btnCreateAccount = (Button) findViewById(R.id.CreateAnAccountDialog2);
		cancel = (Button) findViewById(R.id.Cancel);
		
		btnCreateAccount.setOnClickListener(new OnClickListener() {

			public void onClick(View v) { 
				username = editTextUserName.getText().toString();
				password = editTextPassword.getText().toString();
				confirmPassword = editTextConfirmPassword.getText().toString();
				email = editEmail.getText().toString();
				contactNumber = editContact.getText().toString();
				
				// check if any of the fields are vaccant
				if (username.equals("") || password.equals("") || confirmPassword.equals("") || email.equals("") || contactNumber.equals("")) {
					Toast.makeText(getApplicationContext(), "Field Vaccant", Toast.LENGTH_LONG).show();
					return;
				}
				
				// check contact number if any char input field
				if (!contactNumber.matches("[0-9]+") || contactNumber.length() <= 3) {
					Toast.makeText(getApplicationContext(), "Invalid Contact Number", Toast.LENGTH_LONG).show();
					return;
				}
				
				// check email 
				if ( email.length() <=5) {
					Toast.makeText(getApplicationContext(), "Invalid Email", Toast.LENGTH_LONG).show();
					return;
				}
					
				// check if both password matches
				if (!password.equals(confirmPassword)) {
					Toast.makeText(getApplicationContext(), "Password does not match", Toast.LENGTH_LONG).show();
					return;
				} else {
					//store data in the database and close.
					onFinish();
				}
			}
		});
		
		cancel.setOnClickListener(new OnClickListener() {
	
			@Override
			public void onClick(View v) {
				finish();
			}
		});
	}

	protected void onFinish() {
		super.finish();
		
		// Save the Data in Database
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		userDAO.save(user);
		
		Toast.makeText(getApplicationContext(), "Account Successfully Created!", Toast.LENGTH_LONG).show();
		
	}
	
	protected void onStop() {
		super.onStop();
	}
	
	protected void onDestroy() {
		super.onDestroy();
		databaseAdapter.close();
	}
}
