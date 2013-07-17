package com.android.eazypass.other;

import java.util.Vector;

import com.android.eazypass.R;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapterB extends BaseAdapter{
    private Context mContext;
    public Vector<Integer> mThumbIds;

    public ImageAdapterB(Context a) {
        mContext = a;
        mThumbIds = new Vector<Integer>();
        mThumbIds.add(R.drawable.harbor_point);
        mThumbIds.add(R.drawable.sm);
        mThumbIds.add(R.drawable.town_center);
        mThumbIds.add(R.drawable.sm_north_edsa);
        mThumbIds.add(R.drawable.trinoma);
        mThumbIds.add(R.drawable.ayala_mall);
        mThumbIds.add(R.drawable.sm);
        mThumbIds.add(R.drawable.sm_megamall);
        mThumbIds.add(R.drawable.harbor_point);
        mThumbIds.add(R.drawable.trinoma);
        mThumbIds.add(R.drawable.town_center);
        mThumbIds.add(R.drawable.sm_north_edsa);
        mThumbIds.add(R.drawable.sm);
        mThumbIds.add(R.drawable.ayala_mall);
        mThumbIds.add(R.drawable.sm);
        mThumbIds.add(R.drawable.sm_megamall);
        mThumbIds.add(R.drawable.harbor_point);
        mThumbIds.add(R.drawable.trinoma);
        mThumbIds.add(R.drawable.town_center);
        mThumbIds.add(R.drawable.sm_north_edsa);
        mThumbIds.add(R.drawable.sm);
        mThumbIds.add(R.drawable.ayala_mall);
        mThumbIds.add(R.drawable.sm);
        mThumbIds.add(R.drawable.sm_megamall);
        
    }

    public boolean add(){
        return mThumbIds.addAll(mThumbIds);
    }

    public int getCount() {
        return mThumbIds.size();
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    public int remove(int position){
        return this.mThumbIds.remove(position);
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
		if (convertView == null) {
			imageView = new ImageView(mContext);
			imageView.setLayoutParams(new GridView.LayoutParams(120, 150));
			imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
			imageView.setPadding(5, 10, 5, 10);
        } else {
            imageView = (ImageView) convertView;
        }
		
        imageView.setImageResource(this.mThumbIds.get(position));
        return imageView;
    }

}