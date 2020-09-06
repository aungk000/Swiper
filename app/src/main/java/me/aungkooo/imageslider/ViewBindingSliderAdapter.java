package me.aungkooo.imageslider;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

import me.aungkooo.slider.ViewAdapter;

public class ViewBindingSliderAdapter extends ViewAdapter<HeaderItemView, HeaderItem> {

    public ViewBindingSliderAdapter(Context context, List<HeaderItem> itemList) {
        super(context, itemList);
    }

    @Override
    public HeaderItemView onCreateView(ViewGroup container) {
        return new HeaderItemView(getContext());
    }

    @Override
    public void onBindView(ViewGroup container, final HeaderItemView view, final HeaderItem item, int position) {
        Picasso.with(getContext()).load(item.getImageResource())
                .centerCrop().resize(720, 720).into(view.getImageHeader());
        view.getTextHeader().setText(item.getTitle());

        view.getCardViewHeader().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), item.getTitle(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
