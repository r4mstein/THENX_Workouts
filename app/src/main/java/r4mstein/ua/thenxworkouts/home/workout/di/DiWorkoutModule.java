package r4mstein.ua.thenxworkouts.home.workout.di;

import dagger.Module;
import dagger.Provides;
import r4mstein.ua.thenxworkouts.home.di.HomeScope;
import r4mstein.ua.thenxworkouts.home.workout.IWorkoutContract;
import r4mstein.ua.thenxworkouts.home.workout.WorkoutModelImpl;
import r4mstein.ua.thenxworkouts.root.firebase.IFirebaseManager;

/**
 * Created by Alex Shtain on 13.03.2018.
 */
@Module
public final class DiWorkoutModule {

    @Provides
    @HomeScope
    final IWorkoutContract.Model provideWorkoutModel(final IFirebaseManager _firebaseManager) {
        return new WorkoutModelImpl(_firebaseManager);
    }
}
