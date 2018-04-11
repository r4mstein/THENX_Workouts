package r4mstein.ua.thenxworkouts.root;

import android.content.Context;

import r4mstein.ua.thenxworkouts.auth.di.DaggerDiAuthComponent;
import r4mstein.ua.thenxworkouts.auth.di.DiAuthComponent;
import r4mstein.ua.thenxworkouts.home.di.DaggerDiHomeComponent;
import r4mstein.ua.thenxworkouts.home.di.DiHomeComponent;
import r4mstein.ua.thenxworkouts.root.di.DaggerDiRootComponent;
import r4mstein.ua.thenxworkouts.root.di.DiAppModule;
import r4mstein.ua.thenxworkouts.root.di.DiRootComponent;
import r4mstein.ua.thenxworkouts.splash.di.DaggerDiSplashComponent;
import r4mstein.ua.thenxworkouts.splash.di.DiSplashComponent;

/**
 * Created by Alex Shtain on 27.02.2018.
 */

public final class ObjectGraph {

    private static ObjectGraph graph;

    public static ObjectGraph getInstance(final Context _context) {
        if (graph == null) {
            graph = new ObjectGraph(_context);
        }
        return graph;
    }

    private final DiSplashComponent mSplashComponent;
    private final DiAuthComponent mAuthComponent;
    private final DiHomeComponent mHomeComponent;

    private ObjectGraph(final Context _context) {
        final DiRootComponent rootComponent = DaggerDiRootComponent.builder().diAppModule(new DiAppModule(_context)).build();
        mSplashComponent = DaggerDiSplashComponent.builder().diRootComponent(rootComponent).build();
        mAuthComponent = DaggerDiAuthComponent.builder().diRootComponent(rootComponent).build();
        mHomeComponent = DaggerDiHomeComponent.builder().diRootComponent(rootComponent).build();
    }

    public final DiSplashComponent getSplashComponent() {
        return mSplashComponent;
    }

    public final DiAuthComponent getAuthComponent() {
        return mAuthComponent;
    }

    public final DiHomeComponent getHomeComponent() {
        return mHomeComponent;
    }
}
