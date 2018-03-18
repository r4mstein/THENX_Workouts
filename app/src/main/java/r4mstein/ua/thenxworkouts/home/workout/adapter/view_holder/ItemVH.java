package r4mstein.ua.thenxworkouts.home.workout.adapter.view_holder;

import android.view.View;
import android.widget.TextView;

import cn.jzvd.JZVideoPlayerStandard;
import r4mstein.ua.thenxworkouts.R;
import r4mstein.ua.thenxworkouts.home.workout.adapter.data_holder.ItemDH;
import r4mstein.ua.thenxworkouts.root.base.BaseViewHolder;
import r4mstein.ua.thenxworkouts.root.player.VideoPlayer;

/**
 * Created by Alex Shtain on 16.03.2018.
 */

public final class ItemVH extends BaseViewHolder<ItemDH> {

    private final TextView tvNumber;
    private final TextView tvName;
    private final TextView tvRepeat;
    private final VideoPlayer vpPlayer;

    public ItemVH(final View _view) {
        super(_view);
        tvNumber = _view.findViewById(R.id.tvNumber_WI);
        tvName = _view.findViewById(R.id.tvName_WI);
        tvRepeat = _view.findViewById(R.id.tvRepeat_WI);
        vpPlayer = _view.findViewById(R.id.vpPlayer_WI);
    }

    @Override
    public void setData(final ItemDH _data) {
        tvNumber.setText(_data.getData().getNumber());
        tvName.setText(_data.getData().getName());
        if (_data.getData().getRepeat().equals("0")) tvRepeat.setText(String.format("Time: %s sec", _data.getData().getTime()));
        else tvRepeat.setText(String.format("Repetition: %s", _data.getData().getRepeat()));
        setupPlayer(_data.getData().getPlayerLink());
    }

    private void setupPlayer(final String _link) {
        vpPlayer.batteryLevel.setVisibility(View.GONE);
        vpPlayer.setUp(_link, JZVideoPlayerStandard.SCREEN_WINDOW_LIST, "");
        vpPlayer.thumbImageView.setImageResource(R.drawable.main_logo_);
    }
}
