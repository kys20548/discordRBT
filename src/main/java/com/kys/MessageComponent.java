package com.kys;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.message.Message;
import org.javacord.api.interaction.MessageComponentInteraction;

public class MessageComponent {
    public static void main(String[] args) {

        DiscordApi api = new DiscordApiBuilder().setToken("OTU3ODc1MTI0OTM2MjQ1MjU4.YkFIug.nQsjkYKiIr6FqrV6-TQNp-yL2jE").login().join();

        api.addMessageComponentCreateListener(event -> {
            MessageComponentInteraction messageComponentInteraction = event.getMessageComponentInteraction();
            String customId = messageComponentInteraction.getCustomId();

            switch (customId) {
                case "success":
                    messageComponentInteraction.createImmediateResponder()
                            .setContent("You clicked a button!")
                            .respond();
                    break;
                case "danger":
                    //messageComponentInteraction.getMessage().ifPresent(Message::delete);
                    break;
                case "secondary":
                    messageComponentInteraction.respondLater().thenAccept(interactionOriginalResponseUpdater -> {
                        //Code to respond after 5 minutes
                    });
                    break;
                case "options":
                    messageComponentInteraction.createImmediateResponder()
                            .setContent("You selected an option in a select menu!")
                            .respond();
                    break;
            }
        });
    }
}
