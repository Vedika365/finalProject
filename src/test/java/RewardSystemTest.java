import org.example.RewardSystem;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RewardSystemTest {

    @Test
    void testInitialState() {
        RewardSystem rewardSystem = new RewardSystem();
        assertEquals(0, rewardSystem.getPoints(), "Initial points should be 0");
        assertFalse(rewardSystem.isRewardEarned(), "Reward should not be earned initially");
    }

    @Test
    void testTrackProgress_AddsPoints() {
        RewardSystem rewardSystem = new RewardSystem();
        rewardSystem.trackProgress(true);
        assertEquals(10, rewardSystem.getPoints(), "Points should be 10 after one completed task");

        rewardSystem.trackProgress(true);
        assertEquals(20, rewardSystem.getPoints(), "Points should be 20 after two completed tasks");
    }

    @Test
    void testTrackProgress_NoPointsIfNotCompleted() {
        RewardSystem rewardSystem = new RewardSystem();
        rewardSystem.trackProgress(false);
        assertEquals(0, rewardSystem.getPoints(), "Points should remain 0 if no task is completed");
    }

    @Test
    void testGrantReward_EnoughPoints() {
        RewardSystem rewardSystem = new RewardSystem();
        for (int i = 0; i < 10; i++) {
            rewardSystem.trackProgress(true); // Adds 100 points total
        }
        rewardSystem.grantReward();

        assertTrue(rewardSystem.isRewardEarned(), "Reward should be earned after 100 points");
        assertEquals(0, rewardSystem.getPoints(), "Points should reset to 0 after reward is granted");
    }

    @Test
    void testGrantReward_NotEnoughPoints() {
        RewardSystem rewardSystem = new RewardSystem();
        rewardSystem.trackProgress(true); // only 10 points
        rewardSystem.grantReward();

        assertFalse(rewardSystem.isRewardEarned(), "Reward should not be earned");
        assertEquals(10, rewardSystem.getPoints(), "Points should remain unchanged");
    }

    @Test
    void testReset() {
        RewardSystem rewardSystem = new RewardSystem();
        for (int i = 0; i < 5; i++) rewardSystem.trackProgress(true); // 50 points
        rewardSystem.reset(20, true);

        assertEquals(20, rewardSystem.getPoints(), "Points should reset to 20");
        assertTrue(rewardSystem.isRewardEarned(), "Reward status should reset to true");
    }

    @Test
    void testResetReward() {
        RewardSystem rewardSystem = new RewardSystem();
        rewardSystem.reset(150, true);
        rewardSystem.resetReward();

        assertFalse(rewardSystem.isRewardEarned(), "Reward should be reset to false");
    }
}

