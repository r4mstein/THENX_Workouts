package r4mstein.ua.thenxworkouts.home.workout.adapter.data_holder;

import r4mstein.ua.thenxworkouts.home.workout.Constants;
import r4mstein.ua.thenxworkouts.home.workout.adapter.models.ItemData;
import r4mstein.ua.thenxworkouts.root.base.BaseDataHolder;

/**
 * Created by Alex Shtain on 16.03.2018.
 */

public final class ItemDH extends BaseDataHolder {

    private ItemData mData;

    public ItemDH(final ItemData _data) {
        mData = _data;
    }

    @Override
    public int itemViewType() {
        return Constants.AdapterKey.ITEM_TYPE;
    }

    public ItemData getData() {
        return mData;
    }

    public void setData(ItemData data) {
        mData = data;
    }

    @Override
    public String toString() {
        return "ItemDH{" +
                "Data=" + mData +
                '}';
    }
}
