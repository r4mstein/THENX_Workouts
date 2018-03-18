package r4mstein.ua.thenxworkouts.home.trainings;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import hugo.weaving.DebugLog;
import r4mstein.ua.thenxworkouts.R;
import r4mstein.ua.thenxworkouts.home.WorkoutData;
import r4mstein.ua.thenxworkouts.home.navigator.IHomeNavigator;
import r4mstein.ua.thenxworkouts.home.trainings.adapter.ClickListener;
import r4mstein.ua.thenxworkouts.home.trainings.adapter.TrainingsAdapter;
import r4mstein.ua.thenxworkouts.root.base.BaseDataHolder;
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
    private String mToolbarTitle;
    private String mPart;
    private TrainingsAdapter mAdapter;

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
        setupToolbar();
        setupList();
        return view;
    }

    @DebugLog
    @Override
    public void onViewCreated(final View _view, @Nullable final Bundle _savedInstanceState) {
        super.onViewCreated(_view, _savedInstanceState);
        mModel.loadData(mLevel, "namesOfTrainings");
    }

    private void setupList() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new TrainingsAdapter();
        mAdapter.setClickListener(mListClickListener);
        mRecyclerView.setAdapter(mAdapter);
    }

    final ClickListener mListClickListener = new ClickListener() {
        @Override
        public void headerClicked(final String _part) {
            mPart = _part;
        }

        @Override
        public void childClicked(final String _day, final String _name) {
            if (_name.equals("Rest")) Toast.makeText(getContext(), "Day of Rest", Toast.LENGTH_SHORT).show();
            else mNavigator.showWorkoutFragment(new WorkoutData(mLevel, mPart, _day, _name));
        }
    };

    @DebugLog
    @Override
    public void dataLoaded(final List<BaseDataHolder> _list, final TrainingsDataDto _data) {
        if (_list != null) {
            mAdapter.setData(_list);
            mAdapter.setChilds(_data);
        }
    }

    @DebugLog
    @Override
    public void loadDataFailed(final Exception _e) {
        Toast.makeText(getContext(), _e.getMessage(), Toast.LENGTH_SHORT).show();
    }

    private void setupToolbar() {
        switch (mLevel) {
            case "beginer":
                mToolbarTitle = "Beginner";
                mNavigator.setToolbarTitle(mToolbarTitle);
                break;
        }
    }
}
