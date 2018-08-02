package com.example.abid.autoscrollbanner;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.bannerautoscroll.AutoScrollPagerAdapter;
import com.example.bannerautoscroll.AutoScrollViewPager;

import java.util.ArrayList;
import java.util.List;

public class CompositeViewMy extends RelativeLayout {
    private AutoScrollViewPager autoScrollViewPager;
    private LinearLayout layout;
    private Context mContext;
    private AutoScrollPagerAdapter adapter;
    private List<String> list=new ArrayList<>();

    public CompositeViewMy(Context context) {
        super(context);
        init(context);
    }

    public CompositeViewMy(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CompositeViewMy(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        list.add("kds");
        list.add("kds");
        list.add("kds");
        list.add("kds");
        adapter=new AutoScrollPagerAdapter(context,list);
        mContext=context;
        layout=new LinearLayout(context);
        autoScrollViewPager = new AutoScrollViewPager(context);
        LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
         params2.gravity = Gravity.CENTER_HORIZONTAL;
       // autoScrollViewPager.setLayoutParams(params2);
        LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.addRule(ALIGN_PARENT_BOTTOM);
        params.addRule(CENTER_HORIZONTAL);

        layout.setLayoutParams(params);
        autoScrollViewPager.setAdapter(adapter);
        autoScrollViewPager.startAutoScroll();
        autoScrollViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                updatePointView(position);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        addView(autoScrollViewPager);
        addView(layout);
        initpoints(4,0);
    }

    private void initpoints(int size,int currentPoint){
        layout.removeAllViews();
        for (int i = 0; i < size; i++) {
            ImageView imageView = new ImageView(mContext);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.leftMargin = 8;
            params.gravity=Gravity.CENTER_VERTICAL;

            imageView.setLayoutParams(params);
            if (i == currentPoint) {
                imageView.setBackgroundResource(R.drawable.point_checked);
            } else {
                imageView.setBackgroundResource(R.drawable.point_normal);
            }

            layout.addView(imageView);
        }
    }

    public void updatePointView(int position) {
        int size = layout.getChildCount();
        for (int i = 0; i < size; i++) {
            ImageView imageView = (ImageView) layout.getChildAt(i);
            if (i == position) {
                imageView.setBackgroundResource(R.drawable.point_checked);
            } else {
                imageView.setBackgroundResource(R.drawable.point_normal);
            }

        }
    }


}
