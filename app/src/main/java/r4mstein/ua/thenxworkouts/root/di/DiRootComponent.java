package r4mstein.ua.thenxworkouts.root.di;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Alex Shtain on 27.02.2018.
 */
@Singleton
@Component(modules = DiAppModule.class)
public interface DiRootComponent {
    Context context();
}
