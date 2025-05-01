import org.example.RewardSystem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    void testGrant
}
