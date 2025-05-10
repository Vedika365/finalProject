import org.example.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {
    @Test
    void testUserCreation() {
        User user = new User("Julie", "sports");
        assertEquals("Julie", user.getName());
        assertEquals("sports", user.getPreference());
    }

    @Test
    void testSetPreference() {
        User user = new User("Alice", "dance");
        user.setPreference("Reading");
        assertEquals("Reading", user.getPreference());
    }
}
