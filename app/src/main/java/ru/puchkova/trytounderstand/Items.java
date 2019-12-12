package ru.puchkova.trytounderstand;

import android.graphics.drawable.Drawable;

public class Items {
    private Drawable image;
    private String title;
    private String subtitle;
    private boolean checked;

    public Items(Drawable image, String title, String subtitle, boolean checked) {
        this.image = image;
        this.title = title;
        this.subtitle = subtitle;
        this.checked = checked;
    }

    public Drawable getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
