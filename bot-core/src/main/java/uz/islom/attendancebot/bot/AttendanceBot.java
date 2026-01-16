package uz.islom.attendancebot.bot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import uz.islom.attendancebot.config.BotConfig;
import uz.islom.attendancebot.handlers.CommandHandler;

public class AttendanceBot extends TelegramLongPollingBot {

    private final CommandHandler handler = new CommandHandler();

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String chatId = update.getMessage().getChatId().toString();
            String text = update.getMessage().getText();

            String response = handler.handle(text, update);

            try {
                execute(new SendMessage(chatId, response));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String getBotUsername() {
        return "pdpschool9A_bot";
    }

    @Override
    public String getBotToken() {
        return "8249297058:AAHzTiNZLJ9-4PQDmAG71fGqHwgVyBo8qkU";
    }
}
