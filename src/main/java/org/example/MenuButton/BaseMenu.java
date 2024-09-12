package org.example.MenuButton;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class BaseMenu {
    public static void BaseMenuMethod(String chatId) {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboard = new ArrayList<>();

        KeyboardRow row1 = new KeyboardRow();
        row1.add(new KeyboardButton("Ichimliklar \uD83E\uDD64"));
        row1.add(new KeyboardButton("Pitsa \uD83C\uDF55"));
        keyboard.add(row1);

        KeyboardRow row2 = new KeyboardRow();
        row2.add(new KeyboardButton("Sneklar \uD83C\uDF5F"));
        row2.add(new KeyboardButton("Souslar \uD83E\uDD6B"));
        keyboard.add(row2);

        KeyboardRow row3 = new KeyboardRow();
        row3.add(new KeyboardButton("Biz haqimizda \uD83D\uDC68\u200D\uD83D\uDCBB"));
        row3.add(new KeyboardButton("Sozlamalar ⚙\uFE0F"));
        keyboard.add(row3);

        KeyboardRow row4 = new KeyboardRow();
        row4.add(new KeyboardButton("Savatcha \uD83D\uDED2"));
        keyboard.add(row4);

        keyboardMarkup.setKeyboard(keyboard);
        keyboardMarkup.setResizeKeyboard(true);

        SendButtonMessage.sendReplyMessage(chatId, "Menyuni tanlang: ", keyboardMarkup);
    }
}
