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
       Student student = new Student("Bob");
       student.customizePreference("theme", "light");
       assertEquals("light", student.getPreferences().get("theme"));
   }

   @Test
   void testCustomizePreference2() {
      Student student = new Student("Charlie");
      student.customizePreference("FavoriteSubject", "Math");
      assertTrue(student.getPreferences().containsKey("FavoriteSubject"));
      assertEquals("Math", student.getPreferences().get("FavoriteSubject"));
   }

   @Test
   void testStudentCreation() {
      Student student = new Student("Bob");
      assertEquals("Bob", student.getName());
      assertEquals("Default", student.getPreferences());
   }

}
