package r4mstein.ua.thenxworkouts.home.trainings;

import java.util.List;

import r4mstein.ua.thenxworkouts.root.base.BaseDataHolder;
import r4mstein.ua.thenxworkouts.root.base.IModel;
import r4mstein.ua.thenxworkouts.root.base.IPresenter;

/**
 * Created by Alex Shtain on 10.03.2018.
 */

public interface ITrainingsContract {

    interface Presenter extends IPresenter {
        void dataLoaded(List<BaseDataHolder> _list, TrainingsDataDto _data);
        void loadDataFailed(Exception _e);
    }

    interface Model extends IModel<Presenter> {
        void loadData(String _collection, String _document);
    }
}
