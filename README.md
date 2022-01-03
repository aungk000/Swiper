# Swiper
Android library for swiping views and fragments with default indicators and view transitions.

Usage
-----
Import the library ('swiper') or aar file to your project.

In app/gradle.build

```groovy
dependencies {
    implementation project(path: ':swiper')
}
```

minSdkVersion = '21'

Example
-------

For views, use *ViewAdapter*.

```kotlin
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Swiper.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.view_item, parent, false)
        return Swiper.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: Swiper.ViewHolder, position: Int) {
    	//Bind your view here
        }
    }
```

For fragments,
    
In MainActivity.kt

```kotlin
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val swiper: Swiper = findViewById(R.id.swiper)
	
        swiper.setAdapter(Swiper.FragmentAdapter(this, fragmentList))
        //swiper.setAdapter(ViewItemAdapter(this, itemList))

        //swiper.setIndicator(Swiper.DotIndicator(this))
        //swiper.setPageTransformer(Swiper.DepthPageTransformer())
    }
```
    
In activity_main.xml

```xml
    <com.losersclub.swiper.Swiper
        android:id="@+id/swiper"
        app:swiperPageTransformer="depthPageTransformer"
        app:swiperIndicatorActive="@drawable/dot_active"
        app:swiperIndicatorInactive="@drawable/dot_inactive"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintBottom_toBottomOf="parent"
        android:layout_width="0dp"
        android:layout_height="0dp"/>
```

Indicators
----------
There are two default indicators: *DotIndicator* and *BarIndicator*

**Dot Indicator**

![screenrecord](/resource/default_indicator.gif)

**Custom Indicator**

You can set your custom indicators in xml or in code.

![screenrecord](/resource/custom_indicator.gif)

**I haven't tested other indicator libraries with update.**

You can also use other opensource indicator libraries such as [InkPageIndicator](https://github.com/DavidPacioianu/InkPageIndicator).

```java
    inkPageIndicator.setViewPager(swiper.viewPager2);
````

Other awesome indicators are:

* [SpringIndicator](https://github.com/chenupt/SpringIndicator)
* Jake Wharton's [ViewPagerIndicator](https://github.com/JakeWharton/ViewPagerIndicator)
* [ExtensiblePageIndicator](https://github.com/merhold/extensible-page-indicator)

Page Transformers
-----------------
There are two default page transformers: *DepthPageTransformer* and *ZoomOutPageTransformer*

You can create your own page transformer as

```kotlin
class YourPageTransformer : ViewPager2.PageTransformer {
        override fun transformPage(view: View, position: Float) {
            view.apply {
	    	// Transform your page here
            }
        }
    }
```
