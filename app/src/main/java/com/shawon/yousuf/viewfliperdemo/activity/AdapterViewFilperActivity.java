package com.shawon.yousuf.viewfliperdemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.animation.*;
import android.widget.AdapterViewFlipper;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.shawon.yousuf.viewfliperdemo.R;
import com.shawon.yousuf.viewfliperdemo.adapter.GalleryAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AdapterViewFilperActivity extends AppCompatActivity {


    @Bind(R.id.buttonPrevious)
    Button buttonPrevious;
    @Bind(R.id.buttonNext)
    Button buttonNext;
    @Bind(R.id.adapterViewFlipper)
    AdapterViewFlipper adapterViewFlipper;


    private int[] imageResources = {R.drawable.dad, R.drawable.damp, R.drawable.dance, R.drawable.dancer, R.drawable.dark,
            R.drawable.dart, R.drawable.date};

    GalleryAdapter mAdapter ;

    private String TAG = getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter_view_filper);
        ButterKnife.bind(this);

        ini();

    }


    private void ini(){

        adapterViewFlipper.setInAnimation(this, R.animator.right_in);
        adapterViewFlipper.setOutAnimation(this, R.animator.left_out);

        mAdapter = new GalleryAdapter(this, imageResources);
        adapterViewFlipper.setAdapter(mAdapter);

    }



    private void onPreviousClick(){
        int displayedChildIndex = adapterViewFlipper.getDisplayedChild();

        if( displayedChildIndex > 0 ){
            adapterViewFlipper.setInAnimation(this, R.animator.left_in);
            adapterViewFlipper.setOutAnimation(this, R.animator.right_out);

            adapterViewFlipper.showPrevious();
        }

    }


    private void onNextClick(){

        int displayedChildIndex = adapterViewFlipper.getDisplayedChild();
        int totalChild = mAdapter.getCount();


        if( displayedChildIndex < totalChild -1){
            adapterViewFlipper.setInAnimation(this, R.animator.right_in);
            adapterViewFlipper.setOutAnimation(this, R.animator.left_out);
            adapterViewFlipper.showNext();
        }

    }


    @OnClick({R.id.buttonPrevious, R.id.buttonNext})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonPrevious:
                onPreviousClick();
                break;
            case R.id.buttonNext:
                onNextClick();
                break;
        }
    }
}
