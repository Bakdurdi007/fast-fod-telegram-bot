package org.example;

import org.example.MenuButton.*;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

public class Bot extends TelegramLongPollingBot {
    @Override
    public String getBotUsername() {
        return "@activecoin_bot";
    }

    @Override
    public String getBotToken() {
        return "6954489310:AAEgCsma0lGX09Goza2N6ce6bdK-okyLQJk";
    }

    @Override
    public void onUpdateReceived(Update update) {
        String chatId = update.getMessage().getChatId().toString();
        String text = update.getMessage().getText();

        if(text.equals("/start")){
            LanguageMenu.sendLanguageSelectionMenu(chatId);
        }

        if (update.hasMessage() && update.getMessage().hasText()) {
            if(text.equals("Uzb \uD83C\uDDFA\uD83C\uDDFF")){
                BaseMenu.BaseMenuMethod(chatId);
            }else if(text.equals("Ichimliklar \uD83E\uDD64")){
                DrinkMenu.DrinkMenuMethod(chatId);
            }else if(text.equals("Orqaga qaytish \uD83D\uDD19")){
                BaseMenu.BaseMenuMethod(chatId);
            }else if(text.equals("Sozlamalar ⚙\uFE0F")){
                LanguageMenu.sendLanguageSelectionMenu(chatId);
            }else if(text.equals("Pitsa \uD83C\uDF55")){
                PizzaMenu.PizzaMenuMethod(chatId);
            }else if(text.equals("Sneklar \uD83C\uDF5F")){
                SnacksMenu.SnacksMenuMethod(chatId);
            }else if(text.equals("Souslar \uD83E\uDD6B")){
                SousMenu.SousMenuMethod(chatId);
            }else if(text.equals("Biz haqimizda \uD83D\uDC68\u200D\uD83D\uDCBB")){
                AboutMe.AboutMeMenuMethod(chatId);
            }
        }
    }
}
