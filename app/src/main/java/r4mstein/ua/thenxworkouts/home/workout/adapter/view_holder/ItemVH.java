package r4mstein.ua.thenxworkouts.home.workout.adapter.view_holder;

import android.view.View;
import android.widget.RelativeLayout;
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

    private final RelativeLayout rlChallengeRepeat;
    private final TextView tvChallHeader;
    private final TextView tvLow;
    private final TextView tvMiddle;
    private final TextView tvHigh;

    public ItemVH(final View _view) {
        super(_view);
        tvNumber = _view.findViewById(R.id.tvNumber_WI);
        tvName = _view.findViewById(R.id.tvName_WI);
        tvRepeat = _view.findViewById(R.id.tvRepeat_WI);
        vpPlayer = _view.findViewById(R.id.vpPlayer_WI);

        rlChallengeRepeat = _view.findViewById(R.id.rlChallengeRepeat_WI);
        tvChallHeader = _view.findViewById(R.id.tvChallHeader_WI);
        tvLow = _view.findViewById(R.id.tvLow_WI);
        tvMiddle = _view.findViewById(R.id.tvMiddle_WI);
        tvHigh = _view.findViewById(R.id.tvHigh_WI);
    }

    @Override
    public void setData(final ItemDH _data) {
        tvNumber.setText(_data.getData().getNumber());
        tvName.setText(_data.getData().getName());

        if (_data.getData().getChallengeRepeat() != null) fillRepeatIfChallenge(_data);
        else fillRepeat(_data);
        setupPlayer(_data.getData().getPlayerLink());
    }

    private void fillRepeat(final ItemDH _data) {
        tvRepeat.setVisibility(View.VISIBLE);
        rlChallengeRepeat.setVisibility(View.GONE);

        if (_data.getData().getRepeat().equals("0")) {
            if (_data.getData().getTime().equals("-1")) tvRepeat.setText(R.string.max_time);
            else tvRepeat.setText(String.format("Time: %s sec", _data.getData().getTime()));
        } else {
            if (_data.getData().getRepeat().equals("-1")) tvRepeat.setText(R.string.max_repetition);
            else tvRepeat.setText(String.format("Repetition: %s", _data.getData().getRepeat()));
        }
    }

    private void fillRepeatIfChallenge(final ItemDH _data) {
        tvRepeat.setVisibility(View.GONE);
        rlChallengeRepeat.setVisibility(View.VISIBLE);

        String[] data = _data.getData().getChallengeRepeat().split(",");
        tvLow.setText(data[0]);
        tvMiddle.setText(data[1]);
        tvHigh.setText(data[2]);

        if (data[0].endsWith("s")) tvChallHeader.setText(R.string.time);
        else tvChallHeader.setText(R.string.repetition);
    }

    private void setupPlayer(final String _link) {
        vpPlayer.batteryLevel.setVisibility(View.GONE);
        vpPlayer.setUp(_link, JZVideoPlayerStandard.SCREEN_WINDOW_LIST, "");
        vpPlayer.thumbImageView.setImageResource(R.drawable.main_logo_);
    }
}
