package r4mstein.ua.thenxworkouts.home.workout.adapter.data_holder;

import r4mstein.ua.thenxworkouts.home.workout.Constants;
import r4mstein.ua.thenxworkouts.home.workout.adapter.models.HeaderData;
import r4mstein.ua.thenxworkouts.root.base.BaseDataHolder;

/**
 * Created by Alex Shtain on 16.03.2018.
 */

public final class HeaderDH extends BaseDataHolder {

    private HeaderData mData;

    public HeaderDH(final HeaderData _data) {
        mData = _data;
    }

    @Override
    public int itemViewType() {
        return Constants.AdapterKey.HEADER_TYPE;
    }

    public HeaderData getData() {
        return mData;
    }

    public void setData(HeaderData data) {
        mData = data;
    }

    @Override
    public String toString() {
        return "HeaderDH{" +
                "Data=" + mData +
                '}';
    }
}
