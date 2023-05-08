package me.scorchingflame.randoeffecto.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static me.scorchingflame.randoeffecto.Randoeffecto.currentSilkHolders;

public class removeMeSilk implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            currentSilkHolders.remove((Player) sender);
            sender.sendMessage("REMOVED!");
            return true;
        }
        return false;
    }
}
