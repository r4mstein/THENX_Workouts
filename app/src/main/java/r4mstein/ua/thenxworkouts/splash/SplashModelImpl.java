package r4mstein.ua.thenxworkouts.splash;

import javax.inject.Inject;

import hugo.weaving.DebugLog;
import r4mstein.ua.thenxworkouts.root.base.BaseModel;
import r4mstein.ua.thenxworkouts.root.network.INetworkManager;

/**
 * Created by Alex Shtain on 27.02.2018.
 */

public final class SplashModelImpl extends BaseModel<ISplashContract.Presenter> implements ISplashContract.Model {

    private final INetworkManager mNetworkManager;

    @Inject
    public SplashModelImpl(final INetworkManager _networkManager) {
        mNetworkManager = _networkManager;
    }

    @DebugLog
    @Override
    public final boolean isConnectionAvailable() {
        return mNetworkManager.isConnected();
    }
}
