import org.example.Student;
import org.example.Task;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentTest {
    @Test
    void testCustomizePreference_normalInput() {

        //todo fix this after


        List<Task> taskList = new ArrayList<>();
        Map<String, String> initialPreferences = new HashMap<>();
        initialPreferences.put("studyTime", "morning");

        Student student = new Student("Alice", "general");

        //new preference to apply
        Map<String, String> newPrefs = new HashMap<>();
        newPrefs.put("studyTime", "evening");
        newPrefs.put("reminderType", "popup");

        student.customizePreference(newPrefs);
        //TODO
        }
    }
}
