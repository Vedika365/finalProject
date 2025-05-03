import org.example.Student;
import org.example.Task;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentTest {
   @Test
    void testCustomizePreference() {
       Student student = new Student("Bob");
       student.customizePreference("theme", "light");
       assertEquals("light", student.getPreferences().get("theme"));
   }
}
