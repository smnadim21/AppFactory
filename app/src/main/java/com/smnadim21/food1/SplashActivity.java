package com.smnadim21.food1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import com.smnadim21.food1.advert.SP;

import static com.smnadim21.food1.advert.AdsLib.checkSubStatus;

public class SplashActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView spalashText =  findViewById(R.id.spalashText);
        TextView spalashText2 =  findViewById(R.id.textView2);
        spalashText.setText(getResources().getString(R.string.app_name));
        spalashText2.setText("সুস্বাদু দেশী খাবার");

        checkSubStatus(SP.getSubCode());

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this,ItemListActivity.class));
                finish();
            }
        },2000);


    }
}
