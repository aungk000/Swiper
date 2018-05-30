# Slider
Android library for sliding views and fragments with default indicators and view transitions.

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

For views, use *ViewAdapter*.

```java
    @Override
    public View onCreateView(ViewGroup container) {
        View view = createView(R.layout.item_view, container);
        return view;
    }

    @Override
    public void onBindView(ViewGroup container, int position) {
        // bind your views here
    }
```

For fragments, use *FragmentAdapter*.
    
In MainActivity.java

```java
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

	  // For ViewAdapter
        slider.setViewAdapter(new ViewSlider(this, itemList));
	  // For FragmentAdapter
	  slider.setFragmentAdapter(new FragmentAdapter(getSupportFragmentManager(), fragmentList));
	  
        slider.setIndicator(new DotIndicator());
        slider.setPageTransformer(new DepthPageTransformer());
    }
```
    
In activity_main.xml

```xml
    <me.aungkooo.slider.Slider
        android:id="@+id/slider"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>
```

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

You can also use other opensource indicator libraries such as [InkPageIndicator](https://github.com/DavidPacioianu/InkPageIndicator).

```java
    inkPageIndicator.setViewPager(slider.getViewPager());
````

Other awesome indicators are:

* [SpringIndicator](https://github.com/chenupt/SpringIndicator)
* Jake Wharton's [ViewPagerIndicator](https://github.com/JakeWharton/ViewPagerIndicator)
* [ExtensiblePageIndicator](https://github.com/merhold/extensible-page-indicator)

Page Transformers
-----------------
There are two default page transformers: *DepthPageTransformer* and *ZoomOutPageTransformer*

You can create your own page transformer as

```java
public class YourTransformer implements ViewPager.PageTransformer {
    @Override
    public void transformPage(@NonNull View page, float position) {
        // animate view here
    }
}
```