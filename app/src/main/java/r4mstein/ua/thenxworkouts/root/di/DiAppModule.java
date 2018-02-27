package r4mstein.ua.thenxworkouts.root.di;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Alex Shtain on 27.02.2018.
 */
@Module
public final class DiAppModule {

    private final Context mContext;

    public DiAppModule(final Context _context) {
        mContext = _context;
    }

    @Provides
    @Singleton
    final Context provideContext() {
        return mContext;
    }
}
