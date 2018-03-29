package r4mstein.ua.thenxworkouts.root.error.di;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import r4mstein.ua.thenxworkouts.root.error.ErrorManagerImpl;
import r4mstein.ua.thenxworkouts.root.error.IErrorManager;

/**
 * Created by Alex Shtain on 28.03.2018.
 */
@Module
public final class DiErrorManagerModule {

    @Provides
    @Singleton
    final IErrorManager provideErrorManager(final Context _context) {
        return new ErrorManagerImpl(_context);
    }
}
