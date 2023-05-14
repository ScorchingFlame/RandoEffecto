package me.scorchingflame.randoeffecto;

import me.scorchingflame.randoeffecto.CustomEffects.setUp;
import me.scorchingflame.randoeffecto.Extra.*;
import me.scorchingflame.randoeffecto.commands.*;
import me.scorchingflame.randoeffecto.storage.crudGSON;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public final class Randoeffecto extends JavaPlugin {
    private static Randoeffecto plugin;
    public static crudGSON crudGSON;
    public static Map<String, List<List<Effects>>> playerData = new HashMap<>();
    @Override
    public void onEnable() {
        plugin = this;
        // Plugin startup logic
        saveDefaultConfig();
        try {
            crudGSON = new crudGSON().setUp("playerData/playerData.json", this);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        GetRandomBlessing.setBlessings();
        GetRandomCurse.setCurse();
        setUp.setUpEffects();
        getLogger().info("Plugin Enabled!");
        getServer().getPluginManager().registerEvents(new PlayerFirstJoin(), this);

        Objects.requireNonNull(getCommand("reloadPlayerData")).setExecutor(new reloadPlayerData());
        Objects.requireNonNull(getCommand("addMeSilk")).setExecutor(new addMeSilk());
        Objects.requireNonNull(getCommand("removeMeSilk")).setExecutor(new removeMeSilk());
        Objects.requireNonNull(getCommand("addEffect")).setExecutor(new addEffect());
        Objects.requireNonNull(getCommand("removeEffect")).setExecutor(new removeEffect());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("Plugin Disabled!");
    }

    public static Randoeffecto getPlugin(){
        return plugin;
    }
}
