package r4mstein.ua.thenxworkouts.home.workout.adapter.view_holder;

import android.view.View;
import android.widget.TextView;

import r4mstein.ua.thenxworkouts.R;
import r4mstein.ua.thenxworkouts.home.workout.adapter.data_holder.InfoDH;
import r4mstein.ua.thenxworkouts.root.base.BaseViewHolder;

/**
 * Created by Alex Shtain on 16.03.2018.
 */

public final class InfoVH extends BaseViewHolder<InfoDH> {

    private final TextView tvPart;
    private final TextView tvDay;
    private final TextView tvName;

    public InfoVH(final View _view) {
        super(_view);
        tvPart = _view.findViewById(R.id.tvPart_WII);
        tvDay = _view.findViewById(R.id.tvDay_WII);
        tvName = _view.findViewById(R.id.tvName_WII);
    }

    @Override
    public void setData(final InfoDH _data) {
        tvPart.setText(_data.getData().getPart());
        tvDay.setText(_data.getData().getDay());
        tvName.setText(_data.getData().getName());
    }
}
