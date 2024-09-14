package org.example;

import org.example.MenuButton.*;
import org.example.Send.SendPhotoClass;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

public class Bot extends TelegramLongPollingBot {
    @Override
    public String getBotUsername() {
        return "@activecoin_bot";
    }

    @Override
    public String getBotToken() {
        return "7257958469:AAFs0xvhWVHrkFfsrPt_n8HXpk3pWQTUIRI";
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
            }else if(text.equals("Vegetarian \uD83C\uDF55")){
                String PizzaInfo = "<i><b>Vegetarian pizza</b></i> can be a healthier choice than meat pizza because it's often packed with vitamins, minerals, and fiber, while meat is usually higher in fat and calories. Here's some information about vegetarian pizza: \n\n <b>20 sm</b> - 80 ming so'm \n <b>30 sm</b> - 90 ming so'm \n <b>40 sm</b> - 100 ming so'm";
                String url = "img/Pizza/1.jpg";
                SendPhotoClass.SendPhotoMethod(chatId, PizzaInfo, url);
            }else if(text.equals("20 sm")){
                MyTelegramBot.Count(update);
            }
        }
    }
}
