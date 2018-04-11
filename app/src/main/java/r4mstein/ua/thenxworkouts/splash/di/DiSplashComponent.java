package r4mstein.ua.thenxworkouts.splash.di;

import dagger.Component;
import r4mstein.ua.thenxworkouts.root.di.DiRootComponent;
import r4mstein.ua.thenxworkouts.splash.SplashActivity;

/**
 * Created by Alex Shtain on 27.02.2018.
 */
@SplashScope
@Component(modules = DiSplashModule.class,
           dependencies = DiRootComponent.class)
public interface DiSplashComponent {
    void inject(SplashActivity _activity);
}
