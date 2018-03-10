package r4mstein.ua.thenxworkouts.home.trainings.di;

import dagger.Module;
import dagger.Provides;
import r4mstein.ua.thenxworkouts.home.di.HomeScope;
import r4mstein.ua.thenxworkouts.home.trainings.ITrainingsContract;
import r4mstein.ua.thenxworkouts.home.trainings.TrainingsModelImpl;
import r4mstein.ua.thenxworkouts.root.firebase.IFirebaseManager;

/**
 * Created by Alex Shtain on 10.03.2018.
 */
@Module
public final class DiTrainingsModule {

    @Provides
    @HomeScope
    final ITrainingsContract.Model provideTrainingsModel(final IFirebaseManager _firebaseManager) {
        return new TrainingsModelImpl(_firebaseManager);
    }
}
