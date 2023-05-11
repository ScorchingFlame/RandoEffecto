package me.scorchingflame.randoeffecto.CustomEffects.Curses;

import me.scorchingflame.randoeffecto.Extra.Effects;
import me.scorchingflame.randoeffecto.Randoeffecto;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;

import java.util.Objects;

public class CerberusBite {
    private static int heartsTakeAway;
    public static void setUp(){
        Randoeffecto plugin = Randoeffecto.getPlugin();
        heartsTakeAway = plugin.getConfig().getInt("effects.29.hearts-take-away") * 2;
    }
    public static void addEffect(Player p, Effects effects){
        int maxHeartsTakeAway = heartsTakeAway * (effects.getAmplifier() + 1);
        Objects.requireNonNull(p.getAttribute(Attribute.GENERIC_MAX_HEALTH)).setBaseValue(Objects.requireNonNull(p.getAttribute(Attribute.GENERIC_MAX_HEALTH)).getValue() - maxHeartsTakeAway);
    }

    public static void removeEffect(Player p, Effects effects){
        int maxHeartsTakeAway = heartsTakeAway * (effects.getAmplifier() + 1);
        Objects.requireNonNull(p.getAttribute(Attribute.GENERIC_MAX_HEALTH)).setBaseValue(Objects.requireNonNull(p.getAttribute(Attribute.GENERIC_MAX_HEALTH)).getValue() + maxHeartsTakeAway);
    }
}
