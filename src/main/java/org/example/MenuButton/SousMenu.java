package org.example.MenuButton;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class SousMenu {
    public static void SousMenuMethod(String chatId) {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboard = new ArrayList<>();

        KeyboardRow row1 = new KeyboardRow();
        row1.add(new KeyboardButton("CHILI SOUS \uD83E\uDD6B"));
        row1.add(new KeyboardButton("FRENCH SOUS \uD83E\uDD6B"));
        keyboard.add(row1);

        KeyboardRow row2 = new KeyboardRow();
        row2.add(new KeyboardButton("KETCHUP SOUS \uD83E\uDD6B"));
        row2.add(new KeyboardButton("SEZAR SOUS \uD83E\uDD6B"));
        keyboard.add(row2);

        KeyboardRow row3 = new KeyboardRow();
        row3.add(new KeyboardButton("Orqaga qaytish \uD83D\uDD19"));
        keyboard.add(row3);

        keyboardMarkup.setKeyboard(keyboard);
        keyboardMarkup.setResizeKeyboard(true);

        SendButtonMessage.sendReplyMessage(chatId, "Ichmlik tanlang: ", keyboardMarkup);
    }
}
