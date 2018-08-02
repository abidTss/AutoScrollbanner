package com.example.abid.autoscrollbanner;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.bannerautoscroll.AutoScrollViewPager;
import com.example.bannerautoscroll.HealperC;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private Context context = MainActivity.this;
   // AutoScrollViewPager autoScrollViewPager;
    private LinearLayout dotsLinearLayout;
    private List<String> picList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      /*  picList.add("dsdsghdfhsf");
        picList.add("dsdsghdfhsf");
        picList.add("dsdsghdfhsf");
        dotsLinearLayout = (LinearLayout) findViewById(R.id.linear_dots_pager);
        autoScrollViewPager = (AutoScrollViewPager) findViewById(R.id.auto_scroll_pager);
        HealperC healperC = new HealperC(context, autoScrollViewPager, dotsLinearLayout, picList);
        healperC.setupBanner();*/
    }

    @Override
    protected void onResume() {
        super.onResume();
      //  autoScrollViewPager.startAutoScroll();
    }

    @Override
    protected void onPause() {
        super.onPause();
       // autoScrollViewPager.stopAutoScroll();
    }
}
