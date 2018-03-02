package r4mstein.ua.thenxworkouts.home.navigator;

import android.net.Uri;
import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

import javax.inject.Inject;

import hugo.weaving.DebugLog;
import r4mstein.ua.thenxworkouts.root.base.BaseModel;
import r4mstein.ua.thenxworkouts.root.firebase.IFirebaseManager;

/**
 * Created by Alex Shtain on 02.03.2018.
 */

public final class HomeModelImpl extends BaseModel<IHomeContract.Presenter> implements IHomeContract.Model {

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
}
