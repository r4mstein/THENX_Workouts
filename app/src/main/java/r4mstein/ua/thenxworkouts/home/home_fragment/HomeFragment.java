package r4mstein.ua.thenxworkouts.home.home_fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.OnClick;
import hugo.weaving.DebugLog;
import r4mstein.ua.thenxworkouts.R;
import r4mstein.ua.thenxworkouts.home.home_fragment.adapter.HomePagerAdapter;
import r4mstein.ua.thenxworkouts.home.home_fragment.adapter.HomeTransformer;
import r4mstein.ua.thenxworkouts.home.home_fragment.adapter.ItemClickListener;
import r4mstein.ua.thenxworkouts.home.navigator.IHomeNavigator;
import r4mstein.ua.thenxworkouts.root.base.BaseFragment;

/**
 * Created by Alex Shtain on 02.04.2018.
 */
public final class HomeFragment extends BaseFragment<IHomeNavigator, IHomeFragment.Model>
        implements IHomeFragment.Presenter {

    @BindView(R.id.vp_HF)
    ViewPager mViewPager;
    @BindView(R.id.tvText_HF)
    TextView tvText;
    @BindView(R.id.tlDots_HF)
    TabLayout tlDots;

    private HomePagerAdapter mPagerAdapter;
    private int mCurrentPosition = 0;

    @DebugLog
    public static HomeFragment newInstance() {
        final Bundle args = new Bundle();

        final HomeFragment fragment = new HomeFragment();
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
    public View onCreateView(@NonNull final LayoutInflater _inflater, @Nullable final ViewGroup _container, @Nullable final Bundle _savedInstanceState) {
        final View view = _inflater.inflate(R.layout.home_fragment, _container, false);
        bindView(this, view);
        return view;
    }

    @DebugLog
    @Override
    public void onViewCreated(@NonNull final View _view, @Nullable final Bundle _savedInstanceState) {
        super.onViewCreated(_view, _savedInstanceState);
        setupPager();
    }

    @DebugLog
    private void setupPager() {
        mViewPager.setPageTransformer(true, new HomeTransformer());
        mPagerAdapter = new HomePagerAdapter(getContext());
        mPagerAdapter.addData(mModel.createPagerData());
        mPagerAdapter.setClickListener(mPagerAdapterClickListener);
        mViewPager.setAdapter(mPagerAdapter);
        mViewPager.addOnPageChangeListener(mPageChangeListener);
        tlDots.setupWithViewPager(mViewPager, true);
    }

    private final ViewPager.SimpleOnPageChangeListener mPageChangeListener = new ViewPager.SimpleOnPageChangeListener() {
        @Override
        public void onPageSelected(final int _position) {
            if (mCurrentPosition < _position) {
                mCurrentPosition = _position;
                final Animation animIn = createAnimIn(R.anim.slide_in_left);
                final Animation animOut = createAnimOut(R.anim.slide_out_right, _position, animIn);
                tvText.startAnimation(animOut);
            } else {
                mCurrentPosition = _position;
                final Animation animIn = createAnimIn(R.anim.slide_in_right);
                final Animation animOut = createAnimOut(R.anim.slide_out_left, _position, animIn);
                tvText.startAnimation(animOut);
            }
        }
    };

    @NonNull
    private Animation createAnimOut(final int _animRes, final int _position, final Animation _animIn) {
        final Animation animOut = AnimationUtils.loadAnimation(getContext(), _animRes);
        animOut.setDuration(200);
        animOut.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(final Animation _animation) {

            }

            @Override
            public void onAnimationEnd(final Animation _animation) {
                tvText.setText(mPagerAdapter.getData().get(_position).getExplanation());
                tvText.startAnimation(_animIn);
            }

            @Override
            public void onAnimationRepeat(final Animation _animation) {

            }
        });
        return animOut;
    }

    @NonNull
    private Animation createAnimIn(final int _animRes) {
        final Animation animIn = AnimationUtils.loadAnimation(getContext(), _animRes);
        animIn.setDuration(300);
        return animIn;
    }

    private final ItemClickListener mPagerAdapterClickListener = _position -> {
        switch (_position) {
            case 0:
                mNavigator.showTrainigsFragment("beginer");
                break;
            case 1:
                Toast.makeText(getContext(), "Not implemented yet", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(getContext(), "Not implemented yet", Toast.LENGTH_SHORT).show();
                break;
        }
    };

    @DebugLog
    @OnClick(R.id.btnLogout_HF)
    final void onClickLogout() {
        mNavigator.logout();
    }
}
