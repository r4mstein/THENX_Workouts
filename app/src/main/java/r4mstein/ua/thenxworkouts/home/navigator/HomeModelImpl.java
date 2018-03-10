package r4mstein.ua.thenxworkouts.home.navigator;

import javax.inject.Inject;

import hugo.weaving.DebugLog;
import r4mstein.ua.thenxworkouts.root.base.BaseModel;
import r4mstein.ua.thenxworkouts.root.firebase.IFirebaseManager;

/**
 * Created by Alex Shtain on 02.03.2018.
 */

public final class HomeModelImpl extends BaseModel<IHomeContract.Presenter> implements IHomeContract.Model {

    private final IFirebaseManager mFirebaseManager;

    @Inject
    public HomeModelImpl(final IFirebaseManager _firebaseManager) {
        mFirebaseManager = _firebaseManager;
    }

    @DebugLog
    @Override
    public void logout() {
        mFirebaseManager.logout();
    }
}
