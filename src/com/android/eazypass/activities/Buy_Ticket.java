package com.android.eazypass.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.android.eazypass.R;


public class Buy_Ticket extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.payment);

		Button b1 = (Button) findViewById(R.id.CreateAnAccountDialog2);
		b1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(), Seats.class);
				startActivity(i);
			}
			
		});
		
		Button b2 = (Button) findViewById(R.id.Cancel);
		b2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
			
		});
		
//		 // get intent data
//        Intent i = getIntent();
//
//        // Selected image id
//        int position = i.getExtras().getInt("id");
//        
//        ImageAdapterB imageAdapter1 = new ImageAdapterB(this);
//
//        ImageView imageView = (ImageView) findViewById(R.id.imageView1);
//        
//        imageView.setImageResource(imageAdapter1.ListOfMovies[position]);
//        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
	}
}
