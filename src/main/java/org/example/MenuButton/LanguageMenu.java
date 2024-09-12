package org.example.MenuButton;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class LanguageMenu {
    public static void sendLanguageSelectionMenu(String chatId) {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboard = new ArrayList<>();

        KeyboardRow row = new KeyboardRow();
        row.add(new KeyboardButton("Uzb \uD83C\uDDFA\uD83C\uDDFF"));
        row.add(new KeyboardButton("Rus \uD83C\uDDF7\uD83C\uDDFA"));
        row.add(new KeyboardButton("Eng \uD83C\uDDFA\uD83C\uDDF8"));
        keyboard.add(row);

        keyboardMarkup.setKeyboard(keyboard);
        keyboardMarkup.setResizeKeyboard(true);

        SendButtonMessage.sendReplyMessage(chatId, "Tilni tanlang: ", keyboardMarkup);
    }
}
