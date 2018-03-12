package r4mstein.ua.thenxworkouts.home.trainings;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.firestore.DocumentSnapshot;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import hugo.weaving.DebugLog;
import r4mstein.ua.thenxworkouts.home.trainings.adapter.HeaderData;
import r4mstein.ua.thenxworkouts.home.trainings.adapter.data_holder.HeaderDataHolder;
import r4mstein.ua.thenxworkouts.root.base.BaseDataHolder;
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
                final TrainingsData data = document.toObject(TrainingsData.class);
                final List<BaseDataHolder> list = createListData(data);
                mPresenter.dataLoaded(list, data);
            } else {
                mPresenter.dataLoaded(null, null);
            }
        } else {
            mPresenter.loadDataFailed(_task.getException());
        }
    };

    private List<BaseDataHolder> createListData(TrainingsData _data) {
        final List<BaseDataHolder> list = new ArrayList<>();

        final List<TrainingsData.Part> parts = _data.getParts();
        for (int i = 0; i < parts.size(); i++) {
            list.add(new HeaderDataHolder(new HeaderData(parts.get(i).getId(), "Part " + parts.get(i).getId())));
        }
        return list;
    }
}
