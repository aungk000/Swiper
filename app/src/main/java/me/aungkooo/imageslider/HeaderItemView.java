package me.aungkooo.imageslider;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import me.aungkooo.imageslider.databinding.ViewHeaderBinding;

public class HeaderItemView extends FrameLayout {

    @NonNull
    private final ViewHeaderBinding binding;

    public HeaderItemView(@NonNull Context context) {
        super(context);
        binding = ViewHeaderBinding.inflate(LayoutInflater.from(context), this, true);
    }

    @NonNull
    CardView getCardViewHeader() {
        return binding.cardViewHeader;
    }

    @NonNull
    ImageView getImageHeader() {
        return binding.imgHeader;
    }

    @NonNull
    TextView getTextHeader() {
        return binding.txtHeader;
    }
}
