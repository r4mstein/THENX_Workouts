package r4mstein.ua.thenxworkouts.home.di;

import dagger.Component;
import r4mstein.ua.thenxworkouts.home.navigator.HomeActivity;
import r4mstein.ua.thenxworkouts.home.trainings.TrainingsFragment;
import r4mstein.ua.thenxworkouts.home.trainings.di.DiTrainingsModule;
import r4mstein.ua.thenxworkouts.home.workout.WorkoutFragment;
import r4mstein.ua.thenxworkouts.home.workout.di.DiWorkoutModule;
import r4mstein.ua.thenxworkouts.root.di.DiRootComponent;

/**
 * Created by Alex Shtain on 02.03.2018.
 */
@HomeScope
@Component(modules = {
        DiHomeModule.class,
        DiTrainingsModule.class,
        DiWorkoutModule.class
},
        dependencies = DiRootComponent.class)
public interface DiHomeComponent {
    void inject(HomeActivity _activity);
    void inject(TrainingsFragment _fragment);
    void inject(WorkoutFragment _fragment);
}
