package r4mstein.ua.thenxworkouts.auth.navigator;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.FrameLayout;

import javax.inject.Inject;

import butterknife.BindView;
import hugo.weaving.DebugLog;
import r4mstein.ua.thenxworkouts.R;
import r4mstein.ua.thenxworkouts.auth.login.LoginFragment;
import r4mstein.ua.thenxworkouts.auth.register.RegisterFragment;
import r4mstein.ua.thenxworkouts.root.base.BaseActivity;
import r4mstein.ua.thenxworkouts.root.navigator.IRootNavigator;

/**
 * Created by Alex Shtain on 01.03.2018.
 */

public final class AuthActivity extends BaseActivity<IAuthNavigator, IAuthContract.Model>
        implements IAuthContract.Presenter, IAuthNavigator {

    @BindView(R.id.flRootContainer_AA)
    FrameLayout flRootContainer;

    @Inject
    IRootNavigator mRootNavigator;

    @DebugLog
    @Override
    protected void init() {
        mNavigator = this;
        mObjectGraph.getAuthComponent().inject(this);
    }

    @Override
    protected void onCreate(@Nullable final Bundle _savedInstanceState) {
        super.onCreate(_savedInstanceState);
        setContentView(R.layout.activity_auth);
        bindView(this);
        showLogin();
    }

    @DebugLog
    @Override
    public final void showRegister() {
        replaceFragment(getRootContainer(), RegisterFragment.newInstance());
    }

    @DebugLog
    @Override
    public final void showLogin() {
        replaceFragment(getRootContainer(), LoginFragment.newInstance());
    }

    @DebugLog
    @Override
    public final void openHome() {
        mRootNavigator.openHome(this);
        finish();
    }

    private int getRootContainer() {
        return R.id.flRootContainer_AA;
    }
}
