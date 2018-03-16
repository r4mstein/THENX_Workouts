package r4mstein.ua.thenxworkouts.home.workout;

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
import r4mstein.ua.thenxworkouts.home.workout.adapter.WorkoutAdapter;
import r4mstein.ua.thenxworkouts.root.base.BaseDataHolder;
import r4mstein.ua.thenxworkouts.root.base.BaseFragment;

/**
 * Created by Alex Shtain on 13.03.2018.
 */

public final class WorkoutFragment extends BaseFragment<IHomeNavigator, IWorkoutContract.Model>
        implements IWorkoutContract.Presenter {

    @BindView(R.id.rv_WF)
    RecyclerView mRecyclerView;

    public static final String DATA_KEY = "data_key";

    private WorkoutData mData;
    private WorkoutAdapter mAdapter;

    @DebugLog
    public static WorkoutFragment newInstance(final WorkoutData _data) {
        final Bundle args = new Bundle();
        args.putSerializable(DATA_KEY, _data);
        final WorkoutFragment fragment = new WorkoutFragment();
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
        final View view = _inflater.inflate(R.layout.workout_fragment, _container, false);
        if (getArguments() != null && getArguments().containsKey(DATA_KEY)) mData = (WorkoutData) getArguments().getSerializable(DATA_KEY);
        bindView(this, view);
        setupUi();
        return view;
    }

    @Override
    public void onViewCreated(final View _view, @Nullable final Bundle _savedInstanceState) {
        super.onViewCreated(_view, _savedInstanceState);
        mModel.loadData(mData);
    }

    private void setupUi() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new WorkoutAdapter();
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void dataLoaded(List<BaseDataHolder> _list) {
        if (_list != null) mAdapter.setData(_list);
    }

    @Override
    public void loadDataFailed(Exception _e) {
        Toast.makeText(getContext(), _e.getMessage(), Toast.LENGTH_SHORT).show();
    }
}
