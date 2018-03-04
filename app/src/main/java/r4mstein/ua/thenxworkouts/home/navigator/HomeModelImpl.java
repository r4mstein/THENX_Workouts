package r4mstein.ua.thenxworkouts.home.navigator;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;

import javax.inject.Inject;

import hugo.weaving.DebugLog;
import r4mstein.ua.thenxworkouts.root.base.BaseModel;
import r4mstein.ua.thenxworkouts.root.firebase.IFirebaseManager;

/**
 * Created by Alex Shtain on 02.03.2018.
 */

public final class HomeModelImpl extends BaseModel<IHomeContract.Presenter> implements IHomeContract.Model {

    private static final String TAG = "HomeModelImpl";
    private final IFirebaseManager mFirebaseManager;

    @Inject
    public HomeModelImpl(final IFirebaseManager _firebaseManager) {
        mFirebaseManager = _firebaseManager;
    }

    @DebugLog
    @Override
    public void logout() {
        mFirebaseManager.logout();
    }

    @DebugLog
    @Override
    public void getFileUrl(final String _url) {
        mFirebaseManager.getFileUrl(_url, successListener, failureListener);
    }

    private final OnSuccessListener<Uri> successListener = new OnSuccessListener<Uri>() {
        @Override
        public void onSuccess(Uri uri) {
            mPresenter.urlLoaded(uri);
        }
    };

    private final OnFailureListener failureListener = new OnFailureListener() {
        @Override
        public void onFailure(@NonNull Exception e) {
            mPresenter.failedLoadUrl(e);
        }
    };

    ///
    @DebugLog
    @Override
    public void loadDocument(final String _collection, final String _document) {
        mFirebaseManager.loadDocument(_collection, _document, mLoadDocumentListener);
    }

    private final OnCompleteListener<DocumentSnapshot> mLoadDocumentListener = new OnCompleteListener<DocumentSnapshot>() {
        @Override
        public void onComplete(@NonNull Task<DocumentSnapshot> task) {
            if (task.isSuccessful()) {
                DocumentSnapshot document = task.getResult();
                if (document != null && document.exists()) {
                    Log.d(TAG, "DocumentSnapshot data: " + document.getData());
                } else {
                    Log.d(TAG, "No such document");
                }
            } else {
                Log.d(TAG, "get failed with ", task.getException());
            }
        }
    };
}
