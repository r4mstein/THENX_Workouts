package r4mstein.ua.thenxworkouts.auth.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import hugo.weaving.DebugLog;
import r4mstein.ua.thenxworkouts.R;
import r4mstein.ua.thenxworkouts.auth.AuthData;
import r4mstein.ua.thenxworkouts.auth.navigator.IAuthNavigator;
import r4mstein.ua.thenxworkouts.root.base.BaseFragment;
import r4mstein.ua.thenxworkouts.root.error.IErrorManager;

/**
 * Created by Alex Shtain on 01.03.2018.
 */

public final class LoginFragment extends BaseFragment<IAuthNavigator, ILoginContract.Model>
        implements ILoginContract.Presenter {

    @BindView(R.id.etEmail_AL)
    EditText etEmail;
    @BindView(R.id.etPassword_AL)
    EditText etPassword;
    @BindView(R.id.btnLogin_AL)
    Button btnLogin;
    @BindView(R.id.tvRegister_AL)
    TextView tvRegister;

    @DebugLog
    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @DebugLog
    @Override
    protected void init() {
        mObjectGraph.getAuthComponent().inject(this);
    }

    @DebugLog
    @Nullable
    @Override
    public View onCreateView(final LayoutInflater _inflater, @Nullable final ViewGroup _container, @Nullable final Bundle _savedInstanceState) {
        final View view = _inflater.inflate(R.layout.auth_login, _container, false);
        bindView(this, view);
        return view;
    }

    @DebugLog
    @OnClick(R.id.btnLogin_AL)
    final void onClickLogin() {
        final AuthData authData = createData(etEmail.getText().toString(), etPassword.getText().toString());
        if (authData != null) {
            showLoader();
            mModel.login(authData);
        }
    }

    @DebugLog
    private AuthData createData(final String _email, final String _pass) {
        if (TextUtils.isEmpty(_email) || TextUtils.isEmpty(_pass)) {
            showErrorMessage(IErrorManager.Type.WARNING, "Login", getString(R.string.warning_empty_fields));
            return null;
        } else {
            return new AuthData(_email, _pass);
        }
    }

    @DebugLog
    @OnClick(R.id.tvRegister_AL)
    final void onClickRegister() {
        mNavigator.showRegister();
    }

    @DebugLog
    @Override
    public void loginSuccess() {
        removeLoader();
        mNavigator.openHome();
    }

    @DebugLog
    @Override
    public void loginFailed(final Exception _e) {
        removeLoader();
        showErrorMessage(IErrorManager.Type.ERROR, "Login", _e.getMessage());
    }
}
