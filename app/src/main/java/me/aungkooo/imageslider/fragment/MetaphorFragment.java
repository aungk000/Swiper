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
import me.aungkooo.imageslider.databinding.FragmentMetaphorBinding;

/**
 * Created by User on 30/5/2018.
 */

public class MetaphorFragment extends Fragment {
    @Nullable
    private FragmentMetaphorBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentMetaphorBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        binding.txtMetaphor.setText(R.string.material_design_principles_metaphor);
        Context context = getContext();
        if (context != null) {
            Picasso.with(getContext()).load(R.drawable.materialdesign_principles_metaphor).into(binding.imgMetaphor);
            binding.relativeLayoutMetaphor.setBackgroundColor(ContextCompat.getColor(context, R.color.light_blue));
        }
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
