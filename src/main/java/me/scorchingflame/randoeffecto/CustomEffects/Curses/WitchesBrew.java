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
            for (Player p:
                 currentWitchHolder.keySet()) {
                if (p.isOnline()){
                    Random random = new Random();
                    if (random.nextBoolean()){
                        p.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, durationOfEffect, currentWitchHolder.get(p).getAmplifier(), false, false, false));
                    }else {
                        p.addPotionEffect(new PotionEffect(PotionEffectType.POISON, durationOfEffect, currentWitchHolder.get(p).getAmplifier(), false, false, false));
                    }
                }
            }
        }, 0, plugin.getConfig().getLong("effects.30.loop-duration") * 20);
    }
}
