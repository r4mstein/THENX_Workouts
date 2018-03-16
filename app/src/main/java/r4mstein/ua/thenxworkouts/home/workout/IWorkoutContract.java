package r4mstein.ua.thenxworkouts.home.workout;

import java.util.List;

import r4mstein.ua.thenxworkouts.home.WorkoutData;
import r4mstein.ua.thenxworkouts.root.base.BaseDataHolder;
import r4mstein.ua.thenxworkouts.root.base.IModel;
import r4mstein.ua.thenxworkouts.root.base.IPresenter;

/**
 * Created by Alex Shtain on 13.03.2018.
 */

public interface IWorkoutContract {

    interface Presenter extends IPresenter {
        void dataLoaded(List<BaseDataHolder> _list);
        void loadDataFailed(Exception _e);
    }

    interface Model extends IModel<Presenter> {
        void loadData(WorkoutData _data);
    }
}
