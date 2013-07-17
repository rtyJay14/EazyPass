package com.android.eazypass.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.eazypass.R;
import com.android.eazypass.other.ImageAdapterB;

public class Seats extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.seats);
				
		Button b1 = (Button) this.findViewById(R.id.button1);
		b1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(getApplicationContext(), Payment.class);
				startActivity(i);
				finish();
			}
		});
		
		Button b2 = (Button) findViewById(R.id.button2);
		Button b3 = (Button) findViewById(R.id.button3);
		Button b4 = (Button) findViewById(R.id.button4);
		Button b5 = (Button) findViewById(R.id.button5);
		Button b6 = (Button) findViewById(R.id.button6);
		Button b7 = (Button) findViewById(R.id.button7);
		Button b8 = (Button) findViewById(R.id.button8);
		Button b9 = (Button) findViewById(R.id.button9);
		Button b10 = (Button) findViewById(R.id.button10);
		Button b11 = (Button) findViewById(R.id.button11);
		Button b12 = (Button) findViewById(R.id.button12);
		Button b13 = (Button) findViewById(R.id.button13);
		Button b14 = (Button) findViewById(R.id.button14);
		Button b15 = (Button) findViewById(R.id.button15);
		
//            switch (position) {
//            case 0:
//                return new DetailsFragment();
//            case 1:
//                return new ImageFragment(R.drawable.ic_launcher);
//            case 2:
//                return new ImageFragment(R.drawable.movie_list_a);
// 
//            default:
//                return null;
//            }
//		
	}
		
}
