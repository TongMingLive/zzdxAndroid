package com.example.tong.zzdxandroid.Fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.example.tong.zzdxandroid.IndexActivity;
import com.example.tong.zzdxandroid.IntroducePage;
import com.example.tong.zzdxandroid.R;
import com.example.tong.zzdxandroid.Util.HttpUtil;
import com.example.tong.zzdxandroid.bean.Introduce;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tong- on 2017/5/1.
 */

public class Fragment1 extends Fragment implements OnItemClickListener {
    private com.bigkoo.convenientbanner.ConvenientBanner convenientBanner;
    private android.widget.ListView homelv;
    private List<Integer> localImages = new ArrayList<>();
    private android.support.design.widget.FloatingActionButton fab;
    private List<Introduce> list = new ArrayList<>();
    private ListAdapter adapter = new myAdapte();
    private String str;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home,null);
        this.fab = (FloatingActionButton) view.findViewById(R.id.fab);
        this.homelv = (ListView) view.findViewById(R.id.home_lv);
        this.convenientBanner = (ConvenientBanner) view.findViewById(R.id.convenientBanner);

        localImages.add(R.mipmap.meihu);
        localImages.add(R.mipmap.tushuguan);
        localImages.add(R.mipmap.zhonglouguangchang);
        localImages.add(R.mipmap.boyuechanglang);

        convenientBanner.setPages(
                new CBViewHolderCreator<LocalImageHolderView>() {
                    @Override
                    public LocalImageHolderView createHolder() {
                        return new LocalImageHolderView();
                    }
                }, localImages);
        //设置两个点图片作为翻页指示器，不设置则没有指示器，可以根据自己需求自行配合自己的指示器,不需要圆点指示器可用不设
        convenientBanner.setPageIndicator(new int[]{R.mipmap.ic_page_indicator_focused,R.mipmap.ic_page_indicator});
        //设置指示器的方向
        convenientBanner.setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.ALIGN_PARENT_RIGHT);
        convenientBanner.startTurning(2000);
        //设置翻页的效果，不需要翻页效果可用不设
        //convenientBanner.setPageTransformer(Transformer.DefaultTransformer);//集成特效之后会有白屏现象，新版已经分离，如果要集成特效的例子可以看Demo的点击响应。
        //convenientBanner.setManualPageable(false);//设置不能手动影响

        convenientBanner.setOnItemClickListener(this);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(getContext(), IndexActivity.class),0);
            }
        });

        homelv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), IntroducePage.class);
                intent.putExtra("introduce",list.get(position));
                startActivity(intent);
            }
        });

        return view;
    }

    public void setListViewHeightBasedOnChildren(ListView listView) {
        // 获取ListView对应的Adapter
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            return;
        }

        int totalHeight = 0;
        for (int i = 0, len = listAdapter.getCount(); i < len; i++) {
            // listAdapter.getCount()返回数据项的数目
            View listItem = listAdapter.getView(i, null, listView);
            // 计算子项View 的宽高
            listItem.measure(0, 0);
            // 统计所有子项的总高度
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight+ (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        // listView.getDividerHeight()获取子项间分隔符占用的高度
        // params.height最后得到整个ListView完整显示需要的高度
        listView.setLayoutParams(params);
    }

    @Override
    public void onItemClick(int position) {
        //Toast.makeText(getContext(), position+"个", Toast.LENGTH_SHORT).show();
    }

    public class LocalImageHolderView implements Holder<Integer> {
        private ImageView imageView;
        @Override
        public View createView(Context context) {
            imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            return imageView;
        }

        @Override
        public void UpdateUI(Context context, final int position, Integer data) {
            imageView.setImageResource(data);
        }
    }

    private class myAdapte extends BaseAdapter {

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View v = layoutInflater.inflate(R.layout.introduce_item, null);
            TextView name = (TextView) v.findViewById(R.id.name);
            TextView type = (TextView) v.findViewById(R.id.type);

            name.setText(list.get(position).getIntroduceName());
            type.setBackgroundColor(Color.parseColor(list.get(position).getTypeColor()));
            type.setText(list.get(position).getTypeName());

            return v;
        }
    }

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0x123){
                Gson gson = new Gson();
                JsonParser parser = new JsonParser();
                JsonArray jsonArray = parser.parse(str).getAsJsonArray();
                for (JsonElement json : jsonArray) {
                    list.add(gson.fromJson(json , Introduce.class));
                }
                homelv.setAdapter(adapter);
                setListViewHeightBasedOnChildren(homelv);
            }else if (msg.what == 0x000){
                Snackbar.make(homelv, "网络连接失败，请检查您的网络", Snackbar.LENGTH_LONG).show();
            }
        }
    };

    @Override
    public void onResume() {
        super.onResume();
        list.clear();
        new Thread(){
            @Override
            public void run() {
                super.run();
                Map<String,Object> map =new HashMap<>();
                str = HttpUtil.doPost(HttpUtil.path+"SelectAllIntroduceServlet",map);
                Log.d("Fragment1", str);
                if (str.equals("error")) {
                    handler.sendEmptyMessage(0x000);
                }else {
                    handler.sendEmptyMessage(0x123);
                }
            }
        }.start();
    }
}
