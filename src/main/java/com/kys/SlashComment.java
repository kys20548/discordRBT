package com.kys;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.interaction.SlashCommand;
import org.javacord.api.interaction.SlashCommandOption;
import org.javacord.api.interaction.SlashCommandOptionChoice;
import org.javacord.api.interaction.SlashCommandOptionType;

import java.util.Arrays;
import java.util.List;

public class SlashComment {
    public static void main(String[] args) {

        DiscordApi api = new DiscordApiBuilder()
                .setToken("OTU3ODc1MTI0OTM2MjQ1MjU4.YkFIug.nQsjkYKiIr6FqrV6-TQNp-yL2jE")
                .login().join();

        SlashCommand command =
                SlashCommand.with("channel", "A command dedicated to channels",
                        Arrays.asList(
                                SlashCommandOption.createWithOptions(SlashCommandOptionType.SUB_COMMAND_GROUP, "edit", "Edits a channel",
                                        Arrays.asList(
                                                SlashCommandOption.createWithOptions(SlashCommandOptionType.SUB_COMMAND, "allow", "Allows a permission to a user for a channel",
                                                        Arrays.asList(
                                                                SlashCommandOption.create(SlashCommandOptionType.CHANNEL, "CHANNEL", "The channel to modify", true),
                                                                SlashCommandOption.create(SlashCommandOptionType.USER, "USER", "The user which permissions should be changed", true),
                                                                SlashCommandOption.createWithChoices(SlashCommandOptionType.DECIMAL, "PERMISSION", "The permission to allow", true,
                                                                        Arrays.asList(
                                                                                SlashCommandOptionChoice.create("MANAGE", 0),
                                                                                SlashCommandOptionChoice.create("SHOW", 1)))
                                                        ))))))
                        .createGlobal(api)
                        .join();
    }
}
