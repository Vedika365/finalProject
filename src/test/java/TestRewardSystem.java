import org.example.RewardSystem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestRewardSystem {
    @Test
    void TestInitialState() {
        RewardSystem.reset();
        assertEquals(0, RewardSystem.getPoints());
    }

    @Test
    void testTrackProgress() {
        RewardSystem.reset(0, false);
        RewardSystem.trackProgress(true);
        assertEquals(10, RewardSystem.getPoints());
    }

    @Test
    void testGrantReward_NotenoughPoint() {
        RewardSystem.reset();
        RewardSystem Rs = new RewardSystem();
        RewardSystem.trackProgress(true); //ex.10 pts
        RewardSystem.trackProgress(true);
        Rs.grantReward();
        assertFalse(RewardSystem.isRewardEarned()); //reward should not be granted
        assertEquals(20, RewardSystem.getPoints());
    }


}
