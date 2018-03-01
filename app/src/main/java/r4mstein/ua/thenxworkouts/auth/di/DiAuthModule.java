package r4mstein.ua.thenxworkouts.auth.di;

import dagger.Module;
import dagger.Provides;
import r4mstein.ua.thenxworkouts.auth.navigator.AuthModelImpl;
import r4mstein.ua.thenxworkouts.auth.navigator.IAuthContract;

/**
 * Created by Alex Shtain on 01.03.2018.
 */
@Module
public final class DiAuthModule {

    @Provides
    @AuthScope
    final IAuthContract.Model provideAuthModel() {
        return new AuthModelImpl();
    }
}
