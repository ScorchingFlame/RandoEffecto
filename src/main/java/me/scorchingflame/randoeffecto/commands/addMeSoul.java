package me.scorchingflame.randoeffecto.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static me.scorchingflame.randoeffecto.CustomEffects.Blessings.SoulSpeedBles.currentSoulHolders;

public class addMeSoul implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            currentSoulHolders.add((Player) sender);
            sender.sendMessage("Added!");
            return true;
        }
        return false;
    }
}
