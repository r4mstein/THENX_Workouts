package r4mstein.ua.thenxworkouts.splash;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.AlertDialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;

import javax.inject.Inject;

import butterknife.BindView;
import hugo.weaving.DebugLog;
import r4mstein.ua.thenxworkouts.R;
import r4mstein.ua.thenxworkouts.root.base.BaseActivity;
import r4mstein.ua.thenxworkouts.root.navigator.IRootNavigator;

/**
 * Created by Alex Shtain on 27.02.2018.
 */

public final class SplashActivity extends BaseActivity<ISplashNavigator, ISplashContract.Model>
        implements ISplashContract.Presenter {

    @BindView(R.id.ivLogo_AS)
    ImageView ivLogo;

    @Inject
    IRootNavigator mRootNavigator;

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
        startAnimation();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mHandler.removeCallbacksAndMessages(null);
    }

    private void checkConnection() {
        if (mModel.isConnectionAvailable()) {
            mHandler.postDelayed(() -> {
                mRootNavigator.openHome(this);
                finish();
            }, 200);
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

    private void startAnimation() {
        final ObjectAnimator animator = ObjectAnimator.ofInt(ivLogo, "alpha", 0, 40, 80, 100);
        animator.setDuration(1000)
                .setInterpolator(new AccelerateDecelerateInterpolator());
        animator.addListener(mAnimatorListener);
        animator.start();
    }

    private final Animator.AnimatorListener mAnimatorListener = new Animator.AnimatorListener() {
        @Override
        public void onAnimationStart(final Animator _animation) {

        }

        @Override
        public void onAnimationEnd(final Animator _animation) {
            checkConnection();
        }

        @Override
        public void onAnimationCancel(final Animator _animation) {

        }

        @Override
        public void onAnimationRepeat(final Animator _animation) {

        }
    };
}
