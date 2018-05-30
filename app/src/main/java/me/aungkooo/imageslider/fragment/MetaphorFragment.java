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

public class MetaphorFragment extends Fragment
{
    @BindView(R.id.img_metaphor)
    ImageView imgMetaphor;
    @BindView(R.id.txt_metaphor)
    TextView txtMetaphor;
    @BindView(R.id.relative_layout_metaphor)
    RelativeLayout relativeLayoutMetaphor;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_metaphor, container, false);
        unbinder = ButterKnife.bind(this, view);

        txtMetaphor.setText(R.string.material_design_principles_metaphor);
        Picasso.with(getContext()).load(R.drawable.materialdesign_principles_metaphor).into(imgMetaphor);
        relativeLayoutMetaphor.setBackgroundColor(Color.parseColor("#03a9f4"));

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
