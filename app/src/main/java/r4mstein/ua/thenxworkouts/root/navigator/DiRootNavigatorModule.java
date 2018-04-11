package r4mstein.ua.thenxworkouts.root.navigator;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Alex Shtain on 28.02.2018.
 */
@Module
public final class DiRootNavigatorModule {

    @Provides
    @Singleton
    final IRootNavigator provideRootNavigator() {
        return new RootNavigatorImpl();
    }
}
