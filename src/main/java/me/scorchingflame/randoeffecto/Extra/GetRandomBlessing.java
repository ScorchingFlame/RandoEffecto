package me.scorchingflame.randoeffecto.Extra;

import org.bukkit.potion.PotionEffectType;

import java.util.*;

public class GetRandomBlessing {
    public static Map<Integer, Effects> blessing = new HashMap<>();
    public static void setBlessings(){
        blessing.put(1, new Effects(1, PotionEffectType.REGENERATION.getName(), 0));
        blessing.put(2, new Effects(2, PotionEffectType.SPEED.getName(), 0));
        blessing.put(3, new Effects(3, PotionEffectType.FIRE_RESISTANCE.getName(), 0));
        blessing.put(4, new Effects(4, PotionEffectType.NIGHT_VISION.getName(), 0));
        blessing.put(5, new Effects(5, PotionEffectType.JUMP.getName(), 0));
        blessing.put(6, new Effects(6, PotionEffectType.WATER_BREATHING.getName(), 0));
        blessing.put(7, new Effects(7, PotionEffectType.INVISIBILITY.getName(), 0));
        blessing.put(8, new Effects(8, PotionEffectType.FAST_DIGGING.getName(), 0));
        blessing.put(9, new Effects(9, PotionEffectType.HEALTH_BOOST.getName(), 0));
        blessing.put(10, new Effects(10, PotionEffectType.SATURATION.getName(), 0));
        blessing.put(11, new Effects(11, PotionEffectType.HERO_OF_THE_VILLAGE.getName(), 0));
        blessing.put(12, new Effects(12, PotionEffectType.CONDUIT_POWER.getName(), 0));
        blessing.put(13, new Effects(13, PotionEffectType.DOLPHINS_GRACE.getName(), 0));
        blessing.put(14, new Effects(14, PotionEffectType.DAMAGE_RESISTANCE.getName(), 0));
        blessing.put(15, new Effects(15, PotionEffectType.INCREASE_DAMAGE.getName(), 0));
        blessing.put(16, new Effects(16, 0)); // Silk touch id: 16
        blessing.put(17, new Effects(17, 0)); // Soul Speed id: 17
        blessing.put(18, new Effects(18, 0));
        blessing.put(19, new Effects(19, 0));
        blessing.put(20, new Effects(20, 0));
        Boots.setBoots();
    }

    public static RanPotion getRandomBlessing(){
        Random random = new Random();
        List<Integer> keys = new ArrayList<>(blessing.keySet());
        Integer randomKey = keys.get(random.nextInt(keys.size()));
        Effects bles = blessing.get(randomKey);
        return new RanPotion(randomKey, bles);
    }
}
