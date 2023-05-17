package me.scorchingflame.randoeffecto;

import me.scorchingflame.randoeffecto.CustomEffects.setUp;
import me.scorchingflame.randoeffecto.Extra.*;
import me.scorchingflame.randoeffecto.Miscellaneous.playerHeadsSetUp;
import me.scorchingflame.randoeffecto.commands.*;
import me.scorchingflame.randoeffecto.config.configSetUp;
import me.scorchingflame.randoeffecto.events.PlayerFirstJoin;
import me.scorchingflame.randoeffecto.events.PlayerLeaveEvent;
import me.scorchingflame.randoeffecto.storage.crudGSON;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

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
        playerHeadsSetUp.setUp();
        configSetUp.setUp(getConfig());
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
        getServer().getPluginManager().registerEvents(new PlayerLeaveEvent(), this);

        myEffects.setUp();
        RandomEffectCommands.setUp();

        for (Player p:
             getServer().getOnlinePlayers()) {
            for (List<Effects> listPlayer:
                 playerData.get(p.getUniqueId().toString())) {
                for (Effects effects:
                     listPlayer) {
                    if (effects.isCustomEffect()){
                        ApplyEffect.applyEffectWithoutSave(p,effects);
                    }
                }
            }
        }

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
