package me.aungkooo.imageslider.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.squareup.picasso.Picasso;

import me.aungkooo.imageslider.R;
import me.aungkooo.imageslider.databinding.FragmentBoldBinding;

/**
 * Created by User on 30/5/2018.
 */

public class BoldFragment extends Fragment {
    @Nullable
    private FragmentBoldBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentBoldBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        binding.txtBold.setText(R.string.material_design_principles_bold);
        Context context = getContext();
        if (context != null) {
            Picasso.with(getContext()).load(R.drawable.materialdesign_principles_bold).into(binding.imgBold);
            binding.relativeLayoutBold.setBackgroundColor(ContextCompat.getColor(context, R.color.yellow));
        }

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
