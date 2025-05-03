package org.example;

public class RewardSystem {
    private int points;
    private boolean earned;

  //TODO FIX EVERYTHING IN THIS CLASS, ALL WRONG

    public RewardSystem() {
        this.points = 0;
        this.earned = false;
    }

    /**
     * grant reward if enough points are accumulated
     */
    public static void grantReward() {
        if (points >= 100) {
            earned = true;
            System.out.println("Reward granted");
            points -= 100;  //reset/ reduce points after reward
        }
        else {
            System.out.println("Not enough points to grant reward");
        }
    }

    /**
     * track progress by adding points
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
