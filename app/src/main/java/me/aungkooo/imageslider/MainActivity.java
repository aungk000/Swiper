package me.aungkooo.imageslider;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.aungkooo.imageslider.fragment.BoldFragment;
import me.aungkooo.imageslider.fragment.MetaphorFragment;
import me.aungkooo.imageslider.fragment.MotionFragment;
import me.aungkooo.slider.DepthPageTransformer;
import me.aungkooo.slider.DotIndicator;
import me.aungkooo.slider.Indicator;
import me.aungkooo.slider.Slider;

public class MainActivity extends AppCompatActivity
{
    @BindView(R.id.slider)
    Slider slider;

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

        ArrayList<Fragment> fragmentList = new ArrayList<>();
        Fragment[] fragments = {new BoldFragment(), new MetaphorFragment(), new MotionFragment()};
        Collections.addAll(fragmentList, fragments);

        slider.setViewAdapter(new ViewSlider(this, itemList));
        // slider.setFragmentAdapter(new FragmentAdapter(getSupportFragmentManager(), fragmentList));
        slider.setIndicator(new DotIndicator(this));
        slider.setPageTransformer(new DepthPageTransformer());
    }
}
