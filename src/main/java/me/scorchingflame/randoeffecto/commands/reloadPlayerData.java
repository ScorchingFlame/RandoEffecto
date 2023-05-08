package me.scorchingflame.randoeffecto.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import static me.scorchingflame.randoeffecto.Randoeffecto.playerDataF;

public class reloadPlayerData implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        playerDataF.reloadData();
        return true;
    }
}
