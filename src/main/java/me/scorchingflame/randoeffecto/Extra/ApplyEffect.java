package me.scorchingflame.randoeffecto.Extra;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;

import static me.scorchingflame.randoeffecto.CustomEffects.Blessings.SilkEffect.currentSilkHolders;
import static me.scorchingflame.randoeffecto.CustomEffects.Blessings.SoulSpeedBles.currentSoulHolders;

public class ApplyEffect {
    public static void applyEffect(Player player, Effects effects){
        if (effects.potionEffectType != null){
            player.addPotionEffect(new PotionEffect(effects.potionEffectType, effects.duration, effects.amplifier, false, false, false));
        }else{
            Integer id = effects.id;
            switch (id){
                case 16:
                    currentSilkHolders.add(player);
                    break;
                case 17:
                    currentSoulHolders.add(player);
            }
        }
    }
}
