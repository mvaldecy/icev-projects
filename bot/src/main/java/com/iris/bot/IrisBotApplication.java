package com.iris.bot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import com.iris.bot.configuration.Configuration;

@SpringBootApplication
public class IrisBotApplication {

	public static void main(String[] args) throws TelegramApiException {
		TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
		botsApi.registerBot(new Configuration());
		SpringApplication.run(IrisBotApplication.class, args);
	}

}
