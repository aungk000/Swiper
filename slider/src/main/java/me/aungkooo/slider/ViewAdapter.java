package me.aungkooo.slider;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ko Oo on 25/5/2018.
 */

public abstract class ViewAdapter<V extends View, OBJ> extends PagerAdapter {
    private final Context context;
    private List<OBJ> itemList;
    private V view;

    public ViewAdapter(Context context) {
        this.context = context;
        this.itemList = new ArrayList<>();
    }

    public ViewAdapter(Context context, List<OBJ> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    public void setItemList(ArrayList<OBJ> itemList) {
        this.itemList = itemList;
        notifyDataSetChanged();
    }

    public List<OBJ> getItemList() {
        return itemList;
    }

    public OBJ getItem(int position) {
        return itemList.get(position);
    }

    public Context getContext() {
        return context;
    }

    public V getView() {
        return view;
    }

    @SuppressWarnings("unchecked")
    public V createView(@LayoutRes int resId, ViewGroup container) {
        return (V) LayoutInflater.from(context).inflate(resId, container, false);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        view = onCreateView(container);
        final OBJ item = getItem(position);
        onBindView(container, view, item, position);
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

    public abstract V onCreateView(ViewGroup container);

    public abstract void onBindView(ViewGroup container, final V view, final OBJ item, int position);
}
