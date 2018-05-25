package me.aungkooo.imageslider;

/**
 * Created by Ko Oo on 25/5/2018.
 */

public class HeaderItem
{
    private String title;
    private int imageResource;

    public HeaderItem() {
    }

    public HeaderItem(String title, int imageResource) {
        this.title = title;
        this.imageResource = imageResource;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }
}
