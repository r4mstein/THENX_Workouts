package r4mstein.ua.thenxworkouts.home.trainings.adapter.data_holder;

import r4mstein.ua.thenxworkouts.home.trainings.Constants;
import r4mstein.ua.thenxworkouts.home.trainings.adapter.models.HeaderData;
import r4mstein.ua.thenxworkouts.root.base.BaseDataHolder;

/**
 * Created by Alex Shtain on 10.03.2018.
 */

public final class HeaderDataHolder extends BaseDataHolder {
    private HeaderData mHeaderData;

    public HeaderDataHolder(final HeaderData _headerData) {
        mHeaderData = _headerData;
    }

    @Override
    public int itemViewType() {
        return Constants.AdapterKey.HEADER_TYPE;
    }

    public HeaderData getHeaderData() {
        return mHeaderData;
    }

    @Override
    public String toString() {
        return "HeaderDataHolder{" +
                "mHeaderData=" + mHeaderData +
                '}';
    }
}
