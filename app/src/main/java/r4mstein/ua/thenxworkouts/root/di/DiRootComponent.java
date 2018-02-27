package r4mstein.ua.thenxworkouts.root.di;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import r4mstein.ua.thenxworkouts.root.network.INetworkManager;
import r4mstein.ua.thenxworkouts.root.network.di.DiNetworkModule;

/**
 * Created by Alex Shtain on 27.02.2018.
 */
@Singleton
@Component(modules = {
        DiAppModule.class,
        DiNetworkModule.class
})
public interface DiRootComponent {
    Context context();

    INetworkManager networkManager();
}
