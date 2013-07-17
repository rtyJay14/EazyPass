package com.android.eazypass.other;

import java.util.Vector;

import com.android.eazypass.R;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapterA extends BaseAdapter{
    private Context mContext;
    public Vector<Integer> mThumbIds;

    public ImageAdapterA(Context a) {
        mContext = a;
        mThumbIds = new Vector<Integer>();
        mThumbIds.add(R.drawable.movie_list_a);
        mThumbIds.add(R.drawable.movie_list_b);
        mThumbIds.add(R.drawable.movie_list_c);
        mThumbIds.add(R.drawable.movie_list_d);
        mThumbIds.add(R.drawable.movie_list_e);
        mThumbIds.add(R.drawable.movie_list_f);
        mThumbIds.add(R.drawable.movie_list_g);
        mThumbIds.add(R.drawable.movie_list_h);

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
			imageView.setLayoutParams(new GridView.LayoutParams(231, 342));
			imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
			imageView.setPadding(10, 10, 10, 10);
        } else {
            imageView = (ImageView) convertView;
        }
		
        imageView.setImageResource(this.mThumbIds.get(position));
        return imageView;
    
    
//    // Video
//    new AsyncTask<ViewHolder, Void, Video>() {
//        private ViewHolder v;
//
//        @Override
//        protected Video doInBackground(ViewHolder... params) {
//            v = params[0];
//            return mFakeImageLoader.getImage();
//        }
//
//        @Override
//        protected void onPostExecute(Bitmap result) {
//            super.onPostExecute(result);
//            if (v.position == position) {
//                // If this item hasn't been recycled already, hide the
//                // progress and set and show the image
//                v.progress.setVisibility(View.GONE);
//                v.icon.setVisibility(View.VISIBLE);
//                v.icon.setImageBitmap(result);
//            }
//        }
//    }.execute(holder);
        
//      static class ViewHolder {
//        	TextView text;
//        	TextView timestamp;
//        	ImageView icon;
//        	ProgressBar progress;
//        	int position;
//        }
        
//      ViewHolder holder = new ViewHolder();
//      holder.icon = (ImageView) convertView.findViewById(R.id.listitem_image);
//      holder.text = (TextView) convertView.findViewById(R.id.listitem_text);
//      holder.timestamp = (TextView) convertView.findViewById(R.id.listitem_timestamp);
//      holder.progress = (ProgressBar) convertView.findViewById(R.id.progress_spinner);
//      convertView.setTag(holder);
    }
}