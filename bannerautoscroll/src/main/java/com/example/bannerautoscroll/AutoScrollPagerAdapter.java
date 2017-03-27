package com.example.bannerautoscroll;


import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import org.xmlpull.v1.XmlPullParser;

import java.util.ArrayList;


public class AutoScrollPagerAdapter extends PagerAdapter {

    private ArrayList<String> picList;
    private Context context;
    private LayoutInflater inflater;

    public AutoScrollPagerAdapter(Context context, ArrayList<String> picList) {

        this.picList = picList;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public AutoScrollPagerAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LinearLayout linearLayout=new LinearLayout(context);
        LinearLayout.LayoutParams layoutParams=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        linearLayout.setLayoutParams(layoutParams);
        ImageView imageView=new ImageView(context);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.images));
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        linearLayout.addView(imageView);

        container.addView(linearLayout);

        return linearLayout;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}
