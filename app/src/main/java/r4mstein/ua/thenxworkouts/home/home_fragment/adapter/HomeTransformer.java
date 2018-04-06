package r4mstein.ua.thenxworkouts.home.home_fragment.adapter;

import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by Alex Shtain on 02.04.2018.
 */
public class HomeTransformer implements ViewPager.PageTransformer {

    private static final float MIN_SCALE = 0.75f;

    @Override
    public void transformPage(@NonNull final View _page, final float _position) {
        if (_position <= 0f) {
            _page.setTranslationX(0f);
            _page.setScaleX(1f);
            _page.setScaleY(1f);
        } else if (_position <= 1f) {
            final float scaleFactor = MIN_SCALE + (1 - MIN_SCALE) * (1 - Math.abs(_position));
            _page.setAlpha(1 - _position);
            _page.setPivotY(0.5f * _page.getHeight());
            _page.setTranslationX(_page.getWidth() * -_position);
            _page.setScaleX(scaleFactor);
            _page.setScaleY(scaleFactor);
        }
    }
}

