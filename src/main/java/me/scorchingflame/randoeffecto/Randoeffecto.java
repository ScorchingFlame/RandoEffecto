package me.scorchingflame.randoeffecto;

import me.scorchingflame.randoeffecto.CustomEffects.Blessings.SilkEffect;
import me.scorchingflame.randoeffecto.CustomEffects.Blessings.SoulSpeedBles;
import me.scorchingflame.randoeffecto.CustomEffects.setUp;
import me.scorchingflame.randoeffecto.Extra.*;
import me.scorchingflame.randoeffecto.commands.*;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.*;

public final class Randoeffecto extends JavaPlugin {
    private static Randoeffecto plugin;
    public static PlayerData playerDataF;
    @Override
    public void onEnable() {
        plugin = this;
        // Plugin startup logic
        saveDefaultConfig();
        GetRandomBlessing.setBlessings();
        setUp.setUpEffects();
        getLogger().info("Plugin Enabled!");
        playerDataF = new PlayerData().setPath(this, "PlayerData/playerData.yml");
        getServer().getPluginManager().registerEvents(new PlayerFirstJoin(), this);

        Objects.requireNonNull(getCommand("reloadPlayerData")).setExecutor(new reloadPlayerData());
        Objects.requireNonNull(getCommand("addMeSilk")).setExecutor(new addMeSilk());
        Objects.requireNonNull(getCommand("removeMeSilk")).setExecutor(new removeMeSilk());
        Objects.requireNonNull(getCommand("addMeSoul")).setExecutor(new addMeSoul());
        Objects.requireNonNull(getCommand("removeMeSoul")).setExecutor(new removeMeSoul());
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
