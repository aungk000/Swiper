package me.aungkooo.imageslider;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.aungkooo.slider.SliderAdapter;

/**
 * Created by Ko Oo on 25/5/2018.
 */

public class ImageSlider extends SliderAdapter<HeaderItem>
{
    @BindView(R.id.img_header)
    ImageView imgHeader;
    @BindView(R.id.txt_header)
    TextView txtHeader;
    @BindView(R.id.card_view_header)
    CardView cardViewHeader;

    public ImageSlider(Context context) {
        super(context);
    }

    public ImageSlider(Context context, ArrayList<HeaderItem> itemList) {
        super(context, itemList);
    }

    @Override
    public View onCreateView(ViewGroup container) {
        View view = createView(R.layout.view_header, container);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onBindView(ViewGroup container, int position) {
        final HeaderItem item = getItem(position);

        Picasso.with(getContext()).load(item.getImageResource())
                .centerCrop().resize(720, 720).into(imgHeader);
        txtHeader.setText(item.getTitle());

        cardViewHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), item.getTitle(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
