package r4mstein.ua.thenxworkouts.home.navigator;

import r4mstein.ua.thenxworkouts.root.base.IModel;
import r4mstein.ua.thenxworkouts.root.base.IPresenter;

/**
 * Created by Alex Shtain on 02.03.2018.
 */

public interface IHomeContract {

    interface Presenter extends IPresenter {

    }

    interface Model extends IModel<Presenter> {
        void logout();
    }
}
