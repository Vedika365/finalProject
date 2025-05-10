import org.example.Student;
import org.example.Task;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StudentTest {
   @Test
   void testCustomizePreference() {
      // Create a student with the name "Bob"
      Student student = new Student("Bob");

      // Customize preference for "theme"
      student.customizePreference("theme", "light");

      // Assert that the theme preference is set to "light"
      assertEquals("light", student.getPreferences().get("theme"));
   }

   @Test
   void testCustomizePreference2() {
      // Create a student with the name "Charlie"
      Student student = new Student("Charlie");

      // Customize preference for "FavoriteSubject"
      student.customizePreference("FavoriteSubject", "Math");

      // Assert that the "FavoriteSubject" preference exists
      assertTrue(student.getPreferences().containsKey("FavoriteSubject"));

      // Assert that the value for "FavoriteSubject" is "Math"
      assertEquals("Math", student.getPreferences().get("FavoriteSubject"));
   }
}
