package r4mstein.ua.thenxworkouts.home.home_fragment;

import java.util.List;

import r4mstein.ua.thenxworkouts.home.home_fragment.adapter.PagerData;
import r4mstein.ua.thenxworkouts.root.base.IModel;
import r4mstein.ua.thenxworkouts.root.base.IPresenter;

/**
 * Created by Alex Shtain on 02.04.2018.
 */
public interface IHomeFragment {

    interface Presenter extends IPresenter {

    }

    interface Model extends IModel<Presenter> {
        List<PagerData> createPagerData();
    }
}
