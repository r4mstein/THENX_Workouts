package r4mstein.ua.thenxworkouts.root.dialog_shower;

import android.support.v4.app.FragmentManager;

/**
 * Created by Alex Shtain on 26.03.2018.
 */

public interface IDialogShower {
    void showLoader(FragmentManager _manager);
    void removeLoader(FragmentManager _manager);
}
