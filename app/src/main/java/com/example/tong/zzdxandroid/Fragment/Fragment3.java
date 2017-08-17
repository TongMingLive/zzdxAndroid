package com.example.tong.zzdxandroid.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tong.zzdxandroid.Jisuanqi;
import com.example.tong.zzdxandroid.Login;
import com.example.tong.zzdxandroid.MessengerAll;
import com.example.tong.zzdxandroid.R;
import com.example.tong.zzdxandroid.UpdatePassword;
import com.example.tong.zzdxandroid.Util.App;

/**
 * Created by tong- on 2017/5/1.
 */

public class Fragment3 extends Fragment implements View.OnClickListener {
    private android.widget.TextView useruserName;
    private android.widget.TextView useruserId;
    private android.widget.TextView userliuyan;
    private android.widget.TextView userjisuanqi;
    private android.widget.TextView userupdatePassword;
    private android.widget.TextView userout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.more,null);
        this.userout = (TextView) view.findViewById(R.id.user_out);
        this.userupdatePassword = (TextView) view.findViewById(R.id.user_updatePassword);
        this.userjisuanqi = (TextView) view.findViewById(R.id.user_jisuanqi);
        this.userliuyan = (TextView) view.findViewById(R.id.user_liuyan);
        this.useruserId = (TextView) view.findViewById(R.id.user_userId);
        this.useruserName = (TextView) view.findViewById(R.id.user_userName);

        useruserName.setText("帐号："+ App.user.getUserName());
        useruserId.setText("UID："+App.user.getUserId());

        userliuyan.setOnClickListener(this);
        userjisuanqi.setOnClickListener(this);
        userupdatePassword.setOnClickListener(this);
        userout.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.user_updatePassword:
                startActivity(new Intent(getActivity(), UpdatePassword.class));
                break;
            case R.id.user_out:
                startActivity(new Intent(getActivity(), Login.class));
                App.user = null;
                getActivity().finish();
                break;
            case R.id.user_liuyan:
                startActivity(new Intent(getActivity(), MessengerAll.class));
                break;
            case R.id.user_jisuanqi:
                startActivity(new Intent(getActivity(), Jisuanqi.class));
                break;
        }
    }
}
