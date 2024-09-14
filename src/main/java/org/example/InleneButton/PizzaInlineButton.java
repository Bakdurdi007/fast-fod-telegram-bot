package org.example.InleneButton;

import org.example.Bot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class PizzaInlineButton {
    private void sendInlineButton(long chatId) {
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText("Quyidagi tugmalarni tanlang:");

        // Inline keyboard markup
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();

        // Inline keyboard buttons
        InlineKeyboardButton button1 = new InlineKeyboardButton();

        button1.setText("Tugma 1");
        button1.setCallbackData("button1");

        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("Tugma 2");
        button2.setCallbackData("button2");

        // Tugmalarni ro'yxatga qo'shish
        List<InlineKeyboardButton> row1 = new ArrayList<>();
        row1.add(button1);
        row1.add(button2);

        List<List<InlineKeyboardButton>> rows = new ArrayList<>();
        rows.add(row1);

        inlineKeyboardMarkup.setKeyboard(rows);

        // Tugmalarni xabar bilan birga qo'shish
        message.setReplyMarkup(inlineKeyboardMarkup);

        Bot bot = new Bot();

        try {
            bot.execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
