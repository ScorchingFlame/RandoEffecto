package me.scorchingflame.randoeffecto.commands;

import me.scorchingflame.randoeffecto.Extra.ApplyEffect;
import me.scorchingflame.randoeffecto.Extra.Effects;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class addEffect implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player p = (Player) sender;

            return true;
        }
        return false;
    }
}
