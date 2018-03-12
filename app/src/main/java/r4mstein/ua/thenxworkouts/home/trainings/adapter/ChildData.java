package r4mstein.ua.thenxworkouts.home.trainings.adapter;

/**
 * Created by Alex Shtain on 10.03.2018.
 */

public final class ChildData {
    private String mDay;
    private String mTrainingName;

    ChildData(final String _day, final String _trainingName) {
        mDay = _day;
        mTrainingName = _trainingName;
    }

    String getDay() {
        return mDay;
    }

    String getTrainingName() {
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
