package r4mstein.ua.thenxworkouts.root.dialog_shower.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import r4mstein.ua.thenxworkouts.root.dialog_shower.DialogShowerImpl;
import r4mstein.ua.thenxworkouts.root.dialog_shower.IDialogShower;

/**
 * Created by Alex Shtain on 26.03.2018.
 */
@Module
public final class DiDialogShowerModule {

    @Provides
    @Singleton
    final IDialogShower provideDialogShower() {
        return new DialogShowerImpl();
    }
}
