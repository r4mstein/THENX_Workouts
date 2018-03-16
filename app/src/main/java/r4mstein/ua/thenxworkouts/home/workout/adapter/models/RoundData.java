package r4mstein.ua.thenxworkouts.home.workout.adapter.models;

/**
 * Created by Alex Shtain on 16.03.2018.
 */

public final class RoundData {
    private String mHeader;
    private String mRepeat;
    private boolean isRound;

    public RoundData(final String _header, final String _repeat, final boolean _isRound) {
        mHeader = _header;
        mRepeat = _repeat;
        isRound = _isRound;
    }

    public String getHeader() {
        return mHeader;
    }

    public String getRepeat() {
        return mRepeat;
    }

    public boolean isRound() {
        return isRound;
    }

    @Override
    public String toString() {
        return "RoundData{" +
                "Header='" + mHeader + '\'' +
                ", Repeat='" + mRepeat + '\'' +
                ", isRound=" + isRound +
                '}';
    }
}
