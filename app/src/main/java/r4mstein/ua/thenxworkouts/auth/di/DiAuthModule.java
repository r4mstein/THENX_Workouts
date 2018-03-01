package r4mstein.ua.thenxworkouts.auth.di;

import dagger.Module;
import dagger.Provides;
import r4mstein.ua.thenxworkouts.auth.navigator.AuthModelImpl;
import r4mstein.ua.thenxworkouts.auth.navigator.IAuthContract;
import r4mstein.ua.thenxworkouts.auth.register.IRegisterContract;
import r4mstein.ua.thenxworkouts.auth.register.RegisterModelImpl;
import r4mstein.ua.thenxworkouts.root.firebase.IFirebaseManager;

/**
 * Created by Alex Shtain on 01.03.2018.
 */
@Module
final class DiAuthModule {

    @Provides
    @AuthScope
    final IAuthContract.Model provideAuthModel() {
        return new AuthModelImpl();
    }

    @Provides
    @AuthScope
    final IRegisterContract.Model provideRegisterModel(final IFirebaseManager _firebaseManager) {
        return new RegisterModelImpl(_firebaseManager);
    }
}
