package com.shawon.yousuf.viewfliperdemo.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.shawon.yousuf.viewfliperdemo.R;

/**
 * Created by Yousuf on 8/17/2016.
 */
public class GalleryAdapter extends BaseAdapter {

    private Context context;
    private int imageResources[];
    LayoutInflater inflater;

    private String TAG = getClass().getSimpleName();

    public GalleryAdapter(Context context, int[] imageResources) {
        this.context = context;
        this.imageResources = imageResources;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return imageResources.length;
    }

    @Override
    public Object getItem(int position) {
        return imageResources[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        Log.d(TAG, "getView " + position);
        View rootView = inflater.inflate(R.layout.item_card, null);
        ImageView imageView = (ImageView) rootView.findViewById(R.id.imageView);
        imageView.setBackgroundResource(imageResources[position]);

        return rootView;
    }
}
