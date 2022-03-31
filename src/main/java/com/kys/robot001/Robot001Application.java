package com.kys.robot001;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.permission.Role;
import org.javacord.api.entity.server.Server;
import org.javacord.api.entity.user.User;
import org.javacord.api.entity.user.UserStatus;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@SpringBootApplication
public class Robot001Application {

    private static final Long serverId = 957569867056283688L;
    private static final Long ownerId = 840579123084787753L;// me
    //private static final Long ownerId = 365695914989453313;// yixian

    public static void main(String[] args) {
        SpringApplication.run(Robot001Application.class, args);

        // Log the bot in
        DiscordApi api = new DiscordApiBuilder()
                .setToken("OTU3ODc1MTI0OTM2MjQ1MjU4.YkFIug.nQsjkYKiIr6FqrV6-TQNp-yL2jE")
                .setAllIntents()
                .login().join();

        int memberCount = api.getServerById(serverId).get().getMemberCount();
        Server server = api.getServerById(serverId).get();
        List<Role> roles = server.getRoles();

        Set<User> set = (Set<User>) api.getServerById(serverId).get().getMembers();
        User[] userArray = set.toArray(new User[set.size()]);
        List<User> allUserList = set.stream().collect(Collectors.toList());
        List<User> allOnlineList = set.stream().filter(x -> x.getStatus().equals(UserStatus.ONLINE)).collect(Collectors.toList());

        // Add a listener which answers with "Pong!" if someone writes "!ping"
        api.addMessageCreateListener(event -> {
            if (event.getMessageContent().equalsIgnoreCase("!ping")) {
                event.getChannel().sendMessage("Pong!");

            }

            if (event.getMessageAuthor().getId() == ownerId) {

                if (event.getMessageContent().equalsIgnoreCase("!ggAllUser")) {
                    int randomNum = ThreadLocalRandom.current().nextInt(0, memberCount );
                    //event.getChannel().sendMessage("候選名單有 : ");
                    //allUserList.stream().forEach(x->event.getChannel().sendMessage((x.getDisplayName(server))));
                    event.getChannel().sendMessage("the winner is :");
                    event.getChannel().sendMessage("the winner is :");
                    event.getChannel().sendMessage("the winner is :");
                    event.getChannel().sendMessage("the winner is :");
                    event.getChannel().sendMessage(allUserList.get(randomNum).getDisplayName(server));

                }

                if (event.getMessageContent().equalsIgnoreCase("!ggAllOnline")) {
                    int randomNum = ThreadLocalRandom.current().nextInt(0, memberCount );
                    //event.getChannel().sendMessage("候選名單有 : ");
                    //allOnlineList.stream().forEach(x->event.getChannel().sendMessage((x.getDisplayName(server))));
                    event.getChannel().sendMessage("the winner is :");
                    event.getChannel().sendMessage("the winner is :");
                    event.getChannel().sendMessage("the winner is :");
                    event.getChannel().sendMessage("the winner is :");
                    event.getChannel().sendMessage(allOnlineList.get(randomNum).getDisplayName(server));

                }

                if (event.getMessageContent().contains("!ggRoleOnline_")) {
                    String[] str = event.getMessageContent().split("_");
                    HashSet<User> rl = (HashSet) roles.stream().filter(x->x.getName().equals(str[1])).findFirst().get().getUsers();
                    List<User> result = rl.stream().filter(x->x.getStatus().equals(UserStatus.ONLINE)).collect(Collectors.toList());
                    //event.getChannel().sendMessage("候選名單有 : ");
                    //result.stream().forEach(x->event.getChannel().sendMessage((x.getDisplayName(server))));
                    int randomNum = ThreadLocalRandom.current().nextInt(0, result.size() );
                    event.getChannel().sendMessage("the winner is :");
                    event.getChannel().sendMessage("the winner is :");
                    event.getChannel().sendMessage("the winner is :");
                    event.getChannel().sendMessage("the winner is :");
                    event.getChannel().sendMessage(result.get(randomNum).getDisplayName(server));

                }

                if (event.getMessageContent().contains("!ggRoleOffline_")) {
                    String[] str = event.getMessageContent().split("_");
                    HashSet<User> rl = (HashSet) roles.stream().filter(x->x.getName().equals(str[1])).findFirst().get().getUsers();
                    List<User> result = rl.stream().collect(Collectors.toList());
                    //event.getChannel().sendMessage("候選名單有 : ");
                    //result.stream().forEach(x->event.getChannel().sendMessage((x.getDisplayName(server))));
                    int randomNum = ThreadLocalRandom.current().nextInt(0, result.size() );
                    event.getChannel().sendMessage("the winner is :");
                    event.getChannel().sendMessage("the winner is :");
                    event.getChannel().sendMessage("the winner is :");
                    event.getChannel().sendMessage("the winner is :");
                    event.getChannel().sendMessage(result.get(randomNum).getDisplayName(server));

                }

                if (event.getMessageContent().contains("!roleList")) {
                    roles.stream().forEach(x->event.getChannel().sendMessage((x.getName())));

                }

            }
        });


        System.out.println("You can invite the bot by using the following url: " + api.createBotInvite());


    }

}
