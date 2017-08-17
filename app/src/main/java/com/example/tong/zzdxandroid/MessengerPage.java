package com.example.tong.zzdxandroid;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import com.example.tong.zzdxandroid.bean.Messenger;

/**
 * Created by tong on 17-3-30.
 */

public class MessengerPage extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.messenger_page);
        TextView title = (TextView) findViewById(R.id.friend_title);
        TextView name = (TextView) findViewById(R.id.friend_name);
        TextView page = (TextView) findViewById(R.id.friend_page);

        Messenger messenger = (Messenger) getIntent().getSerializableExtra("messenger");

        title.setText(messenger.getMessengerTitle());
        name.setText(messenger.getUserName());
        page.setText(messenger.getMessengerPage());


    }
}
