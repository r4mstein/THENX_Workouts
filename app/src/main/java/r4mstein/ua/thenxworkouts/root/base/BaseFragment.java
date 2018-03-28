package r4mstein.ua.thenxworkouts.root.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import hugo.weaving.DebugLog;
import r4mstein.ua.thenxworkouts.root.ObjectGraph;
import r4mstein.ua.thenxworkouts.root.dialog_shower.IDialogShower;
import r4mstein.ua.thenxworkouts.root.error.IErrorManager;

/**
 * Created by Alex Shtain on 27.02.2018.
 */

public abstract class BaseFragment<N extends INavigator, M extends IModel> extends Fragment
        implements IPresenter, IDialogShower.DialogListener {

    protected N mNavigator;
    @Inject
    protected M mModel;
    protected ObjectGraph mObjectGraph;
    protected Unbinder mUnbinder;
    @Inject
    protected IDialogShower mDialogShower;
    @Inject
    protected IErrorManager mErrorManager;

    protected abstract void init();

    @Override
    public void onAttach(final Context _context) {
        super.onAttach(_context);
        //noinspection unchecked
        mNavigator = ((INavigatorProvider<N>) getActivity()).getNavigator();
        mObjectGraph = ObjectGraph.getInstance(getActivity().getApplication());
        init();
    }

    protected final void bindView(final BaseFragment _fragment, final View _view) {
        mUnbinder = ButterKnife.bind(_fragment, _view);
    }

    @CallSuper
    @Override
    public void onViewCreated(@NonNull final View _view, @Nullable final Bundle _savedInstanceState) {
        super.onViewCreated(_view, _savedInstanceState);
        //noinspection unchecked
        mModel.setPresenter(this);
    }

    @CallSuper
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
        mModel.removePresenter();
    }

    @DebugLog
    protected void showLoader() {
        mDialogShower.showLoader(getChildFragmentManager());
    }

    @DebugLog
    protected void removeLoader() {
        mDialogShower.removeLoader(getChildFragmentManager());
    }

    @DebugLog
    protected void showErrorMessage(final IErrorManager.Type _type, final String _operationName, final String _message) {
        mDialogShower.showGenericDialog(getChildFragmentManager(),
                new IDialogShower.Data()
                        .setTitle(mErrorManager.getTitle(_type))
                        .setMessage(mErrorManager.getErrorMessage(_operationName, _message)));
    }

    /**
     * See {@link BaseActivity#onDialogClick} for docs
     */
    @CallSuper
    @DebugLog
    @Override
    public void onDialogClick(final IDialogShower.DialogButton _button, final int _code) {

    }
}
