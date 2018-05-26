package me.aungkooo.imageslider;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.aungkooo.slider.DepthPageTransformer;
import me.aungkooo.slider.DotIndicator;
import me.aungkooo.slider.Indicator;
import me.aungkooo.slider.Slider;
import me.aungkooo.slider.ZoomOutPageTransformer;

public class MainActivity extends AppCompatActivity
{
    @BindView(R.id.slider_header)
    Slider sliderHeader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        ArrayList<HeaderItem> itemList = new ArrayList<>();

        String[] titles = {"Material Design Principles Bold", "Material Design Principles Metaphor",
                "Material Design Principles Motion"};
        int[] images = {R.drawable.materialdesign_principles_bold,
                R.drawable.materialdesign_principles_metaphor,
                R.drawable.materialdesign_principles_motion};

        for (int i = 0, len = titles.length; i < len; i++) {
            itemList.add(new HeaderItem(titles[i], images[i]));
        }

        sliderHeader.setAdapter(new ImageSlider(this, itemList));
        sliderHeader.setIndicator(new Indicator(
                this, R.drawable.ic_favorite, R.drawable.ic_favorite_border));
        sliderHeader.setPageTransformer(new DepthPageTransformer());
    }
}
