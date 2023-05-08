package me.scorchingflame.randoeffecto.Extra;

import org.bukkit.potion.PotionEffectType;

import java.util.*;

public class GetRandomBlessing {
    public static Map<Integer, PotionEffectType> blessing = new HashMap<>();
    public static void setBlessings(){
        blessing.put(1, PotionEffectType.REGENERATION);
        blessing.put(2, PotionEffectType.SPEED);
        blessing.put(3, PotionEffectType.FIRE_RESISTANCE);
        blessing.put(4, PotionEffectType.NIGHT_VISION);
        blessing.put(5, PotionEffectType.JUMP);
        blessing.put(6, PotionEffectType.WATER_BREATHING);
        blessing.put(7, PotionEffectType.INVISIBILITY);
        blessing.put(8, PotionEffectType.FAST_DIGGING);
        blessing.put(9, PotionEffectType.HEALTH_BOOST);
        blessing.put(10, PotionEffectType.SATURATION);
        blessing.put(11, PotionEffectType.HERO_OF_THE_VILLAGE);
        blessing.put(12, PotionEffectType.CONDUIT_POWER);
        blessing.put(13, PotionEffectType.DOLPHINS_GRACE);
        blessing.put(14, PotionEffectType.DAMAGE_RESISTANCE);
    }

    public static RanPotion getRandomBlessing(){
        Random random = new Random();
        List<Integer> keys = new ArrayList<Integer>(blessing.keySet());
        Integer randomKey = keys.get(random.nextInt(keys.size()));
        PotionEffectType bles = blessing.get(randomKey);
        return new RanPotion(randomKey, bles);
    }
}
