package r4mstein.ua.thenxworkouts.root.base;

import android.support.annotation.CallSuper;

import hugo.weaving.DebugLog;

/**
 * Created by Alex Shtain on 27.02.2018.
 */

public abstract class BaseModel<P extends IPresenter> implements IModel<P> {

    protected P mPresenter;

    @CallSuper
    @DebugLog
    @Override
    public void setPresenter(final P _presenter) {
        mPresenter = _presenter;
    }

    @CallSuper
    @DebugLog
    @Override
    public void removePresenter() {
        mPresenter = null;
    }

    @CallSuper
    @DebugLog
    @Override
    public boolean isHasPresenter() {
        return mPresenter != null;
    }
}
