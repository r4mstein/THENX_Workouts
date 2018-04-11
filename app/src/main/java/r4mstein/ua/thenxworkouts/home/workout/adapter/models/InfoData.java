package r4mstein.ua.thenxworkouts.home.workout.adapter.models;

/**
 * Created by Alex Shtain on 16.03.2018.
 */

public final class InfoData {
    private String mPart;
    private String mDay;
    private String mName;

    public InfoData(final String _part, final String _day, final String _name) {
        mPart = _part;
        mDay = _day;
        mName = _name;
    }

    public String getPart() {
        return mPart;
    }

    public String getDay() {
        return mDay;
    }

    public String getName() {
        return mName;
    }

    @Override
    public String toString() {
        return "InfoData{" +
                "Part='" + mPart + '\'' +
                ", Day='" + mDay + '\'' +
                ", Name='" + mName + '\'' +
                '}';
    }
}
