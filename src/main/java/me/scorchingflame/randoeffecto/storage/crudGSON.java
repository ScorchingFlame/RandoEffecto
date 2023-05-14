package me.scorchingflame.randoeffecto.storage;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import me.scorchingflame.randoeffecto.Extra.Effects;
import me.scorchingflame.randoeffecto.Randoeffecto;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class crudGSON {
    private String path;
    private File file;
    private Plugin plugin;
    private Gson gson;

    public crudGSON setUp(String path, Plugin plugin) throws IOException {
        this.plugin = plugin;
        this.path = path;
        file = new File(plugin.getDataFolder(), path);
        this.gson = new GsonBuilder().setPrettyPrinting().create();
        if (!file.exists()){
            plugin.saveResource("playerData/playerData.json", false);
            file = new File(plugin.getDataFolder(), path);
        }else {
            Reader reader = new FileReader(file);
            plugin.getLogger().info("Loading data from " + path);
            Map<String, List<List<Effects>>> map = gson.fromJson(reader, new TypeToken<Map<String, List<List<Effects>>>>(){}.getType());
            if (map != null){
                Randoeffecto.playerData = map;
                plugin.getLogger().info("Successfully loaded player data from " + path);
            }else{
                plugin.getLogger().info("No data found from " + path);
            }

        }
        return this;
    }

    public void save() throws IOException {
        Writer writer = new FileWriter(file, false);
        gson.toJson(Randoeffecto.playerData, new TypeToken<Map<String, List<List<Effects>>>>(){}.getType() ,writer);
        writer.flush();
        writer.close();
    }

    public void reload() throws FileNotFoundException {
        Reader reader = new FileReader(file);
        plugin.getLogger().info("Reloading data from " + path);
        Map<String, List<List<Effects>>> map = gson.fromJson(reader, new TypeToken<Map<String, List<List<Effects>>>>(){}.getType());
        if (map != null){
            Randoeffecto.playerData = map;
            plugin.getLogger().info("Successfully reloaded player data from " + path);
        }else{
            Randoeffecto.playerData = new HashMap<>();
            plugin.getLogger().info("No Data found from " + path);
        }
    }
}
