package me.scorchingflame.randoeffecto.CustomEffects.Curses;

import me.scorchingflame.randoeffecto.Extra.Effects;
import me.scorchingflame.randoeffecto.Randoeffecto;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class VulturesHunger {
    public static Map<Player, Effects> currentVultureHungerHolders = new HashMap<>();

    public static void setUp(){
        Randoeffecto plugin = Randoeffecto.getPlugin();
        int takeAway = plugin.getConfig().getInt("effects.27.slice-off-hunger-level");
        Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, () -> {
            for (Player p :
                 currentVultureHungerHolders.keySet()) {
                if (p.isOnline() && currentVultureHungerHolders.get(p).getAmplifier() == 0){
                    int foodLevelAfter = p.getFoodLevel() - takeAway;
                    if (foodLevelAfter > 2){
                        p.setFoodLevel(foodLevelAfter);
                        p.playSound(p, Sound.ENTITY_PHANTOM_BITE, 1f, 1f);
                    }
                }
            }
        }, 0, 20 * plugin.getConfig().getLong("effects.27.loop-duration-level-1"));
        Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, () -> {
            for (Player p :
                    currentVultureHungerHolders.keySet()) {
                if (p.isOnline() && currentVultureHungerHolders.get(p).getAmplifier() == 1){
                    int foodLevelAfter = p.getFoodLevel() - takeAway;
                    if (foodLevelAfter > 2){
                        p.setFoodLevel(foodLevelAfter);
                        p.playSound(p, Sound.ENTITY_PHANTOM_BITE, 1f, 1f);
                    }
                }
            }
        }, 0, 20 * plugin.getConfig().getLong("effects.27.loop-duration-level-2"));
        Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, () -> {
            for (Player p :
                    currentVultureHungerHolders.keySet()) {
                if (p.isOnline() && currentVultureHungerHolders.get(p).getAmplifier() == 2){
                    int foodLevelAfter = p.getFoodLevel() - takeAway;
                    if (foodLevelAfter > 2){
                        p.setFoodLevel(foodLevelAfter);
                        p.playSound(p, Sound.ENTITY_PHANTOM_BITE, 1f, 1f);
                    }
                }
            }
        }, 0, 20 * plugin.getConfig().getLong("effects.27.loop-duration-level-3"));
    }
}
