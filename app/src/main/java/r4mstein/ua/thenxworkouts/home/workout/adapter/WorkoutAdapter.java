package r4mstein.ua.thenxworkouts.home.workout.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import r4mstein.ua.thenxworkouts.R;
import r4mstein.ua.thenxworkouts.home.workout.adapter.data_holder.HeaderDH;
import r4mstein.ua.thenxworkouts.home.workout.adapter.data_holder.InfoDH;
import r4mstein.ua.thenxworkouts.home.workout.adapter.data_holder.ItemDH;
import r4mstein.ua.thenxworkouts.home.workout.adapter.data_holder.RoundDH;
import r4mstein.ua.thenxworkouts.home.workout.adapter.view_holder.HeaderVH;
import r4mstein.ua.thenxworkouts.home.workout.adapter.view_holder.InfoVH;
import r4mstein.ua.thenxworkouts.home.workout.adapter.view_holder.ItemVH;
import r4mstein.ua.thenxworkouts.home.workout.adapter.view_holder.RoundVH;
import r4mstein.ua.thenxworkouts.root.base.BaseDataHolder;
import r4mstein.ua.thenxworkouts.root.base.BaseViewHolder;

import static r4mstein.ua.thenxworkouts.home.workout.Constants.AdapterKey.HEADER_TYPE;
import static r4mstein.ua.thenxworkouts.home.workout.Constants.AdapterKey.INFO_TYPE;
import static r4mstein.ua.thenxworkouts.home.workout.Constants.AdapterKey.ITEM_TYPE;
import static r4mstein.ua.thenxworkouts.home.workout.Constants.AdapterKey.ROUND_TYPE;

/**
 * Created by Alex Shtain on 16.03.2018.
 */

public final class WorkoutAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private final List<BaseDataHolder> mData = new ArrayList<>();

    public WorkoutAdapter() {

    }

    @Override
    public int getItemViewType(final int _position) {
        return mData.get(_position).itemViewType();
    }

    @Override
    public BaseViewHolder onCreateViewHolder(final ViewGroup _parent, final int _viewType) {
        BaseViewHolder viewHolder = null;
        final LayoutInflater inflater = LayoutInflater.from(_parent.getContext());

        switch (_viewType) {
            case INFO_TYPE:
                viewHolder = new InfoVH(inflater.inflate(R.layout.workout_info_item, _parent, false));
                break;
            case HEADER_TYPE:
                viewHolder = new HeaderVH(inflater.inflate(R.layout.workout_header_item, _parent, false));
                break;
            case ROUND_TYPE:
                viewHolder = new RoundVH(inflater.inflate(R.layout.workout_round_item, _parent, false));
                break;
            case ITEM_TYPE:
                viewHolder = new ItemVH(inflater.inflate(R.layout.workout_item, _parent, false));
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final BaseViewHolder _holder, final int _position) {
        switch (_holder.getItemViewType()) {
            case INFO_TYPE:
                ((InfoVH) _holder).setData((InfoDH) mData.get(_position));
                break;
            case HEADER_TYPE:
                ((HeaderVH) _holder).setData((HeaderDH) mData.get(_position));
                break;
            case ROUND_TYPE:
                ((RoundVH) _holder).setData((RoundDH) mData.get(_position));
                break;
            case ITEM_TYPE:
                ((ItemVH) _holder).setData((ItemDH) mData.get(_position));
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void setData(final List<BaseDataHolder> _data) {
        mData.clear();
        mData.addAll(_data);
        notifyDataSetChanged();
    }
}
