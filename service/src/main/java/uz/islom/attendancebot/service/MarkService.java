package uz.islom.attendancebot.service;

import org.telegram.telegrambots.meta.api.objects.Update;

public class MarkService {

    public String startMarking(Update update) {
        // Minimal demo logic. Replace with real flow (choose class, lesson, mark students)
        String user = update.getMessage().getFrom().getFirstName();
        return "Salom, " + user + ". Darsni belgilash boshlanadi (demo).";
    }
}
