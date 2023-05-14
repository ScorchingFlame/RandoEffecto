package me.scorchingflame.randoeffecto.Extra;

import org.bukkit.potion.PotionEffectType;

import java.util.*;

public class GetRandomCurse {
    public static Map<Integer, Effects> Curse = new HashMap<>();
    public static void setCurse(){
        Curse.put(21, new Effects(21, PotionEffectType.SLOW.getName(), 0));
        Curse.put(22, new Effects(22, PotionEffectType.SLOW_FALLING.getName(), 0));
        Curse.put(23, new Effects(23, PotionEffectType.UNLUCK.getName(), 0));
        Curse.put(24, new Effects(24, PotionEffectType.GLOWING.getName(), 0));
        Curse.put(25, new Effects(25, PotionEffectType.WEAKNESS.getName(), 0));
        Curse.put(26, new Effects(26, PotionEffectType.UNLUCK.getName(), 0));
        Curse.put(27, new Effects(27, 0));
        Curse.put(28, new Effects(28, 0));
        Curse.put(29, new Effects(29, 0));
        Curse.put(30, new Effects(30, 0));
        Curse.put(31, new Effects(31, 0));
        Curse.put(32, new Effects(32, 0));
        Curse.put(33, new Effects(33, 0));
        Curse.put(34, new Effects(34, 0));
        Curse.put(35, new Effects(35, 0));
        Curse.put(36, new Effects(36, 0));
        Curse.put(37, new Effects(37, 0));
        Curse.put(38, new Effects(38, 0));
    }
    public static RanPotion getRandomCurse(){
        Random random = new Random();
        List<Integer> keys = new ArrayList<>(Curse.keySet());
        Integer randomKey = keys.get(random.nextInt(keys.size()));
        Effects curse = Curse.get(randomKey);
        return new RanPotion(randomKey, curse);
    }
}
