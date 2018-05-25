package me.aungkooo.slider;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by Ko Oo on 25/5/2018.
 */

public abstract class SliderAdapter<OBJ> extends PagerAdapter
{
    private Context context;
    private ArrayList<OBJ> itemList;
    private View layoutView;

    public SliderAdapter(Context context) {
        this.context = context;
        this.itemList = new ArrayList<>();
    }

    public SliderAdapter(Context context, ArrayList<OBJ> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    public void setItemList(ArrayList<OBJ> itemList) {
        this.itemList = itemList;
        notifyDataSetChanged();
    }

    public ArrayList<OBJ> getItemList() {
        return itemList;
    }

    public OBJ getItem(int position)
    {
        return itemList.get(position);
    }

    public Context getContext() {
        return context;
    }

    public View getLayoutView() {
        return layoutView;
    }

    public View createView(@LayoutRes int resId, ViewGroup container)
    {
        layoutView = LayoutInflater.from(context).inflate(resId, container, false);
        return layoutView;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        onCreateView(container);
        onBindView(container, position);

        container.addView(layoutView);
        return layoutView;
    }

    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    public abstract void onCreateView(ViewGroup container);
    public abstract void onBindView(ViewGroup container, int position);
}
