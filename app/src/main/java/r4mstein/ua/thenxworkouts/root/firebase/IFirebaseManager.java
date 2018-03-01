package r4mstein.ua.thenxworkouts.root.firebase;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;

import r4mstein.ua.thenxworkouts.auth.AuthData;

/**
 * Created by Alex Shtain on 01.03.2018.
 */

public interface IFirebaseManager {
    FirebaseUser getCurrentUser();
    boolean isUserLogged();
    void register(AuthData _data, OnCompleteListener<AuthResult> _listener);
    void login(AuthData _data, OnCompleteListener<AuthResult> _listener);
    void logout();
}
