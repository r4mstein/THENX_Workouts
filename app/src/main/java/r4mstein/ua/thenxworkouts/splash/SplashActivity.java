package r4mstein.ua.thenxworkouts.splash;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;

import hugo.weaving.DebugLog;
import r4mstein.ua.thenxworkouts.R;
import r4mstein.ua.thenxworkouts.home.HomeActivity;
import r4mstein.ua.thenxworkouts.root.base.BaseActivity;

/**
 * Created by Alex Shtain on 27.02.2018.
 */

public final class SplashActivity extends BaseActivity<ISplashNavigator, ISplashContract.Model>
        implements ISplashContract.Presenter {

    private Handler mHandler;

    @DebugLog
    @Override
    protected void init() {
        mObjectGraph.getSplashComponent().inject(this);
    }

    @DebugLog
    @Override
    public void onCreate(@Nullable final Bundle _savedInstanceState) {
        super.onCreate(_savedInstanceState);
        setContentView(R.layout.activity_splash);
        bindView(this);
        mHandler = new Handler();
        checkConnection();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mHandler.removeCallbacksAndMessages(null);
    }

    private void checkConnection() {
        if (mModel.isConnectionAvailable()) {
            mHandler.postDelayed(() -> {
                startActivity(new Intent(SplashActivity.this, HomeActivity.class));
                finish();
            }, 1000);
        } else {
            // TODO: 27.02.2018
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Error")
                    .setMessage("No internet connection")
                    .setPositiveButton("Ok", (dialog, which) -> finish())
                    .setCancelable(false)
                    .show();
        }
    }
}
