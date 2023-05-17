package me.scorchingflame.randoeffecto.commands;


import dev.jorel.commandapi.CommandAPICommand;
import dev.jorel.commandapi.arguments.ArgumentSuggestions;
import dev.jorel.commandapi.arguments.StringArgument;
import me.scorchingflame.randoeffecto.menus.addEffect.BlessingOrCurse;
import me.scorchingflame.randoeffecto.menus.allEffects;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class RandomEffectCommands {
    public static void setUp(){
        new CommandAPICommand("randoeffecto")
                .withShortDescription("All the plugin commands of the plugin RandoEffecto.")
                .withFullDescription("Sends the help message.")
                .executes((sender, args) -> {sender.sendMessage("Execute /help randoeffecto for the help message.");})
                .withSubcommand(new CommandAPICommand(
                        "allEffects"
                )
                                .executesPlayer((sender, args) -> {
                                    allEffects.allEffectsMenu.open(sender);
                                })
                                .withShortDescription("Shows all the effects available.")
                                .withFullDescription("Shows all the effects available.")
                )
                .withSubcommand(
                        new CommandAPICommand("addEffect")
                                .withShortDescription("Adds effect to the mentioned player")
                                .withFullDescription("Adds effect to the mentioned player")
                                .withPermission("randoeffecto.admin.addeffects")
                                .withArguments(new StringArgument("player").replaceSuggestions(
                                        ArgumentSuggestions.strings(
                                                Arrays.stream(Bukkit.getOfflinePlayers()).map(OfflinePlayer::getName)
                                                        .collect(Collectors.toList())
                                        )
                                ))
                                .executesPlayer((sender, args) -> {
                                    Arrays.stream(Bukkit.getOfflinePlayers()).filter(offlinePlayer -> Objects.equals(offlinePlayer.getName(), args.get(0))).findFirst().ifPresent(
                                            offlinePlayer -> BlessingOrCurse.getBlessingOrCurseMenu(offlinePlayer.getUniqueId().toString()).open(sender)
                                    );
                                })
                )
                .withSubcommand(
                        new CommandAPICommand("effects")
                                .withShortDescription("Allows you to view other player's effect")
                                .withFullDescription("Allows you to view other player's effect")
                                .withPermission("randoeffecto.admin.vieweffects")
                                .withArguments(new StringArgument("player").replaceSuggestions(
                                        ArgumentSuggestions.strings(
                                                Arrays.stream(Bukkit.getOfflinePlayers()).map(OfflinePlayer::getName)
                                                        .collect(Collectors.toList())
                                        )
                                ))
                                .executesPlayer(
                                        (sender, args) -> {
                                            Arrays.stream(Bukkit.getOfflinePlayers()).filter(offlinePlayer -> Objects.equals(offlinePlayer.getName(), args.get(0))).findFirst().ifPresent(
                                                    offlinePlayer -> me.scorchingflame.randoeffecto.menus.myEffects.getMyEffectGui(offlinePlayer.getUniqueId().toString(), false).open(sender)
                                            );
                                        }
                                )
                )
                .register();
    }
}
