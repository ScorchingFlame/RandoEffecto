package me.scorchingflame.randoeffecto.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.io.FileNotFoundException;

import static me.scorchingflame.randoeffecto.Randoeffecto.crudGSON;

public class reloadPlayerData implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        try {
            crudGSON.reload();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return true;
    }
}
