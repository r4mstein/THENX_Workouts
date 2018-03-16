package r4mstein.ua.thenxworkouts.home.workout.adapter.view_holder;

import android.view.View;
import android.widget.TextView;

import r4mstein.ua.thenxworkouts.R;
import r4mstein.ua.thenxworkouts.home.workout.adapter.data_holder.HeaderDH;
import r4mstein.ua.thenxworkouts.root.base.BaseViewHolder;

/**
 * Created by Alex Shtain on 16.03.2018.
 */

public final class HeaderVH extends BaseViewHolder<HeaderDH> {

    private final TextView tvHeader;

    public HeaderVH(final View _view) {
        super(_view);
        tvHeader = _view.findViewById(R.id.tvHeader_WHI);
    }

    @Override
    public void setData(final HeaderDH _data) {
        tvHeader.setText(_data.getData().getHeader());
    }
}
