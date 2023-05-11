package me.scorchingflame.randoeffecto.CustomEffects.Curses;

import me.scorchingflame.randoeffecto.Extra.Effects;
import me.scorchingflame.randoeffecto.Randoeffecto;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class ZeusNemesis {
    public static Map<Player, Effects> currentZeusEnemies = new HashMap<>();
    public static void setUp(){
        Randoeffecto plugin = Randoeffecto.getPlugin();
        Bukkit.getScheduler().scheduleSyncRepeatingTask(
                plugin,
                () -> {
                    for (Player p:
                         currentZeusEnemies.keySet()) {
                        if (currentZeusEnemies.get(p).getAmplifier() == 0 && p.isOnline()){
                            p.getWorld().strikeLightning(p.getLocation());
                        }
                    }
                }, 0, plugin.getConfig().getLong("effects.37.loop-duration-level-1") * 20
        );
        Bukkit.getScheduler().scheduleSyncRepeatingTask(
                plugin,
                () -> {
                    for (Player p:
                            currentZeusEnemies.keySet()) {
                        if (currentZeusEnemies.get(p).getAmplifier() == 1 && p.isOnline()){
                            p.getWorld().strikeLightning(p.getLocation());
                        }
                    }
                }, 0, plugin.getConfig().getLong("effects.37.loop-duration-level-2") * 20
        );
        Bukkit.getScheduler().scheduleSyncRepeatingTask(
                plugin,
                () -> {
                    for (Player p:
                            currentZeusEnemies.keySet()) {
                        if (currentZeusEnemies.get(p).getAmplifier() == 2 && p.isOnline()){
                            p.getWorld().strikeLightning(p.getLocation());
                        }
                    }
                }, 0, plugin.getConfig().getLong("effects.37.loop-duration-level-3") * 20
        );
    }
}
