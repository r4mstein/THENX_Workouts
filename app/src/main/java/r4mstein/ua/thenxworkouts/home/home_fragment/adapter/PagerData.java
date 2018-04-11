package r4mstein.ua.thenxworkouts.home.home_fragment.adapter;

/**
 * Created by Alex Shtain on 02.04.2018.
 */
public final class PagerData {
    private String mNameLevel;
    private String mPhoto;
    private int mRank;
    private String mExplanation;

    public PagerData(final String _nameLevel, final String _photo, final int _rank, final String _explanation) {
        mNameLevel = _nameLevel;
        mPhoto = _photo;
        mRank = _rank;
        mExplanation = _explanation;
    }

    public String getNameLevel() {
        return mNameLevel;
    }

    public String getPhoto() {
        return mPhoto;
    }

    public int getRank() {
        return mRank;
    }

    public String getExplanation() {
        return mExplanation;
    }

    @Override
    public String toString() {
        return "PagerData{" +
                "NameLevel='" + mNameLevel + '\'' +
                ", Photo='" + mPhoto + '\'' +
                ", Rank=" + mRank +
                ", Explanation=" + mExplanation +
                '}';
    }
}
