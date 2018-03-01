package r4mstein.ua.thenxworkouts.root.firebase;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import hugo.weaving.DebugLog;
import r4mstein.ua.thenxworkouts.auth.register.RegisterData;

/**
 * Created by Alex Shtain on 01.03.2018.
 */

public final class FirebaseManagerImpl implements IFirebaseManager {

    private final FirebaseAuth mAuth;

    public FirebaseManagerImpl() {
        mAuth = FirebaseAuth.getInstance();
    }

    @DebugLog
    @Override
    public FirebaseUser getCurrentUser() {
        return mAuth.getCurrentUser();
    }

    @DebugLog
    @Override
    public void register(final RegisterData _data, final OnCompleteListener<AuthResult> _listener) {
        mAuth.createUserWithEmailAndPassword(_data.getEmail(), _data.getPass()).addOnCompleteListener(_listener);
    }

    @DebugLog
    @Override
    public void logout() {
        mAuth.signOut();
    }
}
