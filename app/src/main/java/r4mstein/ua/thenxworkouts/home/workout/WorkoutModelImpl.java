package r4mstein.ua.thenxworkouts.home.workout;

import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.firestore.DocumentSnapshot;

import javax.inject.Inject;

import hugo.weaving.DebugLog;
import r4mstein.ua.thenxworkouts.root.base.BaseModel;
import r4mstein.ua.thenxworkouts.root.firebase.IFirebaseManager;

/**
 * Created by Alex Shtain on 13.03.2018.
 */

public final class WorkoutModelImpl extends BaseModel<IWorkoutContract.Presenter> implements IWorkoutContract.Model {

    private final IFirebaseManager mFirebaseManager;

    @Inject
    public WorkoutModelImpl(final IFirebaseManager _firebaseManager) {
        mFirebaseManager = _firebaseManager;
    }

    @DebugLog
    @Override
    public void loadData(final String _collection, final String _document) {
        mFirebaseManager.loadDocument(_collection, _document, mLoadDocumentListener);
    }

    private final OnCompleteListener<DocumentSnapshot> mLoadDocumentListener = _task -> {
        if (_task.isSuccessful()) {
            DocumentSnapshot document = _task.getResult();
            if (document != null && document.exists()) {
                final WorkoutDataDto data = document.toObject(WorkoutDataDto.class);
//                final List<BaseDataHolder> list = createListData(data);
                Log.d("OnCompleteListener", data.toString());
                mPresenter.dataLoaded(null);
            } else {
                mPresenter.dataLoaded(null);
                Log.d("OnCompleteListener", "document not exist");
            }
        } else {
            mPresenter.loadDataFailed(_task.getException());
            Log.d("OnCompleteListener", _task.getException().getMessage());
        }
    };
}
