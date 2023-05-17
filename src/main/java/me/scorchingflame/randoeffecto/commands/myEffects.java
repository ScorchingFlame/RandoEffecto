package me.scorchingflame.randoeffecto.commands;

import dev.jorel.commandapi.CommandAPICommand;

public class myEffects {
    public static void setUp(){
        new CommandAPICommand("myEffects").executesPlayer((sender, args) -> {
            sender.sendMessage("Hi");
            me.scorchingflame.randoeffecto.menus.myEffects.getMyEffectGui(sender.getUniqueId().toString(), true).open(sender);

        }).withSubcommand(
                new CommandAPICommand("Ping")
                        .executes(((sender, args) -> {
                            sender.sendMessage("Pong!");
                        }))
        ).register();
    }
}
