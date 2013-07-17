package com.android.eazypass.activities;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.eazypass.R;
import com.android.eazypass.other.ImageAdapter;
import com.android.eazypass.other.ImageAdapterA;
import com.android.eazypass.other.ImageAdapterB;
import com.android.eazypass.sqlite.DatabaseAdapter;
import com.android.eazypass.sqlite.dao.SQLiteUserDAO;
import com.android.eazypass.sqlite.dao.interfaces.UserDAO;

public class Dashboard extends Activity {

//	private SoundManager soundManager;
	private DatabaseAdapter databaseAdapter;
	private UserDAO userDAO;
    ImageView group_icon;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.buy_tickets);
		
		databaseAdapter = new DatabaseAdapter(this);		
		userDAO = new SQLiteUserDAO(databaseAdapter.open().getDatabaseInstance());
		
		Login test = new Login();
		test.dashB();
		Intent i = getIntent();
        // Selected image id
/*        int position = i.getExtras().getInt("id");
        ImageAdapter imageAdapter1 = new ImageAdapter(this);

        ImageView imageView = (ImageView) findViewById(R.id.imageView1);
        imageView.setImageResource(imageAdapter1.ListOfMovies[position]);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);*/
		
//		User user = userDAO.findByUsername(username);
//		user.getUsername();

//		User text = new User();
//		
//		TextView userText = (TextView) findViewById(R.id.user);
//		userText.setText(text.getUsername());
		
		LinearLayout left = (LinearLayout) findViewById(R.id.left);
		left.setVisibility(0);
		
		LinearLayout right = (LinearLayout) findViewById(R.id.right);
		right.setVisibility(8);
		
//		Login getter = new Login();
//		getter.intentContainer();
		
/*      // get intent data
        Intent i = getIntent();

        // Selected image id
        int position = i.getExtras().getInt("id");
        ImageAdapterB imageAdapter1 = new ImageAdapterB(this);

        ImageView imageView = (ImageView) findViewById(R.id.imageView1);
        imageView.setImageResource(imageAdapter1.ListOfMovies[position]);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);*/
		
	    Bundle extras = getIntent().getExtras();
	    if (extras == null) {
	      return;
	    }
	    
		String value = extras.getString("value");
		
		 if (value != null) {
			 TextView userText = (TextView) findViewById(R.id.user);
			 userText.setText(value);
		 }
		        
//        //Back
//		Button back = (Button) findViewById(R.id.Back);
//		back.setOnClickListener(new View.OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				finish();
//			}
//		});
		
		TextView back = (TextView) findViewById(R.id.back);
		back.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				LinearLayout left = (LinearLayout) findViewById(R.id.left);
				left.setVisibility(0);
				
				LinearLayout right = (LinearLayout) findViewById(R.id.right);
				right.setVisibility(8);
			}
		});

		
        //Trailer
		Button trailer = (Button) findViewById(R.id.Trailer);
		trailer.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				LinearLayout left = (LinearLayout) findViewById(R.id.left);
				left.setVisibility(8);
				
				LinearLayout right = (LinearLayout) findViewById(R.id.right);
				right.setVisibility(0);
				
				GridView grid = (GridView) findViewById(R.id.gridView);
				grid.setVisibility(8);
				
				LinearLayout l1 = (LinearLayout) findViewById(R.id.linearlayout);
				l1.setVisibility(8);
				
				TextView text = (TextView) findViewById(R.id.textView1);
				text.setVisibility(0);
				text.setText("Hello Trailer!");
			}
		});
		
        //Details
		Button details = (Button) findViewById(R.id.Details);
		details.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				LinearLayout left = (LinearLayout) findViewById(R.id.left);
				left.setVisibility(8);
				
				LinearLayout right = (LinearLayout) findViewById(R.id.right);
				right.setVisibility(0);
				
				GridView grid = (GridView) findViewById(R.id.gridView);
				grid.setVisibility(8);
				
				LinearLayout l1 = (LinearLayout) findViewById(R.id.linearlayout);
				l1.setVisibility(0);
				
				TextView text = (TextView) findViewById(R.id.textView1);
				text.setVisibility(8);
				text.setText("Hello Details!");
			}
		});
		
        //Gallery
		Button gallery = (Button) findViewById(R.id.Gallery);
		gallery.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				LinearLayout left = (LinearLayout) findViewById(R.id.left);
				left.setVisibility(8);
				
				LinearLayout right = (LinearLayout) findViewById(R.id.right);
				right.setVisibility(0);
				
				GridView grid = (GridView) findViewById(R.id.gridView);
				grid.setVisibility(8);
				
				LinearLayout l1 = (LinearLayout) findViewById(R.id.linearlayout);
				l1.setVisibility(8);
				
				TextView text = (TextView) findViewById(R.id.textView1);
				text.setVisibility(0);
				text.setText("Hello Gallery!");
			}
		});
		
	    //Buy Tickets
		Button buyTicket = (Button) findViewById(R.id.BuyTicket);
		buyTicket.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				image();
			}
		});
	}
	

	private void image() {
		
		LinearLayout left = (LinearLayout) findViewById(R.id.left);
		left.setVisibility(8);
		
		LinearLayout right = (LinearLayout) findViewById(R.id.right);
		right.setVisibility(0);
		
		GridView grid = (GridView) findViewById(R.id.gridView);
		grid.setVisibility(2);
				
		LinearLayout l1 = (LinearLayout) findViewById(R.id.linearlayout);
		l1.setVisibility(8);
		
		TextView text = (TextView) findViewById(R.id.textView1);
		text.setVisibility(8);
		
		final GridView gridview = (GridView) findViewById(R.id.gridView);
        final ImageAdapterB imageAdapter = new ImageAdapterB(this);
        gridview.setAdapter(imageAdapter);

        //remove
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parentView, View v, final int position,
                    final long id) {
            	
            			    final Dialog groupIconsDialog = new Dialog(Dashboard.this);
						    groupIconsDialog.setTitle("Choose Your Preferred Schedule");
						    groupIconsDialog.setContentView(R.layout.seats_dialog);
						    
						    //calling and setting the image icons to the grid view adapter
//						    GridView groupIconsGrid = (GridView) groupIconsDialog.findViewById(R.id.gridView1);
//						    groupIconsGrid.setAdapter(new ImageAdapter(Dashboard.this));
						    
							GridView groupIconsGrid = (GridView) groupIconsDialog.findViewById(R.id.gridView1);
					        ImageAdapter imageAdapter = new ImageAdapter(Dashboard.this);
					        groupIconsGrid.setAdapter(imageAdapter);

						    groupIconsGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

						        @Override
						        public void onItemClick(AdapterView<?> arg0, View arg1, int position2, 
						        		final long arg3) {
						        	
						        	groupIconsDialog.dismiss();
//		            			    seats();
						        	
									   Intent i = new Intent(getApplicationContext(), Seats.class);
									   i.putExtra("id", position2);
									   startActivity(i);
									   
//											group_icon.setImageResource(new ImageAdapter(Dashboard.this).ListOfMovies[position]);
											
//											group_icon.setOnClickListener(new View.OnClickListener() {
//												
//												@Override
//												public void onClick(View v) {
//													// TODO Auto-generated method stub

//												}
//											});
											
											
//						                    groupIconsDialog.cancel();

						                }

						            });

						            groupIconsDialog.show();			
            	
					}
				});
        
//    	final Dialog dialog = new Dialog(Dashboard.this);
//		
//		dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//		dialog.setContentView(R.layout.seats_dialog);
//	    	     
//        ImageAdapter imageAdapter1 = new ImageAdapter(this);
//		        	        
//		ImageView iv = (ImageView) findViewById(R.id.imageView1);
//		iv.setImageResource(imageAdapter1.ListOfMovies[position]);
//		iv.setScaleType(ImageView.ScaleType.FIT_XY);
//		
//		dialog.setContentView(position); 
//		      		
//		Button ok = (Button) dialog.findViewById(R.id.button1);
//		ok.setOnClickListener(new OnClickListener() {
//
//				@Override
//				public void onClick(View view) {
//				    // TODO Auto-generated method stub
				
/*        //add
        Button addButton = (Button) findViewById(R.id.BuyTicket);
        addButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                imageAdapter.add();
                gridview.setAdapter(imageAdapter);
            }
        });*/
    }
				/*Button cancel = (Button) dialog.findViewById(R.id.button2);
				cancel.setOnClickListener(new OnClickListener() {
					
					public void onClick(View v) {
//			            ImageView iv = new ImageView(Dashboard.this);
//			            iv.setImageDrawable(getResources().getDrawable((int) id));
						
					}
					
				});
				
				dialog.show();*/
            	
            	
            	
//            	final AlertDialog alertDialog = new AlertDialog.Builder(Dashboard.this).create();
//                alertDialog.setTitle("Approve...");
//                alertDialog.setMessage("Are you sure?");
//                alertDialog.setContentView(position);
//                alertDialog.setButton("ok", new DialogInterface.OnClickListener() {
//                   public void onClick(DialogInterface dialog, int which) {
//                     alertDialog.dismiss();
//                   }
//                });
//                alertDialog.setButton2("Cancel", new DialogInterface.OnClickListener() {
//                       public void onClick(DialogInterface dialog, int which) {
//                         alertDialog.dismiss();
//                       }
//                    });
//
//                alertDialog.setIcon(android.R.drawable.alert_dark_frame);
//                alertDialog.show();
            	
            	
            	
            	
            	
/*            	ImageView iv = (ImageView) v.findViewById(R.id.imageView1);
            	Drawable image = iv.getDrawable();
            	CreateYourDialog(image);*/
            	
            	
            	
            	
            	
            	
				        
//				dialog.setImageResource(imageAdapterB.ListOfMovies[position]);
//		        dialog.setScaleType(ImageView.ScaleType.FIT_XY);
//				dialog.findViewById(R.id.imageView1).setBackgroundResource(position);

            	
            	
            	
            	
				
//				new AlertDialog.Builder(Dashboard.this)
//				
//                .setPositiveButton(R.string.alert_dialog_ok, new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int whichButton) {
//
//                         //User clicked OK so do some stuff 
//                    }
//                })
//                .setNegativeButton(R.string.alert_dialog_cancel, new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int whichButton) {
//
//                         //User clicked Cancel so do some stuff 
//                    }
//                })
//                .show();
				
            	
            	
            	
            	
//				ImageView imageView = (ImageView) findViewById(R.id.imageView1);
//				Drawable image = imageView.getDrawable();
				
//                gridview.setAdapter(imageAdapter);
             
            	
            	
//                Intent i = new Intent(getApplicationContext(), Seats.class);
//                i.putExtra("id", position);
//                startActivity(i);
            	


/*			private void CreateYourDialog(Drawable image) {
            	final Dialog dialog = new Dialog(Dashboard.this);
        		
        		dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        		dialog.setContentView(R.layout.seats_dialog);
        		
        		ImageView iv = (ImageView) findViewById(R.id.imageView1);
        		iv.setBackgroundDrawable(image);
        		
				Button ok = (Button) dialog.findViewById(R.id.button1);
				ok.setOnClickListener(new OnClickListener() {
					public void onClick(View v) {
						dialog.cancel();
						Intent i = new Intent(getApplicationContext(), Buy_Ticket.class);
						startActivity(i);
					}
				});
				
				Button cancel = (Button) dialog.findViewById(R.id.button2);
				cancel.setOnClickListener(new OnClickListener() {
					
					public void onClick(View v) {
			            ImageView iv = new ImageView(Dashboard.this);
//			            iv.setImageDrawable(getResources().getDrawable((int) id));
						
					}
					
				});
				
				dialog.show();		
				
//			}
//        });       		
	}*/
	
	public void onActivityResult() {
		
	}
	
	public void seats() {
		final Dialog groupIconsDialog2 = new Dialog(Dashboard.this);
	    groupIconsDialog2.setTitle("Choose Your Preferred Seats");
	    groupIconsDialog2.setContentView(R.layout.seats);
  					    		
		Button b1 = (Button) findViewById(R.id.button1);
		b1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				groupIconsDialog2.dismiss();
				Intent i = new Intent(getApplicationContext(), Payment.class);
				i.putExtra("b1", 1);
				startActivity(i);											
			}
		});
		Button b2 = (Button) findViewById(R.id.button2);
//		b2.setOnClickListener(new View.OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				Intent i = new Intent(getApplicationContext(), Payment.class);
//				i.putExtra("b2", 2);
//				startActivity(i);											
//			}
//		});
		Button b3 = (Button) findViewById(R.id.button3);
//		b3.setOnClickListener(new View.OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				Intent i = new Intent(getApplicationContext(), Payment.class);
//				i.putExtra("b3", 3);
//				startActivity(i);											
//			}
//		});
		Button b4 = (Button) findViewById(R.id.button4);
//		b4.setOnClickListener(new View.OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				Intent i = new Intent(getApplicationContext(), Payment.class);
//				i.putExtra("b4", 4);
//				startActivity(i);											
//			}
//		});
		Button b5 = (Button) findViewById(R.id.button5);
//		b5.setOnClickListener(new View.OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				Intent i = new Intent(getApplicationContext(), Payment.class);
//				i.putExtra("b5", 5);
//				startActivity(i);											
//			}
//		});
		Button b6 = (Button) findViewById(R.id.button6);
//		b6.setOnClickListener(new View.OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				Intent i = new Intent(getApplicationContext(), Payment.class);
//				i.putExtra("b6", 6);
//				startActivity(i);											
//			}
//		});
		Button b7 = (Button) findViewById(R.id.button7);
//		b7.setOnClickListener(new View.OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				Intent i = new Intent(getApplicationContext(), Payment.class);
//				i.putExtra("b7", 7);
//				startActivity(i);											
//			}
//		});
		Button b8 = (Button) findViewById(R.id.button8);
//		b8.setOnClickListener(new View.OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				Intent i = new Intent(getApplicationContext(), Payment.class);
//				i.putExtra("a8", 8);
//				startActivity(i);											
//			}
//		});
		Button b9 = (Button) findViewById(R.id.button9);
//		b9.setOnClickListener(new View.OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				Intent i = new Intent(getApplicationContext(), Payment.class);
//				i.putExtra("a9", 9);
//				startActivity(i);											
//			}
//		});
		Button b10 = (Button) findViewById(R.id.button10);
//		b10.setOnClickListener(new View.OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				Intent i = new Intent(getApplicationContext(), Payment.class);
//				i.putExtra("a10", 10);
//				startActivity(i);											
//			}
//		});
		Button b11 = (Button) findViewById(R.id.button11);
//		b11.setOnClickListener(new View.OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				Intent i = new Intent(getApplicationContext(), Payment.class);
//				i.putExtra("a11", 11);
//				startActivity(i);											
//			}
//		});
		Button b12 = (Button) findViewById(R.id.button12);
//		b12.setOnClickListener(new View.OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				Intent i = new Intent(getApplicationContext(), Payment.class);
//				i.putExtra("a12", 12);
//				startActivity(i);											
//			}
//		});
		Button b13 = (Button) findViewById(R.id.button13);
//		b13.setOnClickListener(new View.OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				Intent i = new Intent(getApplicationContext(), Payment.class);
//				i.putExtra("a13", 13);
//				startActivity(i);											
//			}
//		});
		Button b14 = (Button) findViewById(R.id.button14);
//		b14.setOnClickListener(new View.OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				Intent i = new Intent(getApplicationContext(), Payment.class);
//				i.putExtra("a14", 14);
//				startActivity(i);											
//			}
//		});
		Button b15 = (Button) findViewById(R.id.button15);
//		b15.setOnClickListener(new View.OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				Intent i = new Intent(getApplicationContext(), Payment.class);
//				i.putExtra("a15", 15);
//				startActivity(i);											
//			}
//		});
		groupIconsDialog2.show();
	}

}
