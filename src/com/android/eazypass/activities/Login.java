package com.android.eazypass.activities;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.eazypass.R;
import com.android.eazypass.other.ImageAdapter;
import com.android.eazypass.sqlite.DatabaseAdapter;
import com.android.eazypass.sqlite.dao.SQLiteUserDAO;
import com.android.eazypass.sqlite.dao.interfaces.UserDAO;
import com.android.eazypass.sqlite.entity.User;
import com.facebook.android.AsyncFacebookRunner;
import com.facebook.android.DialogError;
import com.facebook.android.Facebook;
import com.facebook.android.FacebookError;
import com.facebook.android.Facebook.DialogListener;

public class Login extends Activity {
	
	private DatabaseAdapter databaseAdapter;
	private UserDAO userDAO;
	private static final int REQUEST_CODE = 10;
	
	// Your Facebook APP ID
	private static String APP_ID = "your app id";
	
	// Instance of Facebook Class
	private Facebook facebook = new Facebook(APP_ID);
	private AsyncFacebookRunner mAsyncRunner;
	String FILENAME = "AndroidSSO_data";
	private SharedPreferences mPrefs;

	// Buttons
	ImageButton btnFbLogin;
	Button btnFbGetProfile;
	ImageButton btnPostToWall;
	Button btnShowAccessTokens;
	
	View v;
	
	ImageView imageView;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		
//		intentContainer();
		
		// create an instance of SQLite Database
				databaseAdapter = new DatabaseAdapter(this);		
				userDAO = new SQLiteUserDAO(databaseAdapter.open().getDatabaseInstance());
				
				// get the references of views
				final EditText editTextUserName = (EditText) findViewById(R.id.editTextUserNameToLogin);
				final EditText editTextPassword = (EditText) findViewById(R.id.editTextPasswordToLogin);
				
				Button btnLogIn = (Button) findViewById(R.id.LoginDialog);
				Button btnRegister = (Button) findViewById(R.id.createAnAccount);
				
				// Set On ClickListener
				btnLogIn.setOnClickListener(new View.OnClickListener() {

					public void onClick(View v) {
						// get The User name and Password
						String username = editTextUserName.getText().toString();
						String password = editTextPassword.getText().toString();
						
						if (username.equals("") || password.equals("")) {
							Toast.makeText(getApplicationContext(), "Field Vacant", Toast.LENGTH_LONG).show();
							return;
						}

							try {
								User user = userDAO.findByUsername(username);	
								
								if (password.equals(user.getPassword())) {
									
//									TextView userText = (TextView) findViewById(R.id.textView4);
//									userText.setText(user.getEmail());
									
									Intent dashboard = new Intent(getApplicationContext(), Dashboard.class);
									dashboard.putExtra("value", user.getUsername());
									startActivityForResult(dashboard, REQUEST_CODE);
									finish();
									
//									startActivity(dashboard);									
			//						soundManager.playSound(SoundManager.SUCCESS_SOUND);
								} else {
									Toast.makeText(Login.this,
											"Invalid password",
											Toast.LENGTH_LONG).show();
			//						soundManager.playSound(SoundManager.ERROR_SOUND);
								}
			
							} catch(Exception e) {
								Toast.makeText(Login.this,
										"Invalid User",
										Toast.LENGTH_LONG).show();
			//					soundManager.playSound(SoundManager.ERROR_SOUND);
							}
						
					}
				});
				
				btnRegister.setOnClickListener(new OnClickListener() {
					public void onClick(View v) {
						
						// / Create Intent for SignUpActivity and Start The Activity
						Intent i = new Intent(getApplicationContext(),
								Register.class);
						startActivity(i);
					}
				});
				
				btnFbLogin = (ImageButton) findViewById(R.id.btn_fblogin);
				btnPostToWall = (ImageButton) findViewById(R.id.btn_fb_post_to_wall);
				mAsyncRunner = new AsyncFacebookRunner(facebook);
				
				btnFbLogin.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						Log.d("Image Button", "button Clicked");
						loginToFacebook();
					}
				});
				
				btnPostToWall.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						postToWall();
					}
				});
				
	}
	
//	protected void intentContainer() {
//        // get intent data
//        Intent i = getIntent();
//
//        // Selected image id
//        int position = i.getExtras().getInt("id");
//		
//	}

	public void loginToFacebook() {

		mPrefs = getPreferences(MODE_PRIVATE);
		String access_token = mPrefs.getString("access_token", null);
		long expires = mPrefs.getLong("access_expires", 0);

		if (access_token != null) {
			facebook.setAccessToken(access_token);
			
			btnFbLogin.setVisibility(View.INVISIBLE);
			
			// Making show access tokens button visible
			btnShowAccessTokens.setVisibility(View.VISIBLE);

			Log.d("FB Sessions", "" + facebook.isSessionValid());
		}

		if (expires != 0) {
			facebook.setAccessExpires(expires);
		}

		if (!facebook.isSessionValid()) {
			facebook.authorize(this,
					new String[] { "email", "publish_stream" },
					new DialogListener() {

						@Override
						public void onCancel() {
							// Function to handle cancel event
						}

						@Override
						public void onComplete(Bundle values) {
							// Function to handle complete event
							// Edit Preferences and update facebook acess_token
							SharedPreferences.Editor editor = mPrefs.edit();
							editor.putString("access_token",
									facebook.getAccessToken());
							editor.putLong("access_expires",
									facebook.getAccessExpires());
							editor.commit();
							
//							Intent dashboard = new Intent(getApplicationContext(), Dashboard.class);
//							dashboard.putExtra("value", user.getUsername());
//							startActivityForResult(dashboard, REQUEST_CODE);
//							finish();

//							// Making Login button invisible
//							btnFbLogin.setVisibility(View.INVISIBLE);
//
//							// Making logout Button visible
//							btnFbGetProfile.setVisibility(View.VISIBLE);

						}

						@Override
						public void onError(DialogError error) {
							// Function to handle error

						}

						@Override
						public void onFacebookError(FacebookError fberror) {
							// Function to handle Facebook errors

						}

					});
		}
	}
	
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		facebook.authorizeCallback(requestCode, resultCode, data);
	}
	
	public void postToWall() {
		// post on user's wall.
		facebook.dialog(this, "feed", new DialogListener() {

			@Override
			public void onFacebookError(FacebookError e) {
			}

			@Override
			public void onError(DialogError e) {
			}

			@Override
			public void onComplete(Bundle values) {
			}

			@Override
			public void onCancel() {
			}
		});

	}
	
	protected void onFinish() {
		super.finish();
		
		Intent i = new Intent(getApplicationContext(), Dashboard.class);
		startActivity(i);
		
	}
	
	protected void onDestroy() {
		super.onDestroy();
		databaseAdapter.close();
		}
	
	void dashB() {
        // get intent data
        Intent i = getIntent();


	}
}
