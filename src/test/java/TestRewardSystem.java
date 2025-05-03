import org.example.RewardSystem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestRewardSystem {
    @Test
    void TestInitialState() {
        assertEquals(0, RewardSystem.getPoints());
    }

    @Test
    void testTrackPogress() {
        RewardSystem.trackProgress(true);
        assertEquals(10, RewardSystem.getPoints());
    }

    @Test
    void testGrantReward_NotenoughPoint() {
        RewardSystem.trackProgress(true); //ex.10 pts
        RewardSystem.trackProgress(true);
        RewardSystem.grantReward();
        assertFalse(RewardSystem.isRewardEarned()); //reward should not be granted
        assertEquals(20, RewardSystem.getPoints());
    }


}
