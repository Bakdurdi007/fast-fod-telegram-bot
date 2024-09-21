package org.example;

import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.bots.AbsSender;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CounterManager {

    // Foydalanuvchilar uchun hisoblagichni saqlash
    public static Map<Long, Integer> userCountMap = new HashMap<>();

    public void sendCounterMessage(AbsSender bot, long chatId, String text) {
        int count = userCountMap.getOrDefault(chatId, 0);

        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText(text + "\nHozirgi hisob: " + count);

        // Inline tugmalar
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        inlineKeyboardMarkup.setKeyboard(createInlineKeyboard(count));

        message.setReplyMarkup(inlineKeyboardMarkup);

        try {
            bot.execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void editCounterMessage(AbsSender bot, long chatId, int messageId, String text, String callbackData) {
        int currentCount = userCountMap.getOrDefault(chatId, 0);

        if (callbackData.equals("plus")) {
            currentCount++;
        } else if (callbackData.equals("minus")) {
            currentCount--;
        }

        DataBase.ProductCount.put(String.valueOf(chatId), currentCount);
        userCountMap.put(chatId, currentCount);

        EditMessageText editMessageText = new EditMessageText();
        editMessageText.setChatId(String.valueOf(chatId));
        editMessageText.setMessageId(messageId);
        editMessageText.setText(text + "\nHozirgi hisob: " + currentCount);

        // Inline tugmalarni o'rnatish
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        inlineKeyboardMarkup.setKeyboard(createInlineKeyboard(currentCount));
        editMessageText.setReplyMarkup(inlineKeyboardMarkup);

        try {
            bot.execute(editMessageText);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private List<List<InlineKeyboardButton>> createInlineKeyboard(int count) {

        // Tugmalarni yaratish
        InlineKeyboardButton minusButton = new InlineKeyboardButton();
        minusButton.setText("-");
        minusButton.setCallbackData("minus");

        InlineKeyboardButton zeroButton = new InlineKeyboardButton();
        zeroButton.setText(String.valueOf(count));
        zeroButton.setCallbackData("zero");

        InlineKeyboardButton plusButton = new InlineKeyboardButton();
        plusButton.setText("+");
        plusButton.setCallbackData("plus");

        // Tugmalarni gorizantal ko'rinishda joylashtirish
        List<InlineKeyboardButton> row = new ArrayList<>();
        row.add(minusButton);
        row.add(zeroButton);
        row.add(plusButton);

        List<List<InlineKeyboardButton>> rows = new ArrayList<>();
        rows.add(row);

        return rows;
    }
}
