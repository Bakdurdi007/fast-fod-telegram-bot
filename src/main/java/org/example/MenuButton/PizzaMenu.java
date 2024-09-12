package org.example.MenuButton;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class PizzaMenu {
    public static void PizzaMenuMethod(String chatId) {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboard = new ArrayList<>();

        KeyboardRow row1 = new KeyboardRow();
        row1.add(new KeyboardButton("Vegetarian \uD83C\uDF55"));
        row1.add(new KeyboardButton("Meksika \uD83C\uDF55"));
        keyboard.add(row1);

        KeyboardRow row2 = new KeyboardRow();
        row2.add(new KeyboardButton("Bayram \uD83C\uDF55"));
        row2.add(new KeyboardButton("Go'shtli \uD83C\uDF55"));
        keyboard.add(row2);

        KeyboardRow row3 = new KeyboardRow();
        row3.add(new KeyboardButton("Pepperoni \uD83C\uDF55"));
        row3.add(new KeyboardButton("Xon pitsa \uD83C\uDF55"));
        keyboard.add(row3);

        KeyboardRow row4 = new KeyboardRow();
        row4.add(new KeyboardButton("Orqaga qaytish \uD83D\uDD19"));
        keyboard.add(row4);

        keyboardMarkup.setKeyboard(keyboard);
        keyboardMarkup.setResizeKeyboard(true);

        SendButtonMessage.sendReplyMessage(chatId, "Pitsani tanlang: ", keyboardMarkup);
    }
}
