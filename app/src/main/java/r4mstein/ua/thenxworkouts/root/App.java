package r4mstein.ua.thenxworkouts.root;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * Created by Alex Shtain on 27.02.2018.
 */

public final class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
        ObjectGraph.getInstance(this); // init
    }
}
