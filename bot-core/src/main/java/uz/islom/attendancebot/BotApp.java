package uz.islom.attendancebot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import uz.islom.attendancebot.bot.AttendanceBot;

public class BotApp {
    public static void main(String[] args) throws Exception {
        TelegramBotsApi api = new TelegramBotsApi(DefaultBotSession.class);
        api.registerBot(new AttendanceBot());
        System.out.println("Bot started!");
    }
}
