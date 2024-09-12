package org.example.MenuButton;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class SnacksMenu {
    public static void SnacksMenuMethod(String chatId) {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboard = new ArrayList<>();

        KeyboardRow row1 = new KeyboardRow();
        row1.add(new KeyboardButton("FRI KARTOSHKASI \uD83C\uDF5F"));
        row1.add(new KeyboardButton("TOVUQ NAGETS, 6 dona \uD83C\uDF57"));
        keyboard.add(row1);

        KeyboardRow row2 = new KeyboardRow();
        row2.add(new KeyboardButton("TOVUQ NAGETS, 9 dona \uD83C\uDF57"));
        row2.add(new KeyboardButton("JAYDARI KARTOSHKA \uD83E\uDD54"));
        keyboard.add(row2);

        KeyboardRow row3 = new KeyboardRow();
        row3.add(new KeyboardButton("PISHLOQLI TOVUQ QALAMCHALARI \uD83C\uDF64"));
        row3.add(new KeyboardButton("CHOPAR SOUSIDAGI QANOTCHALAR \uD83C\uDF56"));
        keyboard.add(row3);

        KeyboardRow row4 = new KeyboardRow();
        row4.add(new KeyboardButton("Orqaga qaytish \uD83D\uDD19"));
        keyboard.add(row4);

        keyboardMarkup.setKeyboard(keyboard);
        keyboardMarkup.setResizeKeyboard(true);

        SendButtonMessage.sendReplyMessage(chatId, "Snack tanlang: ", keyboardMarkup);
    }
}
