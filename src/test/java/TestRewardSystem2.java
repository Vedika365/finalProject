import org.example.RewardSystem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestRewardSystem2 {
    @Test
    void testInitialState() {
        RewardSystem rs = new RewardSystem();
        assertEquals(0, rs.getPoints());
        assertFalse(rs.isRewardEarned());
    }

    @Test
    void testTrackProgress() {
        RewardSystem rs = new RewardSystem();
        rs.reset(0, false);
        rs.trackProgress(true);
        assertEquals(10, rs.getPoints());
    }

    @Test
    void testGrantReward_NotEnoughPoints() {
        RewardSystem rs = new RewardSystem();
        rs.reset(0, false);
        rs.trackProgress(true); // +10
        rs.trackProgress(true); // +10 → total 20
        rs.grantReward();
        assertFalse(rs.isRewardEarned());
        assertEquals(20, rs.getPoints());
    }

    @Test
    void testGrantReward_EnoughPoints() {
        RewardSystem rs = new RewardSystem();
        rs.reset(100, false);
        rs.grantReward();
        assertTrue(rs.isRewardEarned());
        assertEquals(0, rs.getPoints());
    }
}
