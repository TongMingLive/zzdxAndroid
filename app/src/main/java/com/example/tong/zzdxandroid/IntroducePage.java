package com.example.tong.zzdxandroid;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.tong.zzdxandroid.bean.Introduce;

/**
 * Created by tong- on 2017/5/4.
 */

public class IntroducePage extends AppCompatActivity {
    private android.widget.TextView type;
    private android.widget.TextView name;
    private android.widget.TextView address;
    private android.widget.TextView page;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.introduce_page);
        this.page = (TextView) findViewById(R.id.page);
        this.address = (TextView) findViewById(R.id.address);
        this.name = (TextView) findViewById(R.id.name);
        this.type = (TextView) findViewById(R.id.type);

        Introduce introduce = (Introduce) getIntent().getSerializableExtra("introduce");

        name.setText(introduce.getIntroduceName());
        type.setBackgroundColor(Color.parseColor(introduce.getTypeColor()));
        type.setText(introduce.getTypeName());

        address.setText(introduce.getIntroduceAddress());
        page.setText(introduce.getIntroducePage());
    }
}
