package r4mstein.ua.thenxworkouts.home.trainings.adapter.data_holder;

import r4mstein.ua.thenxworkouts.home.trainings.Constants;
import r4mstein.ua.thenxworkouts.home.trainings.adapter.models.ChildData;
import r4mstein.ua.thenxworkouts.root.base.BaseDataHolder;

/**
 * Created by Alex Shtain on 10.03.2018.
 */

public final class ChildDataHolder extends BaseDataHolder {
    private ChildData mChildData;

    public ChildDataHolder(final ChildData _childData) {
        mChildData = _childData;
    }

    @Override
    public int itemViewType() {
        return Constants.AdapterKey.CHILD_TYPE;
    }

    public ChildData getChildData() {
        return mChildData;
    }

    public void setChildData(final ChildData _childData) {
        mChildData = _childData;
    }

    @Override
    public String toString() {
        return "ChildDataHolder{" +
                "mChildData=" + mChildData +
                '}';
    }
}
