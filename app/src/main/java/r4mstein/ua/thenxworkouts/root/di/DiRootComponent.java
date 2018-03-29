package r4mstein.ua.thenxworkouts.root.di;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import r4mstein.ua.thenxworkouts.root.dialog_shower.IDialogShower;
import r4mstein.ua.thenxworkouts.root.dialog_shower.di.DiDialogShowerModule;
import r4mstein.ua.thenxworkouts.root.error.IErrorManager;
import r4mstein.ua.thenxworkouts.root.error.di.DiErrorManagerModule;
import r4mstein.ua.thenxworkouts.root.firebase.IFirebaseManager;
import r4mstein.ua.thenxworkouts.root.firebase.di.DiFirebaseManagerModule;
import r4mstein.ua.thenxworkouts.root.navigator.DiRootNavigatorModule;
import r4mstein.ua.thenxworkouts.root.navigator.IRootNavigator;
import r4mstein.ua.thenxworkouts.root.network.INetworkManager;
import r4mstein.ua.thenxworkouts.root.network.di.DiNetworkModule;

/**
 * Created by Alex Shtain on 27.02.2018.
 */
@Singleton
@Component(modules = {
        DiAppModule.class,
        DiNetworkModule.class,
        DiRootNavigatorModule.class,
        DiFirebaseManagerModule.class,
        DiDialogShowerModule.class,
        DiErrorManagerModule.class
})
public interface DiRootComponent {
    Context context();
    IRootNavigator rootNavigator();

    INetworkManager networkManager();
    IFirebaseManager firebaseManager();
    IDialogShower dialogShower();
    IErrorManager errorManager();
}
