package r4mstein.ua.thenxworkouts.home.navigator;

import android.net.Uri;

import r4mstein.ua.thenxworkouts.root.base.IModel;
import r4mstein.ua.thenxworkouts.root.base.IPresenter;

/**
 * Created by Alex Shtain on 02.03.2018.
 */

public interface IHomeContract {

    interface Presenter extends IPresenter {
        void urlLoaded(Uri uri);
        void failedLoadUrl(Exception e);
    }

    interface Model extends IModel<Presenter> {
        void logout();
        void getFileUrl(final String _url);
    }
}
