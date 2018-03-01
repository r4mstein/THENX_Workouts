package r4mstein.ua.thenxworkouts.root.navigator;

import android.content.Intent;

import hugo.weaving.DebugLog;
import r4mstein.ua.thenxworkouts.auth.navigator.AuthActivity;
import r4mstein.ua.thenxworkouts.home.HomeActivity;
import r4mstein.ua.thenxworkouts.root.base.BaseActivity;

/**
 * Created by Alex Shtain on 28.02.2018.
 */

public final class RootNavigatorImpl implements IRootNavigator {

    @DebugLog
    @Override
    public void openHome(final BaseActivity _activity) {
        _activity.startActivity(new Intent(_activity, HomeActivity.class));
    }

    @DebugLog
    @Override
    public void openAuth(final BaseActivity _activity) {
        _activity.startActivity(new Intent(_activity, AuthActivity.class));
    }
}
