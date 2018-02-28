package r4mstein.ua.thenxworkouts.splash.di;

import dagger.Module;
import dagger.Provides;
import r4mstein.ua.thenxworkouts.root.network.INetworkManager;
import r4mstein.ua.thenxworkouts.splash.ISplashContract;
import r4mstein.ua.thenxworkouts.splash.SplashModelImpl;

/**
 * Created by Alex Shtain on 27.02.2018.
 */
@Module
final class DiSplashModule {

    @Provides
    @SplashScope
    final ISplashContract.Model provideSplashModel(final INetworkManager _networkManager) {
        return new SplashModelImpl(_networkManager);
    }
}
