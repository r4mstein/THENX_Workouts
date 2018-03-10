package r4mstein.ua.thenxworkouts.auth.register;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.AuthResult;

import javax.inject.Inject;

import hugo.weaving.DebugLog;
import r4mstein.ua.thenxworkouts.auth.AuthData;
import r4mstein.ua.thenxworkouts.root.base.BaseModel;
import r4mstein.ua.thenxworkouts.root.firebase.IFirebaseManager;

/**
 * Created by Alex Shtain on 01.03.2018.
 */

public final class RegisterModelImpl extends BaseModel<IRegisterContract.Presenter> implements IRegisterContract.Model {

    private final IFirebaseManager mFirebaseManager;

    @Inject
    public RegisterModelImpl(final IFirebaseManager _firebaseManager) {
        mFirebaseManager = _firebaseManager;
    }

    @DebugLog
    @Override
    public void register(final AuthData _data) {
        mFirebaseManager.register(_data, mRegisterListener);
    }

    private final OnCompleteListener<AuthResult> mRegisterListener = _task -> {
        if (_task.isSuccessful()) mPresenter.registered();
        else mPresenter.failedRegister(_task.getException());
    };
}
