package r4mstein.ua.thenxworkouts.root.firebase.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import r4mstein.ua.thenxworkouts.root.firebase.FirebaseManagerImpl;
import r4mstein.ua.thenxworkouts.root.firebase.IFirebaseManager;

/**
 * Created by Alex Shtain on 01.03.2018.
 */
@Module
public final class DiFirebaseManagerModule {

    @Provides
    @Singleton
    final IFirebaseManager provideFirebaseManager() {
        return new FirebaseManagerImpl();
    }
}
