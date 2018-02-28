package r4mstein.ua.thenxworkouts.root.network.di;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import r4mstein.ua.thenxworkouts.root.network.INetworkManager;
import r4mstein.ua.thenxworkouts.root.network.NetworkManagerImpl;

/**
 * Created by Alex Shtain on 27.02.2018.
 */
@Module
public final class DiNetworkModule {

    @Provides
    @Singleton
    final INetworkManager provideNetworkManager(final Context _context) {
        return new NetworkManagerImpl(_context);
    }
}
