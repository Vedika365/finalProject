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
    public static void reset(int points, boolean earned) {
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
     * track progress by adding points when a task is completed
     */
    public static void trackProgress(boolean TaskCompleted) {
      if (TaskCompleted) {
          points += 10;
          System.out.println("Task completed. 10 points added. Total : " + points);
      }
      else {
          System.out.println("no progress made");
      }
    }

    public static int getPoints() {
        return points;
    }

    public static boolean isRewardEarned() {
        return earned;
    }

    public void resetReward() {
        earned = false;
    }
}
