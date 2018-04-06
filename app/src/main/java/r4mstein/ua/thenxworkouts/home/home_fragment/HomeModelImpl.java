package r4mstein.ua.thenxworkouts.home.home_fragment;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import hugo.weaving.DebugLog;
import r4mstein.ua.thenxworkouts.R;
import r4mstein.ua.thenxworkouts.home.home_fragment.adapter.PagerData;
import r4mstein.ua.thenxworkouts.root.base.BaseModel;

/**
 * Created by Alex Shtain on 02.04.2018.
 */
public final class HomeModelImpl extends BaseModel<IHomeFragment.Presenter> implements IHomeFragment.Model {

    private final Context mContext;

    @Inject
    public HomeModelImpl(final Context _context) {
        mContext = _context;
    }

    @DebugLog
    public List<PagerData> createPagerData() {
        final List<PagerData> data = new ArrayList<>();
        data.add(new PagerData(mContext.getString(R.string.home_beginner_level), Constants.Links.BG_BEGINNER, R.drawable.ic_rank_1w,
                mContext.getString(R.string.home_beginner_explanation)));
        data.add(new PagerData(mContext.getString(R.string.home_middle_level), Constants.Links.BG_MIDDLE, R.drawable.ic_rank_2w,
                mContext.getString(R.string.home_middle_explanation)));
        data.add(new PagerData(mContext.getString(R.string.home_advanced_level), Constants.Links.BG_ADVANCED, R.drawable.ic_rank,
                mContext.getString(R.string.home_advanced_explanation)));
        return data;
    }
}
