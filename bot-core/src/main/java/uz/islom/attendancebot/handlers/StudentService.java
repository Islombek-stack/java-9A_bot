package uz.islom.attendancebot.handlers;

import java.util.HashMap;
import java.util.Map;
import java.util.*;

public class StudentService {
    private final Map<String, Integer> students = new HashMap<>();

    public String addStudent(String name) {
        if (name.isBlank()) return "Ism kiriting!";
        if (students.containsKey(name)) return "Bu o‘quvchi allaqachon mavjud.";

        students.put(name, 0);
        return "O‘quvchi qo‘shildi: " + name;
    }

    public String gradeStudent(String name, int grade) {
        if (!students.containsKey(name)) {
            return "Bunday o‘quvchi yo‘q: " + name;
        }
        students.put(name, grade);
        return "Baholandi: " + name + " → " + grade;
    }

    public String clearAll() {
        students.clear();
        return "Barcha o‘quvchilar o‘chirildi.";
    }

    public String listStudents() {
        if (students.isEmpty()) return "O‘quvchilar ro‘yxati bo‘sh.";

        StringBuilder sb = new StringBuilder("O‘quvchilar:\n");
        students.forEach((name, grade) ->
                sb.append("• ").append(name).append(" — ").append(grade).append("\n")
        );
        return sb.toString();
    }
}
