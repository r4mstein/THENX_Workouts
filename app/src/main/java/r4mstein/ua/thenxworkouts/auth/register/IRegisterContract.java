package r4mstein.ua.thenxworkouts.auth.register;

import r4mstein.ua.thenxworkouts.auth.AuthData;
import r4mstein.ua.thenxworkouts.root.base.IModel;
import r4mstein.ua.thenxworkouts.root.base.IPresenter;

/**
 * Created by Alex Shtain on 01.03.2018.
 */

public interface IRegisterContract {

    interface Presenter extends IPresenter {
        void registered();
        void failedRegister(Exception _e);
    }

    interface Model extends IModel<Presenter> {
        void register(final AuthData _data);
    }
}
