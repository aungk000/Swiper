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
    private View view;

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

    public View getView() {
        return view;
    }

    public View createView(@LayoutRes int resId, ViewGroup container)
    {
        view = LayoutInflater.from(context).inflate(resId, container, false);
        return view;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = onCreateView(container);
        onBindView(container, position);

        container.addView(view);
        return view;
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

    public abstract View onCreateView(ViewGroup container);
    public abstract void onBindView(ViewGroup container, int position);
}
