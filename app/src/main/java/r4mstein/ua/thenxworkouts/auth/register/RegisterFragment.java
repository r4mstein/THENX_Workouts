package r4mstein.ua.thenxworkouts.auth.register;

import android.app.AlertDialog;
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

/**
 * Created by Alex Shtain on 01.03.2018.
 */

public final class RegisterFragment extends BaseFragment<IAuthNavigator, IRegisterContract.Model>
        implements IRegisterContract.Presenter {

    @BindView(R.id.etEmail_AR)
    EditText etEmail;
    @BindView(R.id.etPassword_AR)
    EditText etPassword;
    @BindView(R.id.etRepeatPassword_AR)
    EditText etRepeatPassword;
    @BindView(R.id.btnRegister_AR)
    Button btnRegister;
    @BindView(R.id.tvLogin_AR)
    TextView tvLogin;

    @DebugLog
    public static RegisterFragment newInstance() {
        return new RegisterFragment();
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
        final View view = _inflater.inflate(R.layout.auth_register, _container, false);
        bindView(this, view);
        return view;
    }

    @DebugLog
    @OnClick(R.id.btnRegister_AR)
    final void onClickRegister() {
        final AuthData data = createData();
        if (data != null) mModel.register(data);
    }

    @DebugLog
    @OnClick(R.id.tvLogin_AR)
    final void onClickLogin() {
        mNavigator.showLogin();
    }

    @DebugLog
    private AuthData createData() {
        if (checkFields(etEmail.getText().toString(), etPassword.getText().toString(), etRepeatPassword.getText().toString())) return null;
        else return new AuthData(etEmail.getText().toString(), etPassword.getText().toString());
    }

    @DebugLog
    private boolean checkFields(final String _email, final String _pass, final String _repeatPass) {
        if (TextUtils.isEmpty(_email) || TextUtils.isEmpty(_pass) || TextUtils.isEmpty(_repeatPass)) {
            showDialog(getString(R.string.register_fields_warning_message));
            return true;
        }
        if (!_pass.equals(_repeatPass)) {
            showDialog(getString(R.string.register_pass_warning_message));
            return true;
        }
        return false;
    }

    private void showDialog(final String _message) {
        // TODO: 01.03.2018
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Warning")
                .setMessage(_message)
                .setPositiveButton("Ok", (dialog, which) -> dialog.dismiss())
                .show();
    }

    @DebugLog
    @Override
    public void registered() {
        mNavigator.openHome();
    }

    @DebugLog
    @Override
    public void failedRegister(final Exception _e) {
        showDialog(_e.getMessage());
    }
}
