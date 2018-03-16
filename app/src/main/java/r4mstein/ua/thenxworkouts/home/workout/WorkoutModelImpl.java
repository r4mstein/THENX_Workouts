package r4mstein.ua.thenxworkouts.home.workout;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.firestore.DocumentSnapshot;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import hugo.weaving.DebugLog;
import r4mstein.ua.thenxworkouts.home.WorkoutData;
import r4mstein.ua.thenxworkouts.home.workout.adapter.data_holder.HeaderDH;
import r4mstein.ua.thenxworkouts.home.workout.adapter.data_holder.InfoDH;
import r4mstein.ua.thenxworkouts.home.workout.adapter.data_holder.ItemDH;
import r4mstein.ua.thenxworkouts.home.workout.adapter.data_holder.RoundDH;
import r4mstein.ua.thenxworkouts.home.workout.adapter.models.HeaderData;
import r4mstein.ua.thenxworkouts.home.workout.adapter.models.InfoData;
import r4mstein.ua.thenxworkouts.home.workout.adapter.models.ItemData;
import r4mstein.ua.thenxworkouts.home.workout.adapter.models.RoundData;
import r4mstein.ua.thenxworkouts.root.base.BaseDataHolder;
import r4mstein.ua.thenxworkouts.root.base.BaseModel;
import r4mstein.ua.thenxworkouts.root.firebase.IFirebaseManager;

/**
 * Created by Alex Shtain on 13.03.2018.
 */

public final class WorkoutModelImpl extends BaseModel<IWorkoutContract.Presenter> implements IWorkoutContract.Model {

    private final IFirebaseManager mFirebaseManager;
    private WorkoutData mData;

    @Inject
    public WorkoutModelImpl(final IFirebaseManager _firebaseManager) {
        mFirebaseManager = _firebaseManager;
    }

    @DebugLog
    @Override
    public void loadData(final WorkoutData _data) {
        mData = _data;
        mFirebaseManager.loadDocument(_data.getLevel(), createDocumentName(_data), mLoadDocumentListener);
    }

    private String createDocumentName(final WorkoutData _data) {
        return String.format("%s%s", _data.getPart().replace(" ", ""), _data.getDay().replace(" ", ""));
    }

    private final OnCompleteListener<DocumentSnapshot> mLoadDocumentListener = _task -> {
        if (_task.isSuccessful()) {
            DocumentSnapshot document = _task.getResult();
            if (document != null && document.exists()) {
                final WorkoutDataDto data = document.toObject(WorkoutDataDto.class);
                final List<BaseDataHolder> list = createListData(data);
                mPresenter.dataLoaded(list);
            } else {
                mPresenter.dataLoaded(null);
            }
        } else {
            mPresenter.loadDataFailed(_task.getException());
        }
    };

    private List<BaseDataHolder> createListData(final WorkoutDataDto _data) {
        final List<BaseDataHolder> list = new ArrayList<>();

        list.add(new InfoDH(new InfoData(mData.getPart(), mData.getDay(), mData.getWorkoutName())));

        list.add(new HeaderDH(new HeaderData("Warm Up")));
        list.add(new RoundDH(new RoundData("Round One", String.valueOf(_data.getWarmUp().getCount()), false)));
        for (WorkoutDataDto.Exercise exercise : _data.getWarmUp().getExercises()) {
            list.add(createItemDH(exercise));
        }

        list.add(new HeaderDH(new HeaderData("Workout")));
        list.add(new RoundDH(new RoundData("Round One", String.valueOf(_data.getTrain().getRoundOneCount()), true)));
        for (WorkoutDataDto.Exercise exercise : _data.getTrain().getRoundOne()) {
            list.add(createItemDH(exercise));
        }

        return list;
    }

    private ItemDH createItemDH(final WorkoutDataDto.Exercise _exercise) {
        return new ItemDH(new ItemData(String.valueOf(_exercise.getId()), _exercise.getName(),
                String.valueOf(_exercise.getRepetition()), String.valueOf(_exercise.getTime()), _exercise.getLink()));
    }
}
