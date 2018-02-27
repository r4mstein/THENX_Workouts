package r4mstein.ua.thenxworkouts.root;

import android.content.Context;

import r4mstein.ua.thenxworkouts.root.di.DaggerDiRootComponent;
import r4mstein.ua.thenxworkouts.root.di.DiAppModule;
import r4mstein.ua.thenxworkouts.root.di.DiRootComponent;

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

    private ObjectGraph(final Context _context) {
        final DiRootComponent rootComponent = DaggerDiRootComponent.builder().diAppModule(new DiAppModule(_context)).build();
    }
}
