package me.scorchingflame.randoeffecto.CustomEffects.Curses;

import me.scorchingflame.randoeffecto.Extra.Effects;
import me.scorchingflame.randoeffecto.Randoeffecto;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.HashMap;
import java.util.Map;

public class ToadNausea {
    public static Map<Player, Effects> currentNauseaHolders = new HashMap<>();
    public static void setUp(){
        Randoeffecto plugin = Randoeffecto.getPlugin();
        int effectDuration = plugin.getConfig().getInt("effects.34.effect-duration");
        Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, () -> {
            for (Player p:
                 currentNauseaHolders.keySet()) {
                if (p.isOnline()){
                    int amplifier = currentNauseaHolders.get(p).getAmplifier() + 1;
                    int finalDuration = effectDuration * amplifier * 20;
                    p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, finalDuration, 0, false, false, false));
                }
            }
        }, 0, plugin.getConfig().getLong("effects.34.loop-duration") * 20);
    }
}
