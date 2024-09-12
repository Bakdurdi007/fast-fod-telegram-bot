package org.example.MenuButton;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class AboutMe {
    public static void AboutMeMenuMethod(String chatId) {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboard = new ArrayList<>();

        KeyboardRow row1 = new KeyboardRow();
        row1.add(new KeyboardButton("Buyuk ipak yo‘li"));
        keyboard.add(row1);

        KeyboardRow row2 = new KeyboardRow();
        row2.add(new KeyboardButton("Megaplanet KSM"));
        keyboard.add(row2);

        KeyboardRow row3 = new KeyboardRow();
        row3.add(new KeyboardButton("Atlas Chimgan"));
        keyboard.add(row3);

        KeyboardRow row4 = new KeyboardRow();
        row4.add(new KeyboardButton("Parus KSM"));
        keyboard.add(row4);

        KeyboardRow row5 = new KeyboardRow();
        row5.add(new KeyboardButton("S. Rahimov"));
        keyboard.add(row5);

        KeyboardRow row6 = new KeyboardRow();
        row6.add(new KeyboardButton("Sergerli 2"));
        keyboard.add(row6);

        KeyboardRow row7 = new KeyboardRow();
        row7.add(new KeyboardButton("Orqaga qaytish \uD83D\uDD19"));
        keyboard.add(row7);

        keyboardMarkup.setKeyboard(keyboard);
        keyboardMarkup.setResizeKeyboard(true);

        SendButtonMessage.sendReplyMessage(chatId, "Ichmlik tanlang: ", keyboardMarkup);
    }
}
