package me.scorchingflame.randoeffecto.CustomEffects.Blessings;

import me.scorchingflame.randoeffecto.Randoeffecto;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.FireworkMeta;

import java.util.ArrayList;
import java.util.List;

public class FireworksFanatic {
    public static List<Player> currentFireworkHolders = new ArrayList<>();
    public static void setUp(){
        Bukkit.getScheduler().scheduleSyncRepeatingTask(Randoeffecto.getPlugin(), () -> {
            for (Player p: currentFireworkHolders){
                if (p.isOnline()){
                    Firework fw = (Firework) p.getWorld().spawnEntity(p.getLocation(), EntityType.FIREWORK);
                    FireworkMeta fwm = fw.getFireworkMeta();
                    FireworkEffect.Type type = FireworkEffect.Type.BALL_LARGE;
                    Color c1 = Color.WHITE;
                    Color c2 = Color.WHITE;
                    FireworkEffect effect = FireworkEffect.builder().flicker(true).withColor(c1).withFade(c2).with(type).trail(true).build();
                    fwm.addEffect(effect);
                    fwm.setPower(2);
                    fw.setFireworkMeta(fwm);
                }
            }
        }, 0, 20L * Randoeffecto.getPlugin().getConfig().getLong("effects.19.loop-duration"));
    }
}
