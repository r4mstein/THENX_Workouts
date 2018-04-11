package r4mstein.ua.thenxworkouts.root.firebase;

import android.net.Uri;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.storage.StorageReference;

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
    StorageReference getStorageReference();
    void loadFile(String _url, OnSuccessListener<byte[]> _successListener, OnFailureListener _failureListener);
    void getFileUrl(String _url, OnSuccessListener<Uri> _successListener, OnFailureListener _failureListener);
    void loadDocument(String _collection, String _document, OnCompleteListener<DocumentSnapshot> _completeListener);
}
