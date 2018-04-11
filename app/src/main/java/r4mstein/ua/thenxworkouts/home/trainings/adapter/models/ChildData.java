package r4mstein.ua.thenxworkouts.home.trainings.adapter.models;

/**
 * Created by Alex Shtain on 10.03.2018.
 */

public final class ChildData {
    private String mDay;
    private String mTrainingName;

    public ChildData(final String _day, final String _trainingName) {
        mDay = _day;
        mTrainingName = _trainingName;
    }

    public String getDay() {
        return mDay;
    }

    public String getTrainingName() {
        return mTrainingName;
    }

    @Override
    public String toString() {
        return "ChildData{" +
                "Day='" + mDay + '\'' +
                ", TrainingName='" + mTrainingName + '\'' +
                '}';
    }
}
