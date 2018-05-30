package me.aungkooo.imageslider.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.aungkooo.imageslider.R;

/**
 * Created by User on 30/5/2018.
 */

public class BoldFragment extends Fragment
{
    @BindView(R.id.img_bold)
    ImageView imgBold;
    @BindView(R.id.txt_bold)
    TextView txtBold;
    @BindView(R.id.relative_layout_bold)
    RelativeLayout relativeLayoutBold;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bold, container, false);
        unbinder = ButterKnife.bind(this, view);

        txtBold.setText(R.string.material_design_principles_bold);
        Picasso.with(getContext()).load(R.drawable.materialdesign_principles_bold).into(imgBold);
        relativeLayoutBold.setBackgroundColor(Color.parseColor("#ffd180"));

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
