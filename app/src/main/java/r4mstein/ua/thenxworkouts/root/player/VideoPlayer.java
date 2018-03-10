package r4mstein.ua.thenxworkouts.root.player;

import android.content.Context;
import android.util.AttributeSet;

import cn.jzvd.JZVideoPlayerStandard;

/**
 * Created by Alex Shtain on 02.03.2018.
 */

public final class VideoPlayer extends JZVideoPlayerStandard {

    public VideoPlayer(Context context) {
        super(context);
    }

    public VideoPlayer(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void setUp(String url, int screen, Object... objects) {
        super.setUp(url, screen, objects);
        fullscreenButton.setVisibility(GONE);
        totalTimeTextView.setPadding(0, 0, 46, 0);
        WIFI_TIP_DIALOG_SHOWED = true;
    }
}
