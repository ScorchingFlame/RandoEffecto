package me.scorchingflame.randoeffecto.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import static me.scorchingflame.randoeffecto.Randoeffecto.currentSilkHolders;

public class addMeSilk implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            currentSilkHolders.add((Player) sender);
            sender.sendMessage("Added!");
            return true;
        }
        return false;
    }
}
