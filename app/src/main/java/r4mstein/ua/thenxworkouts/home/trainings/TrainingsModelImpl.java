package r4mstein.ua.thenxworkouts.home.trainings;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.firestore.DocumentSnapshot;

import javax.inject.Inject;

import hugo.weaving.DebugLog;
import r4mstein.ua.thenxworkouts.root.base.BaseModel;
import r4mstein.ua.thenxworkouts.root.firebase.IFirebaseManager;

/**
 * Created by Alex Shtain on 10.03.2018.
 */

public final class TrainingsModelImpl extends BaseModel<ITrainingsContract.Presenter> implements ITrainingsContract.Model {

    private final IFirebaseManager mFirebaseManager;

    @Inject
    public TrainingsModelImpl(final IFirebaseManager _firebaseManager) {
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
                mPresenter.dataLoaded(document.toObject(TrainingsData.class));
            } else {
                mPresenter.dataLoaded(null);
            }
        } else {
            mPresenter.loadDataFailed(_task.getException());
        }
    };
}
