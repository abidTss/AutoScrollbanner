package com.example.bannerautoscroll;

import android.content.Context;
import android.os.Build;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by android-1 on 24/3/17.
 */

public class HealperC {
    Context context;
    int dotsCount = 0;
    AutoScrollPagerAdapter autoScrollPagerAdapter;
    AutoScrollViewPager autoScrollViewPager;
    //nvghgh
    private ImageView[] dots;
    LinearLayout dotsLinearLayout;

   public HealperC(Context context, AutoScrollViewPager autoScrollViewPager, int dotsCount, LinearLayout dotsLinearLayout) {
        this.context = context;
        this.autoScrollViewPager = autoScrollViewPager;
        this.dotsLinearLayout = dotsLinearLayout;
        this.dotsCount = dotsCount;
    }

    public void setupBanner() {
        autoScrollPagerAdapter = new AutoScrollPagerAdapter(context);
        autoScrollViewPager.setAdapter(autoScrollPagerAdapter);
        setUiPageViewController();
        autoScrollViewPager.setOnPageChangeListener(getPageListyener());
    }

    public AutoScrollViewPager.OnPageChangeListener getPageListyener() {
        return onPageChangeListener;
    }

   public AutoScrollViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            for (int i = 0; i < dotsCount; i++) {
                if (Build.VERSION.SDK_INT <= 21)
                    dots[i].setImageDrawable(context.getResources().getDrawable(R.drawable.normal_circle_item));
                else
                    dots[i].setImageDrawable(context.getResources().getDrawable(R.drawable.normal_circle_item, null));
            }
            if (Build.VERSION.SDK_INT <= 21) {

                dots[position].setImageDrawable(context.getResources().getDrawable(R.drawable.selected_circle_item));
            } else {
                dots[position].setImageDrawable(context.getResources().getDrawable(R.drawable.selected_circle_item, null));
            }


        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }

    };

    public void setUiPageViewController() {
        dots = new ImageView[dotsCount];
        dotsLinearLayout.removeAllViews();

        for (int i = 0; i < dotsCount; i++) {
            dots[i] = new ImageView(context);
            dots[i].setPadding(5, 0, 5, 0);
            if (Build.VERSION.SDK_INT <= 21)
                dots[i].setImageDrawable(context.getResources().getDrawable(R.drawable.normal_circle_item));
            else
                dots[i].setImageDrawable(context.getResources().getDrawable(R.drawable.normal_circle_item, null));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            params.setMargins(0, 0, 0, 0);

            dotsLinearLayout.addView(dots[i], params);
        }

        if (Build.VERSION.SDK_INT <= 21)
            dots[0].setImageDrawable(context.getResources().getDrawable(R.drawable.selected_circle_item));
        else
            dots[0].setImageDrawable(context.getResources().getDrawable(R.drawable.selected_circle_item, null));
    }
}
