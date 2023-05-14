package me.scorchingflame.randoeffecto.CustomEffects.Curses;

import me.scorchingflame.randoeffecto.Extra.Effects;
import me.scorchingflame.randoeffecto.Randoeffecto;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class WitchesBrew {
    public static Map<Player, Effects> currentWitchHolder = new HashMap<>();
    public static void setUp(){
        Randoeffecto plugin = Randoeffecto.getPlugin();
        int durationOfEffect = plugin.getConfig().getInt("effects.30.effect-duration") * 20;
        Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, () -> {
            plugin.getLogger().info("Withes brew level 1");
            for (Player p:
                 currentWitchHolder.keySet()) {
                if (p.isOnline() && currentWitchHolder.get(p).getAmplifier() == 0){
                    Random random = new Random();
                    if (random.nextBoolean()){
                        p.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, durationOfEffect,0, true, true, true));
                    }else {
                        p.addPotionEffect(new PotionEffect(PotionEffectType.POISON, durationOfEffect,0, true, true, true));
                    }
                }
            }
        }, 0, plugin.getConfig().getLong("effects.30.loop-duration-level-1") * 20);
        Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, () -> {
            plugin.getLogger().info("Withes brew level 2");
            for (Player p:
                    currentWitchHolder.keySet()) {
                if (p.isOnline() && currentWitchHolder.get(p).getAmplifier() == 1){
                    Random random = new Random();
                    if (random.nextBoolean()){
                        p.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, durationOfEffect,0, true, true, true));
                    }else {
                        p.addPotionEffect(new PotionEffect(PotionEffectType.POISON, durationOfEffect,0, true, true, true));
                    }
                }
            }
        }, 0, plugin.getConfig().getLong("effects.30.loop-duration-level-2") * 20);
        Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, () -> {
            plugin.getLogger().info("Withes brew level 3");
            for (Player p:
                    currentWitchHolder.keySet()) {
                if (p.isOnline() && currentWitchHolder.get(p).getAmplifier() == 2){
                    Random random = new Random();
                    if (random.nextBoolean()){
                        p.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, durationOfEffect,0, true, true, true));
                    }else {
                        p.addPotionEffect(new PotionEffect(PotionEffectType.POISON, durationOfEffect,0, true, true, true));
                    }
                }
            }
        }, 0, plugin.getConfig().getLong("effects.30.loop-duration-level-3") * 20);
    }
}
