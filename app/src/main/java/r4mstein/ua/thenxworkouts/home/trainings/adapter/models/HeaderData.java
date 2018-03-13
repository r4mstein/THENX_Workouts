package r4mstein.ua.thenxworkouts.home.trainings.adapter.models;

import r4mstein.ua.thenxworkouts.R;

/**
 * Created by Alex Shtain on 10.03.2018.
 */

public final class HeaderData {
    private int mId;
    private String mHeader;
    private boolean isExpanded = false;
    private int mIconId = R.drawable.ic_arrow_down;

    public HeaderData(final int _id, final String _header) {
        mHeader = _header;
        mId = _id;
    }

    public int getId() {
        return mId;
    }

    public String getHeader() {
        return mHeader;
    }

    public boolean isExpanded() {
        return isExpanded;
    }

    public void setExpanded(final boolean _expanded) {
        isExpanded = _expanded;
    }

    public int getIconId() {
        return mIconId;
    }

    public void setIconId(int iconId) {
        mIconId = iconId;
    }

    @Override
    public String toString() {
        return "HeaderData{" +
                "mId=" + mId +
                ", mHeader='" + mHeader + '\'' +
                ", isExpanded=" + isExpanded +
                ", mIconId=" + mIconId +
                '}';
    }
}
