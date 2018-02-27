package r4mstein.ua.thenxworkouts.root.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import hugo.weaving.DebugLog;

/**
 * Created by Alex Shtain on 27.02.2018.
 */

public final class NetworkManagerImpl implements INetworkManager {

    private final ConnectivityManager mConnManager;

    public NetworkManagerImpl(final Context _context) {
        mConnManager = (ConnectivityManager) _context.getSystemService(Context.CONNECTIVITY_SERVICE);
    }

    @DebugLog
    @Override
    public boolean isConnected() {
        final NetworkInfo activeNetwork = mConnManager.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
    }
}
