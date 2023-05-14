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

public class BatConfusion {
    public static Map<Player, Effects> currentBatConfusionHolder = new HashMap<>();
    public static void setUp(){
        Randoeffecto plugin = Randoeffecto.getPlugin();
        int min = plugin.getConfig().getInt("effects.35.min");
        int max = plugin.getConfig().getInt("effects.35.max");
        Random random = new Random();
        int durationTemplate = max - min + 1;
        Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, () -> {
            for (Player p:
                 currentBatConfusionHolder.keySet()) {
                if (p.isOnline()){
                    int duration = random.nextInt(durationTemplate) + min;
                    p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, duration, 0, false, false, false));
                }
            }
        }, 0, plugin.getConfig().getLong("effects.35.loop-duration") * 20);
    }
}
