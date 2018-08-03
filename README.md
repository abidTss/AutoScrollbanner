# AutoScrollbanner
For using this project you need to add

allprojects {

    repositories {
        ....
        
        maven { url 'https://jitpack.io'}
    
    }
    
in build.gradle(project)

And add

    compile 'com.github.abidTss:AutoScrollbanner:c0323b865d'

in build.gradle(App)

#write following code in your xml file


<LinearLayout
       android:layout_width="368dp"
       android:layout_height="200dp"
       android:background="#000"
       tools:layout_editor_absoluteY="0dp"
       tools:layout_editor_absoluteX="8dp">
       
      <RelativeLayout
          android:layout_width="match_parent"
          android:layout_height="match_parent"
          >
          
         <com.example.abid.autoscrollbanner.customViewpager.AutoScrollViewPager
             android:id="@+id/auto_scroll_pager"
             android:layout_width="match_parent"
             android:layout_height="wrap_content"
             android:layout_gravity="top"
             >
         </com.example.abid.autoscrollbanner.customViewpager.AutoScrollViewPager>

         <LinearLayout
             android:layout_width="match_parent"
             android:layout_height="25dp"
             android:id="@+id/linear_dots_pager"
             android:orientation="horizontal"
             android:layout_gravity="center"
             android:layout_alignBottom="@+id/auto_scroll_pager"
             android:gravity="center">

         </LinearLayout>

      </RelativeLayout>

   </LinearLayout>
   
   #Add this code in your Activity 
   
   Context context=MainActivity.this;
   
    AutoScrollViewPager autoScrollViewPager;
    
     LinearLayout dotsLinearLayout;
     
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dotsLinearLayout = (LinearLayout) findViewById(R.id.linear_dots_pager);
        autoScrollViewPager = (AutoScrollViewPager) findViewById(R.id.auto_scroll_pager);
        HealperC healperC;
        healperC = new HealperC(context,autoScrollViewPager,4,dotsLinearLayout);
        healperC.setupBanner();
        
    }
that's it


happy coding
