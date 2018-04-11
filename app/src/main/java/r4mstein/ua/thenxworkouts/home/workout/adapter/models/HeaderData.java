package r4mstein.ua.thenxworkouts.home.workout.adapter.models;

/**
 * Created by Alex Shtain on 16.03.2018.
 */

public final class HeaderData {
    private String mHeader;

    public HeaderData(final String _header) {
        mHeader = _header;
    }

    public String getHeader() {
        return mHeader;
    }

    @Override
    public String toString() {
        return "HeaderData{" +
                "Header='" + mHeader + '\'' +
                '}';
    }
}
