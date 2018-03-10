package r4mstein.ua.thenxworkouts.home.trainings;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import hugo.weaving.DebugLog;
import r4mstein.ua.thenxworkouts.R;
import r4mstein.ua.thenxworkouts.home.navigator.IHomeNavigator;
import r4mstein.ua.thenxworkouts.root.base.BaseFragment;

/**
 * Created by Alex Shtain on 10.03.2018.
 */

public final class TrainingsFragment extends BaseFragment<IHomeNavigator, ITrainingsContract.Model>
        implements ITrainingsContract.Presenter {

    @BindView(R.id.rv_TF)
    RecyclerView mRecyclerView;

    private static final String LEVEL = "level";

    private String mLevel;

    @DebugLog
    public static TrainingsFragment newInstance(final String _level) {
        final Bundle args = new Bundle();
        args.putString(LEVEL, _level);
        final TrainingsFragment fragment = new TrainingsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @DebugLog
    @Override
    protected void init() {
        mObjectGraph.getHomeComponent().inject(this);
    }

    @DebugLog
    @Nullable
    @Override
    public View onCreateView(final LayoutInflater _inflater, @Nullable final ViewGroup _container, @Nullable final Bundle _savedInstanceState) {
        final View view = _inflater.inflate(R.layout.trainings_fragment, _container, false);
        if (getArguments() != null && getArguments().containsKey(LEVEL)) mLevel = getArguments().getString(LEVEL);
        bindView(this, view);
        return view;
    }

    @DebugLog
    @Override
    public void onViewCreated(final View _view, @Nullable final Bundle _savedInstanceState) {
        super.onViewCreated(_view, _savedInstanceState);
        mModel.loadData(mLevel, "namesOfTrainings");
    }

    @DebugLog
    @Override
    public void dataLoaded(final TrainingsData _data) {

    }

    @DebugLog
    @Override
    public void loadDataFailed(final Exception _e) {

    }
}
