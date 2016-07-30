package com.isatimur.pokebot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.TelegramApiException;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;

@SpringBootApplication
public class PokebotApplication implements CommandLineRunner {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(PokebotApplication.class.getSimpleName());

    @Override
    public void run(String... strings) throws Exception {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            telegramBotsApi.registerBot(new TelegramLongPollingBot() {
                @Override
                public String getBotToken() {
                    return "<Bot Token>";
                }

                @Override
                public void onUpdateReceived(Update update) {
                    Message msg = update.getMessage();
                    logger.info(msg.getText());
                }

                @Override
                public String getBotUsername() {
                    return "p_o_k_e_bot";
                }
            });
        }
        catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        SpringApplication.run(PokebotApplication.class, args);

    }
}
