import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


import java.util.ArrayList;
import java.util.List;

public class Bot extends TelegramLongPollingBot {


    @Override
    public String getBotUsername() {
        return "overone_myphoto_bot";
    }

    @Override
    public String getBotToken() {
        return "5655046099:AAE4BvWDbMK2rBzyVtzdaE2x_VmHeMa2MM8";
    }

    @Override
    public void onUpdateReceived(Update update) {

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(update.getMessage().getChatId().toString());

        KeyboardRow keyboardRow1 = new KeyboardRow();
        keyboardRow1.add(new KeyboardButton("Monkey"));
        keyboardRow1.add(new KeyboardButton("Lemur"));
        keyboardRow1.add(new KeyboardButton("Owl"));

        KeyboardRow keyboardRow2 = new KeyboardRow();
        keyboardRow2.add(new KeyboardButton("Cat"));
        keyboardRow2.add(new KeyboardButton("Dog"));
        keyboardRow2.add(new KeyboardButton("Squirrel"));

        List<KeyboardRow> list = new ArrayList<>();
        list.add(keyboardRow1);
        list.add(keyboardRow2);

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(list);

        sendMessage.setText(update.getMessage().getText());
        sendMessage.setReplyMarkup(replyKeyboardMarkup);

        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(update.getMessage().getChatId().toString());
        InputFile inputFile = new InputFile();



        switch (update.getMessage().getText()){
            case "Monkey" :

                inputFile.setMedia("AgACAgIAAxkBAAMsY6qqPzYVshLH5c4q7PKNJXORCpQAAiDBMRuRzVhJGAJEkVZhlAwBAAMCAANzAAMsBA");

                break;
            case "Lemur" :
                inputFile.setMedia("AgACAgIAAxkBAAMuY6qqcf5aiY0nEMCNyUPhFnb4bOYAAiHBMRuRzVhJpt1eteLjAoUBAAMCAANzAAMsBA");

                break;
            case "Owl" :
                inputFile.setMedia("AgACAgIAAxkBAAMwY6qqdvDTXlQ5zEgYod13QtP9DDwAAiLBMRuRzVhJy-cqeekAAcDKAQADAgADcwADLAQ");

                break;
            case "Cat" :
                inputFile.setMedia("AgACAgIAAxkBAAMyY6qqfiuZhAZv7NDYI-OdCJ_PtDIAAiPBMRuRzVhJGV9HkWoeoq0BAAMCAANzAAMsBA");

                break;
            case "Dog" :
                inputFile.setMedia("AgACAgIAAxkBAAM0Y6qqhB7H48y2oemjKet2vOnzzAMAAiTBMRuRzVhJZBymJQlrdAkBAAMCAANzAAMsBA");

                break;
            case "Squirrel" :
                inputFile.setMedia("AgACAgIAAxkBAAM2Y6qqiqoZGEhrbkX3EbVEunHA9MoAAiXBMRuRzVhJR4ATKjNDbogBAAMCAANzAAMsBA");

                break;
        }

        sendPhoto.setPhoto(inputFile);


        try {
            execute(sendPhoto);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }



    }
}
