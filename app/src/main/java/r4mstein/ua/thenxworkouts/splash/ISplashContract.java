package r4mstein.ua.thenxworkouts.splash;

import r4mstein.ua.thenxworkouts.root.base.IModel;
import r4mstein.ua.thenxworkouts.root.base.IPresenter;

/**
 * Created by Alex Shtain on 27.02.2018.
 */

public interface ISplashContract {

    interface Presenter extends IPresenter {

    }

    interface Model extends IModel<Presenter> {
        boolean isConnectionAvailable();
        boolean isUserLogged();
    }
}
