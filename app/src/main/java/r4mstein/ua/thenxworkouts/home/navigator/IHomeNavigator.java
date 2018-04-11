package r4mstein.ua.thenxworkouts.home.navigator;

import r4mstein.ua.thenxworkouts.home.WorkoutData;
import r4mstein.ua.thenxworkouts.root.base.INavigator;

/**
 * Created by Alex Shtain on 02.03.2018.
 */

public interface IHomeNavigator extends INavigator {
    void setToolbarTitle(String _title);
    void logout();
    void showHomeFragment();
    void showTrainigsFragment(String _level);
    void showWorkoutFragment(WorkoutData _data);
}
