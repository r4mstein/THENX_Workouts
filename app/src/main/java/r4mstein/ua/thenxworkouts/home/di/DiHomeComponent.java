package r4mstein.ua.thenxworkouts.home.di;

import dagger.Component;
import r4mstein.ua.thenxworkouts.home.navigator.HomeActivity;
import r4mstein.ua.thenxworkouts.root.di.DiRootComponent;

/**
 * Created by Alex Shtain on 02.03.2018.
 */
@HomeScope
@Component(modules = DiHomeModule.class,
        dependencies = DiRootComponent.class)
public interface DiHomeComponent {
    void inject(HomeActivity _activity);
}
