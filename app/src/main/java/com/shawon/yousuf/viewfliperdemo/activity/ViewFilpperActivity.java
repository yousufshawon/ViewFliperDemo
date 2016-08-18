package com.shawon.yousuf.viewfliperdemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.shawon.yousuf.viewfliperdemo.R;
import com.shawon.yousuf.viewfliperdemo.adapter.GalleryAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ViewFilpperActivity extends AppCompatActivity {

    @Bind(R.id.buttonPrevious)
    Button buttonPrevious;
    @Bind(R.id.buttonNext)
    Button buttonNext;
    @Bind(R.id.viewFlipper)
    ViewFlipper viewFlipper;


    private int[] imageResources = {R.drawable.dad, R.drawable.damp, R.drawable.dance, R.drawable.dancer, R.drawable.dark,
            R.drawable.dart, R.drawable.date};

    LayoutInflater inflater;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_filpper);
        ButterKnife.bind(this);
        inflater = LayoutInflater.from(this);
        ini();
    }



    private void ini(){

        viewFlipper.setInAnimation(this, R.anim.slide_in_right);
        viewFlipper.setOutAnimation(this, R.anim.slide_out_left);


        for(int i=0; i<imageResources.length; i++){
            View view = inflater.inflate(R.layout.item_card, null);
            ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
            imageView.setBackgroundResource(imageResources[i]);

            viewFlipper.addView(view);
        }

    }



    private void onPreviousClick(){
        int displayedChildIndex = viewFlipper.getDisplayedChild();

        if( displayedChildIndex > 0 ){
            viewFlipper.setInAnimation(this, R.anim.slide_in_left);
            viewFlipper.setOutAnimation(this, R.anim.slide_out_right);

            viewFlipper.showPrevious();
        }

    }


    private void onNextClick(){

        int displayedChildIndex = viewFlipper.getDisplayedChild();
        int totalChild = viewFlipper.getChildCount();


        if( displayedChildIndex < totalChild -1){
            viewFlipper.setInAnimation(this, R.anim.slide_in_right);
            viewFlipper.setOutAnimation(this, R.anim.slide_out_left);;
            viewFlipper.showNext();
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
