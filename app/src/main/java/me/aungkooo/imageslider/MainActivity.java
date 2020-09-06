package me.aungkooo.imageslider;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;

import java.util.ArrayList;
import java.util.Collections;

import me.aungkooo.imageslider.databinding.ActivityMainBinding;
import me.aungkooo.imageslider.fragment.BoldFragment;
import me.aungkooo.imageslider.fragment.MetaphorFragment;
import me.aungkooo.imageslider.fragment.MotionFragment;
import me.aungkooo.slider.DepthPageTransformer;
import me.aungkooo.slider.DotIndicator;
import me.aungkooo.slider.FragmentAdapter;

public class MainActivity extends AppCompatActivity {

    private final boolean showViewSlider = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());

        ArrayList<HeaderItem> itemList = new ArrayList<>();

        String[] titles = {
                getString(R.string.material_design_principles_bold),
                getString(R.string.material_design_principles_metaphor),
                getString(R.string.material_design_principles_motion)
        };

        int[] images = {R.drawable.materialdesign_principles_bold,
                R.drawable.materialdesign_principles_metaphor,
                R.drawable.materialdesign_principles_motion};

        for (int i = 0, len = titles.length; i < len; i++) {
            itemList.add(new HeaderItem(titles[i], images[i]));
        }

        if (showViewSlider) {
            binding.slider.setViewAdapter(new ViewBindingSliderAdapter(this, itemList));
        } else {
            ArrayList<Fragment> fragmentList = new ArrayList<>();
            Fragment[] fragments = {new BoldFragment(), new MetaphorFragment(), new MotionFragment()};
            Collections.addAll(fragmentList, fragments);
            binding.slider.setFragmentAdapter(new FragmentAdapter(getSupportFragmentManager(), fragmentList));
        }

        binding.slider.setIndicator(new DotIndicator(this));
        binding.slider.setPageTransformer(new DepthPageTransformer());
    }
}
