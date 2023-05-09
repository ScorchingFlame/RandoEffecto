package me.scorchingflame.randoeffecto.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


import static me.scorchingflame.randoeffecto.Randoeffecto.currentSoulHolders;

public class removeMeSoul implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            currentSoulHolders.remove((Player) sender);
            sender.sendMessage("REMOVED!");
            return true;
        }
        return false;
    }
}
