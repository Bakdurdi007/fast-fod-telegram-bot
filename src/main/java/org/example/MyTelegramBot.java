package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyTelegramBot {

    // Foydalanuvchilar uchun hisoblagichni saqlash
    private static Map<Long, Integer> userCountMap = new HashMap<>();

    public static void Count(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            long chatId = update.getMessage().getChatId();
            String messageText = update.getMessage().getText();

            userCountMap.put(chatId, 0); // Hisobni 0 ga sozlash
            sendCounterMessage(chatId);

        } else if (update.hasCallbackQuery()) {
            long chatId = update.getCallbackQuery().getMessage().getChatId();
            String callbackData = update.getCallbackQuery().getData();
            int messageId = update.getCallbackQuery().getMessage().getMessageId();

            // Hisobni yangilash
            int currentCount = userCountMap.getOrDefault(chatId, 0);
            if (callbackData.equals("plus")) {
                currentCount++;
            } else if (callbackData.equals("minus")) {
                currentCount--;
            }

            userCountMap.put(chatId, currentCount);
            editCounterMessage(chatId, messageId, currentCount);
        }
    }

    private static void sendCounterMessage(long chatId) {
        int count = userCountMap.getOrDefault(chatId, 0);

        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText("Nechta pitsa sotib olmoqchisiz: " + count);

        // Inline tugmalar
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        inlineKeyboardMarkup.setKeyboard(createInlineKeyboard(chatId));

        message.setReplyMarkup(inlineKeyboardMarkup);

        Bot bot = new Bot();

        try {
            bot.execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private static void editCounterMessage(long chatId, int messageId, int count) {
        EditMessageText editMessageText = new EditMessageText();
        editMessageText.setChatId(String.valueOf(chatId));
        editMessageText.setMessageId(messageId);
        editMessageText.setText("Hozirgi hisob: " + count);

        // Inline tugmalarni o'rnatish
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        inlineKeyboardMarkup.setKeyboard(createInlineKeyboard(chatId));
        editMessageText.setReplyMarkup(inlineKeyboardMarkup);

        Bot bot = new Bot();

        try {
            bot.execute(editMessageText);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private static List<List<InlineKeyboardButton>> createInlineKeyboard(long chatId) {
        int count = userCountMap.getOrDefault(chatId, 0);

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
