package r4mstein.ua.thenxworkouts.home.navigator;

import android.os.Bundle;

import javax.inject.Inject;

import hugo.weaving.DebugLog;
import r4mstein.ua.thenxworkouts.R;
import r4mstein.ua.thenxworkouts.root.base.BaseActivity;
import r4mstein.ua.thenxworkouts.root.navigator.IRootNavigator;

public class HomeActivity extends BaseActivity<IHomeNavigator, IHomeContract.Model>
        implements IHomeContract.Presenter, IHomeNavigator {

    @Inject
    IRootNavigator mRootNavigator;

    @DebugLog
    @Override
    protected void init() {
        mNavigator = this;
        mObjectGraph.getHomeComponent().inject(this);
    }

    @DebugLog
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindView(this);
    }

    @DebugLog
    @Override
    public final void logout() {
        mModel.logout();
        mRootNavigator.openAuth(this);
        finish();
    }

    private int getRootContainer() {
        return R.id.flRootContainer_AM;
    }
}
