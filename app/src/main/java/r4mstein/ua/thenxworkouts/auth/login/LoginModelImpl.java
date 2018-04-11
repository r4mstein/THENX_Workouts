package r4mstein.ua.thenxworkouts.auth.login;

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

public final class LoginModelImpl extends BaseModel<ILoginContract.Presenter> implements ILoginContract.Model {

    private final IFirebaseManager mFirebaseManager;

    @Inject
    public LoginModelImpl(final IFirebaseManager _firebaseManager) {
        mFirebaseManager = _firebaseManager;
    }

    @DebugLog
    @Override
    public final void login(final AuthData _data) {
        mFirebaseManager.login(_data, mLoginListener);
    }

    private final OnCompleteListener<AuthResult> mLoginListener = _task -> {
        if (_task.isSuccessful()) mPresenter.loginSuccess();
        else mPresenter.loginFailed(_task.getException());
    };
}
