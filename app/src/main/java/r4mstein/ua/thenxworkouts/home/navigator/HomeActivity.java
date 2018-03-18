package r4mstein.ua.thenxworkouts.home.navigator;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import javax.inject.Inject;

import butterknife.BindView;
import hugo.weaving.DebugLog;
import r4mstein.ua.thenxworkouts.R;
import r4mstein.ua.thenxworkouts.home.WorkoutData;
import r4mstein.ua.thenxworkouts.home.trainings.TrainingsFragment;
import r4mstein.ua.thenxworkouts.home.workout.WorkoutFragment;
import r4mstein.ua.thenxworkouts.root.base.BaseActivity;
import r4mstein.ua.thenxworkouts.root.navigator.IRootNavigator;

public class HomeActivity extends BaseActivity<IHomeNavigator, IHomeContract.Model>
        implements IHomeContract.Presenter, IHomeNavigator {

    @BindView(R.id.tHomeToolbar_AH)
    Toolbar mToolbar;

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
        setContentView(R.layout.activity_home);
        bindView(this);
        setupUi();
        showTrainigsFragment("beginer");
    }

    @DebugLog
    private void setupUi() {
        setToolbarTitle(getString(R.string.app_name));
        mToolbar.setNavigationIcon(R.drawable.ic_back);
        setSupportActionBar(mToolbar);
        mToolbar.setNavigationOnClickListener(v -> {
            getSupportFragmentManager().popBackStack();
            if (getSupportFragmentManager().getBackStackEntryCount() == 1) setToolbarTitle(getString(R.string.app_name));
        });
        //noinspection ConstantConditions
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportFragmentManager().addOnBackStackChangedListener(() ->
                getSupportActionBar().setDisplayHomeAsUpEnabled(getSupportFragmentManager().getBackStackEntryCount() > 0)
        );
    }

    @DebugLog
    @Override
    public final void setToolbarTitle(final String _title) {
        mToolbar.setTitle(_title);
    }

    @DebugLog
    @Override
    public final void logout() {
        mModel.logout();
        mRootNavigator.openAuth(this);
        finish();
    }

    @DebugLog
    @Override
    public void showTrainigsFragment(final String _level) {
        replaceFragmentAndAddToBackStack(getRootContainer(), TrainingsFragment.newInstance(_level));
    }

    @DebugLog
    @Override
    public void showWorkoutFragment(final WorkoutData _data) {
        replaceFragmentAndAddToBackStack(getRootContainer(), WorkoutFragment.newInstance(_data));
    }

    private int getRootContainer() {
        return R.id.flRootContainer_AM;
    }
}
