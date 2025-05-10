package org.example;

public class RewardSystem {
    private int points;
    private boolean earned;


    public RewardSystem() {
        this.points = 0;
        this.earned = false;
    }

    /**
     * reset the reward system to the given values
     * @param points the points to reset to
     * @param earned whether a reward is already earned
     */
    public void reset(Integer points, boolean earned) {
        if(points == null ) {
            System.out.println("Reset failed : points is null ");
            return;
        }
        this.points = points;
        this.earned = earned;
    }

    /**
     * grant reward if enough points are accumulated
     */
    public void grantReward() {
        if (this.points >= 100) {
            this.earned = true;
            System.out.println("Reward granted");
            this.points -= 100;  //reset/ reduce points after reward
        }
        else {
            System.out.println("Not enough points to grant reward");
        }
    }

    /**
     * Track progress by adding points when a task is completed.
     * @param taskCompleted true if task was completed (nullable wrapper)
     */
    public void trackProgress(Boolean taskCompleted) {
        if (taskCompleted == null) {
            System.out.println("Progress tracking failed: taskCompleted is null.");
            return;
        }
        if (taskCompleted) {
            points += 10;
        }
    }

    public int getPoints() {
        return points;
    }

    public boolean isRewardEarned() {
        return earned;
    }

    public void resetReward() {
        earned = false;
    }
}
