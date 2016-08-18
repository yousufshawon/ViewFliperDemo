package com.shawon.yousuf.viewfliperdemo.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.shawon.yousuf.viewfliperdemo.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.buttonViewFlipper)
    Button buttonViewFlipper;
    @Bind(R.id.buttonAdapterViewFilpper)
    Button buttonAdapterViewFilpper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }


    private void onViewFlipperClick(){
        startActivity(ViewFilpperActivity.class);
    }


    private void onAdapterViewFlipperClick(){
        startActivity(AdapterViewFilperActivity.class);
    }

    private void startActivity(Class<? extends Activity> mStartActivityClass){

        Intent intent = new Intent(this, mStartActivityClass);
        startActivity(intent);
    }


    @OnClick({R.id.buttonViewFlipper, R.id.buttonAdapterViewFilpper})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonViewFlipper:
                onViewFlipperClick();
                break;
            case R.id.buttonAdapterViewFilpper:
                onAdapterViewFlipperClick();
                break;
        }
    }
}
