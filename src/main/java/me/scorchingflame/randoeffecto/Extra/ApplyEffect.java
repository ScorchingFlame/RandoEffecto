package me.scorchingflame.randoeffecto.Extra;

import me.scorchingflame.randoeffecto.CustomEffects.Blessings.FireworksFanatic;
import me.scorchingflame.randoeffecto.CustomEffects.Blessings.FortunateExplorer;
import me.scorchingflame.randoeffecto.CustomEffects.Blessings.PoisonAttackEntity;
import me.scorchingflame.randoeffecto.CustomEffects.Curses.*;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;

import static me.scorchingflame.randoeffecto.CustomEffects.Blessings.SilkEffect.currentSilkHolders;
import static me.scorchingflame.randoeffecto.CustomEffects.Blessings.SoulSpeedBles.currentSoulHolders;
import static me.scorchingflame.randoeffecto.Randoeffecto.playerData;

public class ApplyEffect {
    public static void applyEffect(Player player, Effects effects){
        if (effects.getPotionEffectType() != null){
            player.addPotionEffect(new PotionEffect(effects.getPotionEffectType(), effects.getDuration(), effects.getAmplifier(), false, false, false));
        }else{
            Integer id = effects.getId();
            switch (id){
                case 16:
                    currentSilkHolders.add(player);
                    break;
                case 17:
                    currentSoulHolders.put(player, effects);
                    break;
                case 18:
                    FortunateExplorer.currentFortuneHolders.put(player, effects);
                    break;
                case 19:
                    FireworksFanatic.currentFireworkHolders.put(player, effects);
                    break;
                case 20:
                    PoisonAttackEntity.currentPoisonAttackEntityHolders.put(player, effects);
                    break;
                case 27:
                    VulturesHunger.currentVultureHungerHolders.put(player, effects);
                    break;
                case 28:
                    ScorpionSting.currentStingHolders.put(player, effects);
                    break;
                case 29:
                    CerberusBite.addEffect(player, effects);
                    break;
                case 30:
                    WitchesBrew.currentWitchHolder.put(player, effects);
                    break;
                case 31:
                    CurseOfCurses.addEffect(player, effects);
                    break;
                case 32:
                    MothBlindness.currentMothHolders.put(player, effects);
                    break;
                case 33:
                    Karma.currentKarmaHolders.put(player, effects);
                    break;
                case 34:
                    ToadNausea.currentNauseaHolders.put(player, effects);
                    break;
                case 35:
                    BatConfusion.currentBatConfusionHolder.put(player, effects);
                    break;
                case 36:
                    CurseOfInsanity.currentInsanityHolders.put(player, effects);
                    break;
                case 37:
                    ZeusNemesis.currentZeusEnemies.put(player, effects);
                    break;
                case 38:
                    SlipperyHands.currentSlipperyHandPeople.put(player, effects);
                    break;
            }
        }
    }

    public static void removeEffect(Player player, Effects effects){
        if (!effects.isCustomEffect()){
            player.removePotionEffect(effects.getPotionEffectType());
        }else{
            Integer id = effects.getId();
            switch (id){
                case 16:
                    currentSilkHolders.remove(player);
                    break;
                case 17:
                    currentSoulHolders.remove(player);
                    break;
                case 18:
                    FortunateExplorer.currentFortuneHolders.remove(player);
                    break;
                case 19:
                    FireworksFanatic.currentFireworkHolders.remove(player);
                    break;
                case 20:
                    PoisonAttackEntity.currentPoisonAttackEntityHolders.remove(player);
                    break;
                case 27:
                    VulturesHunger.currentVultureHungerHolders.remove(player);
                    break;
                case 28:
                    ScorpionSting.currentStingHolders.remove(player);
                    break;
                case 29:
                    CerberusBite.removeEffect(player, effects);
                    break;
                case 30:
                    WitchesBrew.currentWitchHolder.remove(player);
                    break;
                case 31:
                    CurseOfCurses.removeEffect(player);
                    break;
                case 32:
                    MothBlindness.currentMothHolders.remove(player);
                    break;
                case 33:
                    Karma.currentKarmaHolders.remove(player);
                    break;
                case 34:
                    ToadNausea.currentNauseaHolders.remove(player);
                    break;
                case 35:
                    BatConfusion.currentBatConfusionHolder.remove(player);
                    break;
                case 36:
                    CurseOfInsanity.currentInsanityHolders.remove(player);
                    break;
                case 37:
                    ZeusNemesis.currentZeusEnemies.remove(player);
                    break;
                case 38:
                    SlipperyHands.currentSlipperyHandPeople.remove(player);
                    break;
            }
        }
    }
}
