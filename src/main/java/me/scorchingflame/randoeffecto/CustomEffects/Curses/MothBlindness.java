package me.scorchingflame.randoeffecto.CustomEffects.Curses;

import me.scorchingflame.randoeffecto.Extra.Effects;
import me.scorchingflame.randoeffecto.Randoeffecto;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.HashMap;
import java.util.Map;

public class MothBlindness {
    public static Map<Player, Effects> currentMothHolders = new HashMap<>();
    public static void setUp(){
        Randoeffecto plugin = Randoeffecto.getPlugin();
        int effectDuration = plugin.getConfig().getInt("effects.32.effect-duration");
        Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            @Override
            public void run() {
                for (Player p:
                     currentMothHolders.keySet()) {
                    if (currentMothHolders.get(p).getAmplifier() == 0 && p.isOnline()){
                        p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, effectDuration, 0, false, false, false));
                    }
                }
            }
        }, 0 , plugin.getConfig().getLong("effects.32.loop-duration-level-1") * 20);
        Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            @Override
            public void run() {
                for (Player p:
                        currentMothHolders.keySet()) {
                    if (currentMothHolders.get(p).getAmplifier() == 1 && p.isOnline()){
                        p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, effectDuration, 0, false, false, false));
                    }
                }
            }
        }, 0 , plugin.getConfig().getLong("effects.32.loop-duration-level-2") * 20);
        Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            @Override
            public void run() {
                for (Player p:
                        currentMothHolders.keySet()) {
                    if (currentMothHolders.get(p).getAmplifier() == 2 && p.isOnline()){
                        p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, effectDuration, 0, false, false, false));
                    }
                }
            }
        }, 0 , plugin.getConfig().getLong("effects.32.loop-duration-level-3") * 20);
    }
}
