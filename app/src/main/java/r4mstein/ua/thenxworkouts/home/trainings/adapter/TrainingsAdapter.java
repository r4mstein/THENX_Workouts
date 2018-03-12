package r4mstein.ua.thenxworkouts.home.trainings.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import r4mstein.ua.thenxworkouts.R;
import r4mstein.ua.thenxworkouts.home.trainings.TrainingsData;
import r4mstein.ua.thenxworkouts.home.trainings.adapter.data_holder.ChildDataHolder;
import r4mstein.ua.thenxworkouts.home.trainings.adapter.data_holder.HeaderDataHolder;
import r4mstein.ua.thenxworkouts.root.base.BaseDataHolder;
import r4mstein.ua.thenxworkouts.root.base.BaseViewHolder;

import static r4mstein.ua.thenxworkouts.home.trainings.Constants.AdapterKey.CHILD_TYPE;
import static r4mstein.ua.thenxworkouts.home.trainings.Constants.AdapterKey.HEADER_TYPE;

/**
 * Created by Alex Shtain on 10.03.2018.
 */

public final class TrainingsAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private static final int ITEM_COUNT = 7;

    private final List<BaseDataHolder> mData = new ArrayList<>();
    private TrainingsData mChilds;
    private ClickListener mClickListener;

    public TrainingsAdapter() {

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
            case HEADER_TYPE:
                viewHolder = new HeaderVH(inflater.inflate(R.layout.trainings_header_item, _parent, false));
                break;
            case CHILD_TYPE:
                viewHolder = new ChildVH(inflater.inflate(R.layout.trainings_child_item, _parent, false));
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final BaseViewHolder _holder, final int _position) {
        switch (_holder.getItemViewType()) {
            case HEADER_TYPE:
                ((HeaderVH) _holder).setData((HeaderDataHolder) mData.get(_position));
                ((HeaderVH) _holder).itemView.setOnClickListener(v -> headerClicked((HeaderVH) _holder, _holder.getAdapterPosition()));
                break;
            case CHILD_TYPE:
                ((ChildVH) _holder).setData((ChildDataHolder) mData.get(_position));
                ((ChildVH) _holder).itemView.setOnClickListener(v -> childClicked((ChildVH) _holder));
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    private void childClicked(final ChildVH _holder) {
        mClickListener.childClicked(_holder.tvDay.getText().toString());
    }

    private void headerClicked(final HeaderVH _holder, final int _position) {
        if (((HeaderDataHolder)mData.get(_position)).getHeaderData().isExpanded()) {
            ((HeaderDataHolder) mData.get(_position)).getHeaderData().setIconId(R.drawable.ic_arrow_down);
            _holder.setIcon(((HeaderDataHolder) mData.get(_position)));
            removeItems(_position);
        } else {
            ((HeaderDataHolder) mData.get(_position)).getHeaderData().setIconId(R.drawable.ic_arrow_up);
            _holder.setIcon(((HeaderDataHolder) mData.get(_position)));
            addItems(((HeaderDataHolder)mData.get(_position)).getHeaderData().getId(), _position);
        }
    }

    private void addItems(final int _headerId, final int _position) {
        final TrainingsData.Part part = mChilds.getParts().get(_headerId - 1);
        mData.add(_position + 1, new ChildDataHolder(new ChildData("Day " + 1, part.getDay1())));
        mData.add(_position + 2, new ChildDataHolder(new ChildData("Day " + 2, part.getDay2())));
        mData.add(_position + 3, new ChildDataHolder(new ChildData("Day " + 3, part.getDay3())));
        mData.add(_position + 4, new ChildDataHolder(new ChildData("Day " + 4, part.getDay4())));
        mData.add(_position + 5, new ChildDataHolder(new ChildData("Day " + 5, part.getDay5())));
        mData.add(_position + 6, new ChildDataHolder(new ChildData("Day " + 6, part.getDay6())));
        mData.add(_position + 7, new ChildDataHolder(new ChildData("Day " + 7, part.getDay7())));

        ((HeaderDataHolder) mData.get(_position)).getHeaderData().setExpanded(true);
        notifyItemRangeInserted(_position + 1, ITEM_COUNT);
    }

    private void removeItems(final int _position) {
        for (int i = 0; i < ITEM_COUNT; i++) {
            mData.remove(_position + 1);
        }

        ((HeaderDataHolder) mData.get(_position)).getHeaderData().setExpanded(false);
        notifyItemRangeRemoved(_position + 1, ITEM_COUNT);
    }

    public void setData(final List<BaseDataHolder> _data) {
        mData.clear();
        mData.addAll(_data);
        notifyDataSetChanged();
    }

    public void setClickListener(final ClickListener _clickListener) {
        mClickListener = _clickListener;
    }

    public void setChilds(final TrainingsData _childs) {
        mChilds = _childs;
    }

    // Header
    public final class HeaderVH extends BaseViewHolder<HeaderDataHolder> {
        private final TextView tvHeader;
        private final ImageView ivArrow;

        HeaderVH(final View _view) {
            super(_view);
            tvHeader = _view.findViewById(R.id.tvHeader_THI);
            ivArrow = _view.findViewById(R.id.ivArrow_THI);
        }

        @Override
        public void setData(final HeaderDataHolder _data) {
            tvHeader.setText(_data.getHeaderData().getHeader());
            setIcon(_data);
        }

        private void setIcon(final HeaderDataHolder _data) {
            ivArrow.setImageResource(_data.getHeaderData().getIconId());
        }
    }

    // Child
    public final class ChildVH extends BaseViewHolder<ChildDataHolder> {
        private final TextView tvDay;
        private final TextView tvName;

        ChildVH(final View _view) {
            super(_view);
            tvDay = _view.findViewById(R.id.tvDay_TCI);
            tvName = _view.findViewById(R.id.tvName_TCI);
        }

        @Override
        public void setData(final ChildDataHolder _data) {
            tvDay.setText(_data.getChildData().getDay());
            tvName.setText(_data.getChildData().getTrainingName());
        }
    }
}
