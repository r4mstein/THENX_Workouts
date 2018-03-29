package r4mstein.ua.thenxworkouts.root.base;

import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;
import hugo.weaving.DebugLog;
import r4mstein.ua.thenxworkouts.root.ObjectGraph;
import r4mstein.ua.thenxworkouts.root.dialog_shower.IDialogShower;

/**
 * Created by Alex Shtain on 27.02.2018.
 */

public abstract class BaseActivity<N extends INavigator, M extends IModel> extends AppCompatActivity
        implements INavigatorProvider<N>, IPresenter, IDialogShower.DialogListener {

    protected N mNavigator;
    @Inject
    protected M mModel;
    protected ObjectGraph mObjectGraph;
    @Inject
    protected IDialogShower mDialogShower;

    protected abstract void init();

    @Override
    public final N getNavigator() {
        return mNavigator;
    }

    @Override
    protected void onCreate(@Nullable final Bundle _savedInstanceState) {
        super.onCreate(_savedInstanceState);
        mObjectGraph = ObjectGraph.getInstance(getApplication());
        init();
    }

    @Override
    protected void onStart() {
        super.onStart();
        //noinspection unchecked
        mModel.setPresenter(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mModel.removePresenter();
    }

    protected final void bindView(final BaseActivity _activity) {
        ButterKnife.bind(_activity);
    }

    protected final void addFragment(final int _containerId, final @NonNull Fragment _fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .add(_containerId, _fragment)
                .commit();
    }

    protected final void replaceFragment(final int _containerId, final @NonNull Fragment _fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(_containerId, _fragment)
                .commit();
    }

    protected final void replaceFragmentAndAddToBackStack(final int _containerId, final @NonNull Fragment _fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(_containerId, _fragment)
                .addToBackStack(null)
                .commit();
    }

    /**
     * Called when one of dialog's button was clicked. Override to add custom behavior.
     * @param _button which button clicked
     * @param _code which dialog was showed
     */
    @CallSuper
    @DebugLog
    @Override
    public void onDialogClick(final IDialogShower.DialogButton _button, final int _code) {

    }
}
