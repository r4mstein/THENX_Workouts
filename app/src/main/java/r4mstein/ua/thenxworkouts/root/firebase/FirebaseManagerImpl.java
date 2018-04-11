package r4mstein.ua.thenxworkouts.root.firebase;

import android.net.Uri;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import hugo.weaving.DebugLog;
import r4mstein.ua.thenxworkouts.auth.AuthData;

/**
 * Created by Alex Shtain on 01.03.2018.
 */

public final class FirebaseManagerImpl implements IFirebaseManager {

    private final static long BUFFER_SIZE = 1024 * 1024 * 5;

    private final FirebaseAuth mAuth;
    private final FirebaseStorage mStorage;
    private final FirebaseFirestore mFirestore;

    public FirebaseManagerImpl() {
        mAuth = FirebaseAuth.getInstance();
        mStorage = FirebaseStorage.getInstance();
        mFirestore = FirebaseFirestore.getInstance();
//        FirebaseFirestore.setLoggingEnabled(true);
    }

    @DebugLog
    @Override
    public final FirebaseUser getCurrentUser() {
        return mAuth.getCurrentUser();
    }

    // auth region

    @DebugLog
    @Override
    public final boolean isUserLogged() {
        return getCurrentUser() != null;
    }

    @DebugLog
    @Override
    public final void register(final AuthData _data, final OnCompleteListener<AuthResult> _listener) {
        mAuth.createUserWithEmailAndPassword(_data.getEmail(), _data.getPass()).addOnCompleteListener(_listener);
    }

    @DebugLog
    @Override
    public final void login(final AuthData _data, final OnCompleteListener<AuthResult> _listener) {
        mAuth.signInWithEmailAndPassword(_data.getEmail(), _data.getPass()).addOnCompleteListener(_listener);
    }

    @DebugLog
    @Override
    public final void logout() {
        mAuth.signOut();
    }
    // end region

    // storage region

    @DebugLog
    @Override
    public final StorageReference getStorageReference() {
        return mStorage.getReference();
    }

    @DebugLog
    @Override
    public final void loadFile(final String _url, final OnSuccessListener<byte[]> _successListener,
                               final OnFailureListener _failureListener) {
        final StorageReference reference = getStorageReference().child(_url);
        reference.getBytes(BUFFER_SIZE)
                .addOnSuccessListener(_successListener)
                .addOnFailureListener(_failureListener);
    }

    @DebugLog
    @Override
    public final void getFileUrl(final String _url, final OnSuccessListener<Uri> _successListener,
                                 final OnFailureListener _failureListener) {
        getStorageReference().child(_url).getDownloadUrl()
                .addOnSuccessListener(_successListener)
                .addOnFailureListener(_failureListener);
    }
    // end region

    // fire store region
    @DebugLog
    @Override
    public final void loadDocument(final String _collection, final String _document,
                                   final OnCompleteListener<DocumentSnapshot> _completeListener) {
        final DocumentReference reference = mFirestore.collection(_collection).document(_document);
        reference.get().addOnCompleteListener(_completeListener);
    }

    // end region
}
