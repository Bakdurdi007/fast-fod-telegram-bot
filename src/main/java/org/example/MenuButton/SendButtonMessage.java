package org.example.MenuButton;

import org.example.Bot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class SendButtonMessage {

    public static void  sendReplyMessage(String chatId, String Message, ReplyKeyboardMarkup keyboardMarkup){

        SendMessage sendMessage = new SendMessage();

        sendMessage.setChatId(chatId);
        sendMessage.setText(Message);
        sendMessage.setReplyMarkup(keyboardMarkup);
        sendMessage.setParseMode("HTML");

        Bot bot = new Bot();

        try {
            bot.execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }
}
