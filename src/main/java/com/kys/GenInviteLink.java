package com.kys;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;

public class GenInviteLink {
    public static void main(String[] args) {

        DiscordApi api = new DiscordApiBuilder().setToken("OTU3ODc1MTI0OTM2MjQ1MjU4.YkFIug.nQsjkYKiIr6FqrV6-TQNp-yL2jE").login().join();

        System.out.println(api.createBotInvite());
    }
}
