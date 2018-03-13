package r4mstein.ua.thenxworkouts.home.workout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import hugo.weaving.DebugLog;
import r4mstein.ua.thenxworkouts.R;
import r4mstein.ua.thenxworkouts.home.WorkoutData;
import r4mstein.ua.thenxworkouts.home.navigator.IHomeNavigator;
import r4mstein.ua.thenxworkouts.root.base.BaseDataHolder;
import r4mstein.ua.thenxworkouts.root.base.BaseFragment;

/**
 * Created by Alex Shtain on 13.03.2018.
 */

public final class WorkoutFragment extends BaseFragment<IHomeNavigator, IWorkoutContract.Model>
        implements IWorkoutContract.Presenter {

    @BindView(R.id.tvPart_WF)
    TextView tvPart;
    @BindView(R.id.tvDay_WF)
    TextView tvDay;
    @BindView(R.id.tvName_WF)
    TextView tvName;
    @BindView(R.id.tvDescription_WF)
    TextView tvDescription;

    public static final String DATA_KEY = "data_key";

    private WorkoutData mData;

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
        mModel.loadData(mData.getLevel(), createDocumentName());
    }

    private String createDocumentName() {
        return mData.getPart().replace(" ", "") + mData.getDay().replace(" ", "");
    }

    private void setupUi() {
        tvDay.setText(mData.getDay());
        tvName.setText(mData.getWorkoutName());
        tvPart.setText(mData.getPart());
        tvDescription.setText(getString(R.string.workout_description));
    }

    @Override
    public void dataLoaded(List<BaseDataHolder> _list) {

    }

    @Override
    public void loadDataFailed(Exception _e) {

    }
}
