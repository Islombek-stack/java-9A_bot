package uz.islom.attendancebot.handlers;

import org.telegram.telegrambots.meta.api.objects.Update;
import uz.islom.attendancebot.service.MarkService;

public class CommandHandler {

    private final MarkService markService = new MarkService();
    private final uz.islom.attendancebot.handlers.StudentService studentService = new StudentService();

    public String handle(String command, Update update) {

        String[] parts = command.split(" ");

        switch (parts[0]) {

            case "/start":
                return "Assalomu alaykum! Bu pdp_9a bot.";

            case "/mark":
                return markService.startMarking(update);

            case "/add_student":
                if (parts.length < 2) return "Foydalanish: /add_student <ism>";
                return studentService.addStudent(command.replace("/add_student ", ""));
            case "/grade":
                if (parts.length < 3) return "Foydalanish: /grade <ism> <baho>";
                String name = parts[1];
                int grade = Integer.parseInt(parts[2]);
                return studentService.gradeStudent(name, grade);

            case "/clear_students":
                return studentService.clearAll();

            case "/list_students":
                return studentService.listStudents();

            default:
                return "Noma'lum buyruq.\nBuyruqlar: /add_student /grade /clear_students /list_students";
        }
    }
}
