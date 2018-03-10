package r4mstein.ua.thenxworkouts.auth.login;

import r4mstein.ua.thenxworkouts.auth.AuthData;
import r4mstein.ua.thenxworkouts.root.base.IModel;
import r4mstein.ua.thenxworkouts.root.base.IPresenter;

/**
 * Created by Alex Shtain on 01.03.2018.
 */

public interface ILoginContract {

    interface Presenter extends IPresenter {
        void loginSuccess();
        void loginFailed(Exception _e);
    }

    interface Model extends IModel<Presenter> {
        void login(AuthData _data);
    }
}
