package r4mstein.ua.thenxworkouts.root.dialogs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import r4mstein.ua.thenxworkouts.R;

/**
 * Created by Alex Shtain on 26.03.2018.
 */

public final class DialogLoader extends DialogFragment {

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater _inflater, @Nullable final ViewGroup _container, @Nullable final Bundle _savedInstanceState) {
        return _inflater.inflate(R.layout.dialog_loader, _container);
    }
}
