package r4mstein.ua.thenxworkouts.home;

import java.io.Serializable;

/**
 * Created by Alex Shtain on 13.03.2018.
 */

public final class WorkoutData implements Serializable {
    private String mLevel;
    private String mPart;
    private String mDay;
    private String mWorkoutName;

    public WorkoutData(final String _level, final String _part, final String _day, final String _workoutName) {
        mLevel = _level;
        mPart = _part;
        mDay = _day;
        mWorkoutName = _workoutName;
    }

    public String getLevel() {
        return mLevel;
    }

    public String getPart() {
        return mPart;
    }

    public String getDay() {
        return mDay;
    }

    public String getWorkoutName() {
        return mWorkoutName;
    }

    @Override
    public String toString() {
        return "WorkoutData{" +
                "Level='" + mLevel + '\'' +
                ", Part='" + mPart + '\'' +
                ", Day='" + mDay + '\'' +
                ", WorkoutName='" + mWorkoutName + '\'' +
                '}';
    }
}
