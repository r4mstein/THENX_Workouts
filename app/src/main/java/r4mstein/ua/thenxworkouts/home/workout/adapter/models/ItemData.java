package r4mstein.ua.thenxworkouts.home.workout.adapter.models;

/**
 * Created by Alex Shtain on 16.03.2018.
 */

public final class ItemData {
    private String mNumber;
    private String mName;
    private String mRepeat;
    private String mTime;
    private String mPlayerLink;

    public ItemData(final String _number, final String _name, final String _repeat, final String _time, final String _playerLink) {
        mNumber = _number;
        mName = _name;
        mRepeat = _repeat;
        mTime = _time;
        mPlayerLink = _playerLink;
    }

    public String getNumber() {
        return mNumber;
    }

    public String getName() {
        return mName;
    }

    public String getRepeat() {
        return mRepeat;
    }

    public String getTime() {
        return mTime;
    }

    public String getPlayerLink() {
        return mPlayerLink;
    }

    @Override
    public String toString() {
        return "ItemData{" +
                "Number='" + mNumber + '\'' +
                ", Name='" + mName + '\'' +
                ", Repeat='" + mRepeat + '\'' +
                ", Time='" + mTime + '\'' +
                ", PlayerLink='" + mPlayerLink + '\'' +
                '}';
    }
}
