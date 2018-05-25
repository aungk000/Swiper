# Slider
Android library for sliding views with default indicator (dot) and view transitions.

Usage
-----
Import the library ('slider') from your project and

In app/gradle.build

```groovy
dependencies {
    implementation project(':slider')
}
```

minSdkVersion = '23'

Example
-------

First, You need to bind your views with new SliderAdapter

    @Override
    public void onCreateView(ViewGroup container) {
        View view = createView(R.layout.item_view, container);
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

        slider.setAdapter(new SliderAdapter());
        slider.setDotIndicator(DotIndicator.ALIGN_BOTTOM);
        slider.setPageTransformer(new DepthPageTransformer());
	  // There are two default page transformers 
	  // DepthPageTransformer and ZoomOutPageTransformer
    }
    
In activity_main.xml

    <me.aungkooo.slider.Slider
        android:id="@+id/slider"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>

	  
Screenshot
----------
![screenshot](/screenshot/screenshot.jpg)