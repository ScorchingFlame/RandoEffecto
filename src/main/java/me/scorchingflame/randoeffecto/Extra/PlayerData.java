package me.scorchingflame.randoeffecto.Extra;

import me.scorchingflame.randoeffecto.Randoeffecto;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class PlayerData {
    String path;
    FileConfiguration configuration;
    File file;
    Plugin plugin;

    public PlayerData setPath(Plugin plugin1, String loc){
        plugin = plugin1;
        path = loc;
        file = new File(plugin.getDataFolder(), path);
        if (!file.exists()){
            plugin.saveResource(path, false);
            file = new File(plugin.getDataFolder(), path);
        }
        configuration = YamlConfiguration.loadConfiguration(file);
        return this;
    }

    public  FileConfiguration loadData(){
        return configuration;
    }

    public void saveData() {
        try {
            configuration.save(file);
            Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.AQUA + "The Configuration file has been saved");
        } catch (IOException e) {
            Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "Could not save the Configuration file");
        }
    }

    public void reloadData() {
        configuration = YamlConfiguration.loadConfiguration(file);
        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.BLUE + "The Configuration file has been reload");

    }

}
