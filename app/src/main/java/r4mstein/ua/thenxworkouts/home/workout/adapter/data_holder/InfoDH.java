package r4mstein.ua.thenxworkouts.home.workout.adapter.data_holder;

import r4mstein.ua.thenxworkouts.home.workout.Constants;
import r4mstein.ua.thenxworkouts.home.workout.adapter.models.InfoData;
import r4mstein.ua.thenxworkouts.root.base.BaseDataHolder;

/**
 * Created by Alex Shtain on 16.03.2018.
 */

public final class InfoDH extends BaseDataHolder {

    private InfoData mData;

    public InfoDH(final InfoData _data) {
        mData = _data;
    }

    @Override
    public int itemViewType() {
        return Constants.AdapterKey.INFO_TYPE;
    }

    public InfoData getData() {
        return mData;
    }

    public void setData(InfoData data) {
        mData = data;
    }

    @Override
    public String toString() {
        return "InfoDH{" +
                "Data=" + mData +
                '}';
    }
}
