package me.scorchingflame.randoeffecto;

import me.scorchingflame.randoeffecto.Extra.*;
import me.scorchingflame.randoeffecto.commands.addMeSilk;
import me.scorchingflame.randoeffecto.commands.reloadPlayerData;
import me.scorchingflame.randoeffecto.commands.removeMeSilk;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.*;

public final class Randoeffecto extends JavaPlugin {
    public static List<Player> currentSilkHolders = new ArrayList<>();
    public static List<Player> currentSoulHolders = new ArrayList<>();
    public static PlayerData playerDataF;
    @Override
    public void onEnable() {
        // Plugin startup logic
        GetRandomBlessing.setBlessings();
        Boots.setBoots();
        getLogger().info("Plugin Enabled!");
        playerDataF = new PlayerData().setPath(this, "PlayerData/playerData.yml");
        getServer().getPluginManager().registerEvents(new PlayerFirstJoin(), this);
        getServer().getPluginManager().registerEvents(new SilkEffect(), this);
        getServer().getPluginManager().registerEvents(new SoulSpeedBles(), this);
        Objects.requireNonNull(getCommand("reloadPlayerData")).setExecutor(new reloadPlayerData());
        Objects.requireNonNull(getCommand("addMeSilk")).setExecutor(new addMeSilk());
        Objects.requireNonNull(getCommand("removeMeSilk")).setExecutor(new removeMeSilk());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("Plugin Disabled!");
    }
}
