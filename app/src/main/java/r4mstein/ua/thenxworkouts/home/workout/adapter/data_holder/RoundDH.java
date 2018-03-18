package r4mstein.ua.thenxworkouts.home.workout.adapter.data_holder;

import r4mstein.ua.thenxworkouts.home.workout.Constants;
import r4mstein.ua.thenxworkouts.home.workout.adapter.models.RoundData;
import r4mstein.ua.thenxworkouts.root.base.BaseDataHolder;

/**
 * Created by Alex Shtain on 16.03.2018.
 */

public final class RoundDH extends BaseDataHolder {

    private RoundData mData;

    public RoundDH(final RoundData _data) {
        mData = _data;
    }

    @Override
    public int itemViewType() {
        return Constants.AdapterKey.ROUND_TYPE;
    }

    public RoundData getData() {
        return mData;
    }

    public void setData(RoundData data) {
        mData = data;
    }

    @Override
    public String toString() {
        return "RoundDH{" +
                "Data=" + mData +
                '}';
    }
}
