package com.example.abid.autoscrollbanner.customViewpager;


import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.squareup.picasso.Picasso;

import java.util.List;


public class AutoScrollPagerAdapter extends PagerAdapter {

    private List<String> picList;
    private Context context;
    private LayoutInflater inflater;

    public AutoScrollPagerAdapter(Context context, List<String> picList) {

        this.picList = picList;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }




    @Override
    public int getCount() {
        return picList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view ==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LinearLayout linearLayout=new LinearLayout(context);
        LinearLayout.LayoutParams layoutParams=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        linearLayout.setLayoutParams(layoutParams);
        ImageView imageView=new ImageView(context);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        Picasso.get()
                .load(picList.get(position))
                .placeholder(com.example.bannerautoscroll.R.drawable.images)
                .into(imageView);
       // imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.images));
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
