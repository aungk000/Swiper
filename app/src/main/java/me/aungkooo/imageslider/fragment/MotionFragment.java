package me.aungkooo.imageslider.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import me.aungkooo.imageslider.R;
import me.aungkooo.imageslider.databinding.FragmentMotionBinding;

/**
 * Created by User on 30/5/2018.
 */

public class MotionFragment extends Fragment {

    @Nullable
    private FragmentMotionBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentMotionBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        binding.txtMotion.setText(R.string.material_design_principles_motion);
        Context context = getContext();
        if (context != null) {
            Picasso.with(context).load(R.drawable.materialdesign_principles_motion).into(binding.imgMotion);
            binding.relativeLayoutMotion.setBackgroundColor(ContextCompat.getColor(context, R.color.white));
        }
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
