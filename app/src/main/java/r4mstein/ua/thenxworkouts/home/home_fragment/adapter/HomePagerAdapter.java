package r4mstein.ua.thenxworkouts.home.home_fragment.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

import java.util.ArrayList;
import java.util.List;

import r4mstein.ua.thenxworkouts.R;
import r4mstein.ua.thenxworkouts.root.GlideApp;

/**
 * Created by Alex Shtain on 02.04.2018.
 */
public final class HomePagerAdapter extends PagerAdapter {

    private final List<PagerData> mData = new ArrayList<>();
    private final Context mContext;
    private ItemClickListener mClickListener;

    public HomePagerAdapter(final Context _context) {
        mContext = _context;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull final View _view, @NonNull final Object _object) {
        return _view == _object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull final ViewGroup _container, final int _position) {
        final View view = LayoutInflater.from(mContext).inflate(R.layout.home_pager_item, _container, false);
        setupAndFillData(_position, view);
        view.setOnClickListener(view1 -> mClickListener.itemClicked(_position));

        _container.addView(view);
        return view;
    }

    private void setupAndFillData(final int _position, final View _view) {
        final ImageView ivPicture = _view.findViewById(R.id.ivPicture_HPI);
        final TextView tvNameLevel = _view.findViewById(R.id.tvNameLevel_HPI);
        final ImageView ivRank = _view.findViewById(R.id.ivRank_HPI);

        final PagerData data = mData.get(_position);
        tvNameLevel.setText(data.getNameLevel());
        ivRank.setImageResource(data.getRank());
        GlideApp.with(mContext)
                .load(data.getPhoto())
                .placeholder(R.drawable.ic_placeholder)
                .transition(DrawableTransitionOptions.withCrossFade(400))
                .into(ivPicture);
    }

    @Override
    public void destroyItem(@NonNull final ViewGroup _container, final int _position, @NonNull final Object _object) {
        _container.removeView((View) _object);
    }

    public void addData(List<PagerData> _data) {
        mData.clear();
        mData.addAll(_data);
    }

    public List<PagerData> getData() {
        return mData;
    }

    public void setClickListener(final ItemClickListener _clickListener) {
        mClickListener = _clickListener;
    }
}
