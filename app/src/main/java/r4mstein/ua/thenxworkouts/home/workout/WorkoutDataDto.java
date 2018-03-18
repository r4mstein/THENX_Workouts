package r4mstein.ua.thenxworkouts.home.workout;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Alex Shtain on 13.03.2018.
 */
@SuppressWarnings("unused")
public final class WorkoutDataDto {
    @SerializedName("warmUp")
    private WarmUp mWarmUp;
    @SerializedName("train")
    private Workout mTrain;

    public WorkoutDataDto() {

    }

    public WarmUp getWarmUp() {
        return mWarmUp;
    }

    public void setWarmUp(WarmUp warmUp) {
        this.mWarmUp = warmUp;
    }

    public Workout getTrain() {
        return mTrain;
    }

    public void setTrain(Workout train) {
        this.mTrain = train;
    }

    @Override
    public String toString() {
        return "WorkoutDataDto{" +
                "mWarmUp=" + mWarmUp +
                ", mTrain=" + mTrain +
                '}';
    }

    public static class WarmUp {
        @SerializedName("exercises")
        private List<Exercise> mExercises;
        @SerializedName("count")
        private int mCount;

        public WarmUp() {

        }

        public List<Exercise> getExercises() {
            return mExercises;
        }

        public void setExercises(List<Exercise> exercises) {
            this.mExercises = exercises;
        }

        public int getCount() {
            return mCount;
        }

        public void setCount(int count) {
            this.mCount = count;
        }

        @Override
        public String toString() {
            return "WarmUp{" +
                    "mExercises=" + mExercises +
                    ", mCount=" + mCount +
                    '}';
        }
    }

    public static class Workout {
        @SerializedName("roundOne")
        private List<Exercise> mRoundOne;
        @SerializedName("roundOneCount")
        private int mRoundOneCount;

        public Workout() {

        }

        public List<Exercise> getRoundOne() {
            return mRoundOne;
        }

        public void setRoundOne(List<Exercise> roundOne) {
            this.mRoundOne = roundOne;
        }

        public int getRoundOneCount() {
            return mRoundOneCount;
        }

        public void setRoundOneCount(int roundOneCount) {
            this.mRoundOneCount = roundOneCount;
        }

        @Override
        public String toString() {
            return "Workout{" +
                    "mRoundOne=" + mRoundOne +
                    ", mRoundOneCount=" + mRoundOneCount +
                    '}';
        }
    }

    public static class Exercise {
        @SerializedName("id")
        private int mId;
        @SerializedName("name")
        private String mName;
        @SerializedName("repetition")
        private int mRepetition;
        @SerializedName("time")
        private int mTime;
        @SerializedName("link")
        private String mLink;

        public Exercise() {

        }

        public int getId() {
            return mId;
        }

        public void setId(int id) {
            this.mId = id;
        }

        public String getName() {
            return mName;
        }

        public void setName(String name) {
            this.mName = name;
        }

        public int getRepetition() {
            return mRepetition;
        }

        public void setRepetition(int repetition) {
            this.mRepetition = repetition;
        }

        public int getTime() {
            return mTime;
        }

        public void setTime(int time) {
            this.mTime = time;
        }

        public String getLink() {
            return mLink;
        }

        public void setLink(String link) {
            this.mLink = link;
        }

        @Override
        public String toString() {
            return "Exercise{" +
                    "mId=" + mId +
                    ", mName='" + mName + '\'' +
                    ", mRepetition=" + mRepetition +
                    ", mTime=" + mTime +
                    ", mLink='" + mLink + '\'' +
                    '}';
        }
    }
}
