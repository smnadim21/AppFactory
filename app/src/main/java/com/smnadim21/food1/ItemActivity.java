package com.smnadim21.food1;

import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemActivity extends AppCompatActivity {

    TextView tv_item_desc,tv_item_loc;
    ImageView imageTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        tv_item_desc = findViewById(R.id.tv_item_desc);
        tv_item_loc = findViewById(R.id.tv_item_loc);
        imageTitle = findViewById(R.id.imageTitle);

        String title = getIntent().getStringExtra("title");
        String desc = getIntent().getStringExtra("desc");
        String loc = getIntent().getStringExtra("loc");
        String img = getIntent().getStringExtra("img");

        setTitle(title);
        tv_item_desc.setText(desc);
        tv_item_loc.setText(loc);

        Glide.with(ItemActivity.this)
                .load(img)
                .placeholder(R.drawable.image_8)
                .into(imageTitle);


    }
}
