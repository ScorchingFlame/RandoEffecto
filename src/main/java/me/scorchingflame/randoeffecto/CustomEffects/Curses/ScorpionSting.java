package me.scorchingflame.randoeffecto.CustomEffects.Curses;

import me.scorchingflame.randoeffecto.Extra.Effects;
import me.scorchingflame.randoeffecto.Randoeffecto;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.HashMap;
import java.util.Map;

public class ScorpionSting {
    public static Map<Player, Effects> currentStingHolders = new HashMap<>();
    public static void setUp(){
        Bukkit.getScheduler().scheduleSyncRepeatingTask(Randoeffecto.getPlugin(), () -> {
            for (Player p:
                    currentStingHolders.keySet()) {
                if (p.isOnline() && currentStingHolders.get(p).getAmplifier() == 0){
                    p.addPotionEffect(new PotionEffect(PotionEffectType.HARM, 1,
                                                        0, false, false, false));
                }
            }
        }, 0 , Randoeffecto.getPlugin().getConfig().getLong("effects.28.loop-duration-level-1") * 20);
        Bukkit.getScheduler().scheduleSyncRepeatingTask(Randoeffecto.getPlugin(), () -> {
            for (Player p:
                    currentStingHolders.keySet()) {
                if (p.isOnline() && currentStingHolders.get(p).getAmplifier() == 1){
                    p.addPotionEffect(new PotionEffect(PotionEffectType.HARM, 1,
                            0, false, false, false));
                }
            }
        }, 0 , Randoeffecto.getPlugin().getConfig().getLong("effects.28.loop-duration-level-2") * 20);
        Bukkit.getScheduler().scheduleSyncRepeatingTask(Randoeffecto.getPlugin(), () -> {
            for (Player p:
                    currentStingHolders.keySet()) {
                if (p.isOnline() && currentStingHolders.get(p).getAmplifier() == 2){
                    p.addPotionEffect(new PotionEffect(PotionEffectType.HARM, 1,
                            0, false, false, false));
                }
            }
        }, 0 , Randoeffecto.getPlugin().getConfig().getLong("effects.28.loop-duration-level-3") * 20);
    }
}
