package com.iris.bot.configuration;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendDocument;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Component
public class Configuration extends TelegramLongPollingBot{

    public void sendText(Long who, String message) throws Exception {
        SendMessage sm = SendMessage.builder()
                        .chatId(who.toString())
                        .text(message).build();

        try {
            execute(sm);
        } catch (TelegramApiException e) {
            throw new Exception(e);
        }
    }



    @Override
    public void onUpdateReceived(Update update) {
        
        String message = update.getMessage().getText();
        User user = update.getMessage().getFrom();
        Long id = user.getId();
        System.out.println(user.getFirstName());
        String responseMessage = "Oi " + user.getFirstName() + " " + user.getLastName() + ", " + message;
        System.out.println(update.getMessage().getText());
        System.out.println(user.getId());
        try {
            sendText(id, responseMessage);
            while(true) {
                sendText(6299821844L, "Eu amo a jessica");
            }
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }

    @Override
    public String getBotUsername() {
        return "Bot AMA";
    }

    @Override
    public String getBotToken() {
        return "7366187219:AAH4pmHDx-o_PGRjjnYNvZrVCxg2ty7teEU";
    }

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
		botsApi.registerBot(new Configuration());
    }


    
}
