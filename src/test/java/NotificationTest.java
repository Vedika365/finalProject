import org.example.Notification;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class NotificationTest {
    @Test
    public void testSendNotifications() {
        Notification notification = new Notification("Test message", LocalDateTime.now());
        assertDoesNotThrow(() -> notification.sendNotifications());
    }
}
