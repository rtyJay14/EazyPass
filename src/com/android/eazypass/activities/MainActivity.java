package com.android.eazypass.activities;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

import com.android.eazypass.R;
import com.android.eazypass.other.ImageAdapterA;

@SuppressLint("NewApi")
public class MainActivity extends Activity {

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dashboard);

		// movie grid view
		GridView movieView = (GridView) findViewById(R.id.gridView3);
		movieView.setAdapter(new ImageAdapterA(this));

		movieView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {	
//				Toast.makeText(MainActivity.this, "" + position,
//						Toast.LENGTH_SHORT).show();
				
                Intent i = new Intent(getApplicationContext(), Login.class);
                i.putExtra("id", position);
                startActivity(i);
				
			}
		});
	}
	
	protected void onPause() {
		super.onPause();
	}
	
	protected void onStop() {
		super.onStop();
	}
	
	void kill_activity() {
		finish();
	}
	
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}