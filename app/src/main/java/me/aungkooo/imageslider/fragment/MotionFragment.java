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

public class MotionFragment extends Fragment
{
    @BindView(R.id.img_motion)
    ImageView imgMotion;
    @BindView(R.id.txt_motion)
    TextView txtMotion;
    @BindView(R.id.relative_layout_motion)
    RelativeLayout relativeLayoutMotion;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_motion, container, false);
        unbinder = ButterKnife.bind(this, view);

        txtMotion.setText(R.string.material_design_principles_motion);
        Picasso.with(getContext()).load(R.drawable.materialdesign_principles_motion).into(imgMotion);
        relativeLayoutMotion.setBackgroundColor(Color.parseColor("#ffffff"));

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
