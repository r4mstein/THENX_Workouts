package r4mstein.ua.thenxworkouts.home.home_fragment.di;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import r4mstein.ua.thenxworkouts.home.di.HomeScope;
import r4mstein.ua.thenxworkouts.home.home_fragment.HomeModelImpl;
import r4mstein.ua.thenxworkouts.home.home_fragment.IHomeFragment;

/**
 * Created by Alex Shtain on 02.04.2018.
 */
@Module
public final class DiHomeFragmentModule {

    @Provides
    @HomeScope
    final IHomeFragment.Model provideHomeFragmentModel(final Context _context) {
        return new HomeModelImpl(_context);
    }
}
