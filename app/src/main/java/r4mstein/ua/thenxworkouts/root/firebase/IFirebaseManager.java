package r4mstein.ua.thenxworkouts.root.firebase;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;

import r4mstein.ua.thenxworkouts.auth.register.RegisterData;

/**
 * Created by Alex Shtain on 01.03.2018.
 */

public interface IFirebaseManager {
    FirebaseUser getCurrentUser();
    void register(RegisterData _data, OnCompleteListener<AuthResult> _listener);
    void logout();
}
