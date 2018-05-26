# Slider
Android library for sliding views with default indicators and view transitions.

Usage
-----
Import the library ('slider') from your project.

In app/gradle.build

```groovy
dependencies {
    implementation project(':slider')
}
```

minSdkVersion = '21'

Example
-------

First, You need to bind your views with new SliderAdapter

    @Override
    public View onCreateView(ViewGroup container) {
        View view = createView(R.layout.item_view, container);
        return view;
    }

    @Override
    public void onBindView(ViewGroup container, int position) {
        // bind your views here
    }

In MainActivity.java

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sliderHeader.setAdapter(new ImageSlider(this, itemList));
        sliderHeader.setIndicator(new DotIndicator());
        sliderHeader.setPageTransformer(new DepthPageTransformer());
    }
    
In activity_main.xml

    <me.aungkooo.slider.Slider
        android:id="@+id/slider"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>

	  
Indicators
----------
There are two default indicators: *DotIndicator* and *BarIndicator*

**Dot Indicator**

![screenrecord](/resource/default_indicator.gif)

**Custom Indicator**

You can set your custom indicator as

	slider.setIndicator(new Indicator(
                this, R.drawable.ic_active, R.drawable.ic_inactive));

![screenrecord](/resource/custom_indicator.gif)

Page Transformers
-----------------
There are two default page transformers: *DepthPageTransformer* and *ZoomOutPageTransformer*

You can create your own page transformer as

public class YourTransformer implements ViewPager.PageTransformer {
    @Override
    public void transformPage(@NonNull View page, float position) {
        // animate view here
    }
}