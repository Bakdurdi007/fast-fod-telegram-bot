package org.example;

import org.example.MenuButton.*;
import org.example.Send.SendPhotoClass;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.time.LocalDateTime;

public class Bot extends TelegramLongPollingBot {
    private CounterManager counterManager = new CounterManager(); // CounterManager yaratamiz


    @Override
    public String getBotUsername() {
        return "@activecoin_bot";
    }

    @Override
    public String getBotToken() {
        return "6954489310:AAGpQcN1tHUuCNGkCRGjOlSzENfhaLLjI1w";
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String text = update.getMessage().getText();
            String chatId = update.getMessage().getChatId().toString();

            if (text.equals("/start")) {
                LanguageMenu.sendLanguageSelectionMenu(chatId);
            } else if (text.equals("Uzb \uD83C\uDDFA\uD83C\uDDFF")) {
                BaseMenu.BaseMenuMethod(chatId);
            } else if (text.equals("Ichimliklar \uD83E\uDD64")) {
                DrinkMenu.DrinkMenuMethod(chatId);
            } else if (text.equals("Orqaga qaytish \uD83D\uDD19")) {
                BaseMenu.BaseMenuMethod(chatId);
            } else if (text.equals("Sozlamalar ⚙\uFE0F")) {
                LanguageMenu.sendLanguageSelectionMenu(chatId);
            } else if (text.equals("Pitsa \uD83C\uDF55")) {
                PizzaMenu.PizzaMenuMethod(chatId);
            } else if (text.equals("Sneklar \uD83C\uDF5F")) {
                SnacksMenu.SnacksMenuMethod(chatId);
            } else if (text.equals("Souslar \uD83E\uDD6B")) {
                SousMenu.SousMenuMethod(chatId);
            } else if (text.equals("Biz haqimizda \uD83D\uDC68\u200D\uD83D\uDCBB")) {
                AboutMe.AboutMeMenuMethod(chatId);
            } else if (text.equals("Vegetarian \uD83C\uDF55")) {
                DataBase.ProductName.put(chatId, "Vegetarian");
                String PizzaInfo = "<i><b>Vegetarian pizza</b></i> can be a healthier choice than meat pizza because it's often packed with vitamins, minerals, and fiber, while meat is usually higher in fat and calories. Here's some information about vegetarian pizza: \n\n <b>20 sm</b> - 80 ming so'm \n <b>30 sm</b> - 90 ming so'm \n <b>40 sm</b> - 100 ming so'm";
                String url = "img/Pizza/1.jpg";
                SendPhotoClass.SendPhotoMethod(chatId, PizzaInfo, url);
            } else if (text.equals("20 sm")) {
                DataBase.ProductCost.put(chatId, 80000L);
                OrderMenu.OrderMenuMethod(chatId);
                // Hisoblagichni chaqirish va mahsulot haqida xabar berish
                counterManager.sendCounterMessage(this, Long.parseLong(chatId), "Nechta dona sotib olmoqchisiz?");
            }else if(text.equals("30 sm")){

            }else if(text.equals("40 sm")){

            }else if(text.equals("Tastiqlash ✅")){
                System.out.println("Tastiqlash");
                DataBase.OrderDataTime.put(chatId, DataTimeOrder());

                System.out.println(" User chat id......................: " + chatId);
                System.out.println(" Product name......................: " + DataBase.ProductName.get(chatId));
                System.out.println(" Product count.....................: " + DataBase.ProductCount.get(chatId));
                System.out.println(" Product cost......................: " + DataBase.ProductCost.get(chatId));
                System.out.println(" Order data time...................: " + DataBase.OrderDataTime.get(chatId));

                DataBaseConnection.AddProduct(chatId, DataBase.ProductName.get(chatId), DataBase.ProductCount.get(chatId), DataBase.ProductCost.get(chatId), DataBase.OrderDataTime.get(chatId));

                DataBase.ProductName.remove(chatId);
                DataBase.ProductCost.remove(chatId);
                DataBase.OrderDataTime.remove(chatId);
                DataBase.ProductCount.remove(chatId);
                CounterManager.userCountMap.remove(chatId);
                BaseMenu.BaseMenuMethod(chatId);
            }else if (text.equals("Savatcha \uD83D\uDED2")){
                String post = DataBaseConnection.ShowProduct(chatId);

                SendMessage sendMessage = new SendMessage();
                sendMessage.setChatId(chatId);
                sendMessage.setText(post);
                sendMessage.setParseMode("HTML");

                try {
                    execute(sendMessage);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
        } else if (update.hasCallbackQuery()) {
            long chatId = update.getCallbackQuery().getMessage().getChatId();
            int messageId = update.getCallbackQuery().getMessage().getMessageId();
            String callbackData = update.getCallbackQuery().getData();

            // Callback bo'yicha xabarni tahrirlash va hisobni yangilash
            counterManager.editCounterMessage(this, chatId, messageId, "Nechta dona sotib olmoqchisiz?", callbackData);
        }
    }

    public static String DataTimeOrder(){
        LocalDateTime localDateTime = LocalDateTime.now();
        return localDateTime.toString();
    }
}

