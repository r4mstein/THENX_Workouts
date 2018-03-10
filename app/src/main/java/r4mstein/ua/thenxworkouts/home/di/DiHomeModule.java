package r4mstein.ua.thenxworkouts.home.di;

import dagger.Module;
import dagger.Provides;
import r4mstein.ua.thenxworkouts.home.navigator.HomeModelImpl;
import r4mstein.ua.thenxworkouts.home.navigator.IHomeContract;
import r4mstein.ua.thenxworkouts.root.firebase.IFirebaseManager;

/**
 * Created by Alex Shtain on 02.03.2018.
 */
@Module
public final class DiHomeModule {

    @Provides
    @HomeScope
    final IHomeContract.Model provideHomeModel(final IFirebaseManager _firebaseManager) {
        return new HomeModelImpl(_firebaseManager);
    }
}
