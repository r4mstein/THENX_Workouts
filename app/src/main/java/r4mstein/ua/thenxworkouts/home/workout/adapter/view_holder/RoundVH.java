package r4mstein.ua.thenxworkouts.home.workout.adapter.view_holder;

import android.view.View;
import android.widget.TextView;

import r4mstein.ua.thenxworkouts.R;
import r4mstein.ua.thenxworkouts.home.workout.adapter.data_holder.RoundDH;
import r4mstein.ua.thenxworkouts.root.base.BaseViewHolder;

/**
 * Created by Alex Shtain on 16.03.2018.
 */

public final class RoundVH extends BaseViewHolder<RoundDH> {

    private TextView tvHeader;
    private TextView tvRepeat;

    public RoundVH(final View _view) {
        super(_view);
        tvHeader = _view.findViewById(R.id.tvHeader_WHI);
        tvRepeat = _view.findViewById(R.id.tvRepeat_WHI);
    }

    @Override
    public void setData(final RoundDH _data) {
        if (_data.getData().isRound()) {
            tvHeader.setText(_data.getData().getHeader());
            tvRepeat.setText(String.format("Repeat round %s times", _data.getData().getRepeat()));
        } else {
            tvHeader.setVisibility(View.GONE);
            tvRepeat.setText(String.format("Repeat warm up %s times", _data.getData().getRepeat()));
        }
    }
}
