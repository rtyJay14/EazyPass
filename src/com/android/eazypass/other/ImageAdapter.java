package com.android.eazypass.other;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.android.eazypass.R;

public class ImageAdapter extends BaseAdapter{
    private Context mContext;
//    private Vector<Integer> mThumbIds;

    // Keep all Images in array
    public Integer[] ListOfMovies = {
            R.drawable.ticket1,
            R.drawable.ticket2,
            R.drawable.ticket3,
            R.drawable.ticket4,
            R.drawable.ticket5,
            R.drawable.ticket6,
            R.drawable.ticket2,
            R.drawable.ticket5,
            R.drawable.ticket4
    };
    
    // Constructor
    public ImageAdapter(Context c){
        mContext = c;
    }
    
    public ImageAdapter(OnItemClickListener onItemClickListener) {
		// TODO Auto-generated constructor stub
	}

	@Override
    public int getCount() {
        return ListOfMovies.length;
    }

    @Override
    public Object getItem(int position) {
        return ListOfMovies[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {         
        ImageView imageView = new ImageView(mContext);
        imageView.setImageResource(ListOfMovies[position]);
//        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
//        imageView.setLayoutParams(new GridView.LayoutParams(265, 265));
        return imageView;
    }
}