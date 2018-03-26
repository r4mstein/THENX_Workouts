package r4mstein.ua.thenxworkouts.root.dialog_shower;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import hugo.weaving.DebugLog;
import r4mstein.ua.thenxworkouts.R;
import r4mstein.ua.thenxworkouts.root.dialogs.DialogGeneric;
import r4mstein.ua.thenxworkouts.root.dialogs.DialogLoader;

/**
 * Created by Alex Shtain on 26.03.2018.
 */

public final class DialogShowerImpl implements IDialogShower {

    private static final String TAG_LOADER = "tag_loader";
    private FragmentManager mManager;
    private boolean isLoaderRunning = false;

    @DebugLog
    @Override
    public void showGenericDialog(final FragmentManager _manager, final Data _data) {
        final Bundle bundle = new Bundle();
        bundle.putSerializable(KEY_DATA, _data);

        final DialogGeneric dialog = new DialogGeneric();
        dialog.setCancelable(_data.isCancelable());
        dialog.setArguments(bundle);
        dialog.show(_manager, null);
    }

    @DebugLog
    @Override
    public void showLoader(final FragmentManager _manager) {
        mManager = _manager;
        isLoaderRunning = true;
        final DialogLoader loader = new DialogLoader();
        loader.setCancelable(false);
        loader.setStyle(DialogFragment.STYLE_NORMAL, R.style.DialogLoader);
        loader.show(mManager, TAG_LOADER);
    }

    @DebugLog
    @Override
    public void removeLoader(final FragmentManager _manager) {
        if (isLoaderRunning) {
            isLoaderRunning = false;
            final Fragment fragment = _manager.findFragmentByTag(TAG_LOADER);
            if (fragment != null) ((DialogLoader) fragment).dismiss();
            mManager = null;
        }
    }
}
