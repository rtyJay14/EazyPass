package com.android.eazypass.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.eazypass.R;

public class Payment extends Activity {
	
	EditText editTextUserName;
	EditText editTextPassword;
	EditText editTextConfirmPassword;
	EditText editTextEmail;
	EditText editTextContactNumber;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.payment);
		
		editTextUserName = (EditText) findViewById(R.id.Payment_editTextUserName);
		editTextPassword = (EditText) findViewById(R.id.Payment_editTextPassword);
		editTextConfirmPassword = (EditText) findViewById(R.id.Payment_confirmPassword);
		editTextEmail = (EditText) findViewById(R.id.Payment_email);
		editTextContactNumber = (EditText) findViewById(R.id.Payment_contactNumber);
		
			
		Button b1 = (Button) findViewById(R.id.Payment_done);
		b1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				String username = editTextUserName.getText().toString();
				String password = editTextPassword.getText().toString();
				String confirm_password = editTextConfirmPassword.getText().toString();
				String email = editTextEmail.getText().toString();
				String cn = editTextContactNumber.getText().toString();
				
				if (username.equals("") || password.equals("") || confirm_password.equals("") || email.equals("") || cn.equals("")) {
					Toast.makeText(getApplicationContext(), "Field Vacant!", Toast.LENGTH_SHORT).show();
					return;
				}
								
				if (password.length() <= 5) {
					Toast.makeText(getApplicationContext(), "Password is too short!", Toast.LENGTH_LONG).show();
					return;
				}
				
				else if (password.equals(confirm_password) && (password.length() >= 5)) {
					Toast.makeText(getApplicationContext(), "Reserved!", Toast.LENGTH_SHORT).show();
					finish();
				}
				
				else {
					Toast.makeText(getApplicationContext(), "Password doesn't match!", Toast.LENGTH_SHORT).show();
				}
				
			}
		});
		
		Button b2 = (Button) findViewById(R.id.Payment_cancel);
		b2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				final AlertDialog alertDialog = new AlertDialog.Builder(Payment.this).create();
              alertDialog.setMessage("Are you sure you want to cancel?");
              alertDialog.setButton("Exit", new DialogInterface.OnClickListener() {
                 public void onClick(DialogInterface dialog, int which) {
                     alertDialog.dismiss();
                     finish();
                 }
              });
              alertDialog.setButton2("Ok", new DialogInterface.OnClickListener() {
            	  public void onClick(DialogInterface dialog, int which) {
            		  alertDialog.dismiss();
                      return;
                     }
                  });

              alertDialog.setIcon(android.R.drawable.alert_dark_frame);
              alertDialog.show();
			}
		});
	}
	
	protected void onFinish() {
		super.finish();
	}
	
	protected void onDestroy() {
		super.onDestroy();
	}
}
