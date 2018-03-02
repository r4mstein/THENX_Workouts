package r4mstein.ua.thenxworkouts.home.navigator;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import cn.jzvd.JZVideoPlayer;
import cn.jzvd.JZVideoPlayerStandard;
import hugo.weaving.DebugLog;
import r4mstein.ua.thenxworkouts.R;
import r4mstein.ua.thenxworkouts.root.base.BaseActivity;
import r4mstein.ua.thenxworkouts.root.navigator.IRootNavigator;
import r4mstein.ua.thenxworkouts.root.player.VideoPlayer;

public class HomeActivity extends BaseActivity<IHomeNavigator, IHomeContract.Model>
        implements IHomeContract.Presenter, IHomeNavigator {

    @BindView(R.id.psPlayer)
    VideoPlayer psPlayer;
    @BindView(R.id.ivPlayerCover)
    ImageView ivPlayerCover;

    @Inject
    IRootNavigator mRootNavigator;

    @DebugLog
    @Override
    protected void init() {
        mNavigator = this;
        mObjectGraph.getHomeComponent().inject(this);
    }

    @DebugLog
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindView(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        JZVideoPlayer.releaseAllVideos();
    }

    @DebugLog
    @OnClick(R.id.tvLogout)
    final void onClickLogout() {
        mModel.logout();
        mRootNavigator.openAuth(this);
        finish();
    }

    @DebugLog
    @OnClick(R.id.ivPlayerCover)
    final void onClickCover() {
        mModel.getFileUrl("trainings/begginer/week_1/day_1/Push Ups .mp4");
    }

    @Override
    public void urlLoaded(Uri uri) {
        ivPlayerCover.setVisibility(View.GONE);
        psPlayer.batteryLevel.setVisibility(View.GONE);
        psPlayer.setUp(/*"gs://thenx-workouts.appspot.com/trainings/begginer/week_1/day_1/Push Ups .mp4"*/
                /*"https://firebasestorage.googleapis.com/v0/b/thenx-workouts.appspot.com/o/trainings%2Fbegginer%2Fweek_1%2Fday_1%2FPush%20Ups%20.mp4?alt=media&token=639846b9-a828-4d6c-8c41-ec7a2977fb8a",*/
                uri.toString(), JZVideoPlayerStandard.SCREEN_WINDOW_NORMAL, "");
        psPlayer.thumbImageView.setImageResource(R.drawable.main_logo_);
        psPlayer.startButton.performClick();
    }

    @Override
    public void failedLoadUrl(Exception e) {
        Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
    }
}
