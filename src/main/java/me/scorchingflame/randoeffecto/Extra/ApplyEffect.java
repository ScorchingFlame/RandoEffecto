package me.scorchingflame.randoeffecto.Extra;

import me.scorchingflame.randoeffecto.CustomEffects.Blessings.FireworksFanatic;
import me.scorchingflame.randoeffecto.CustomEffects.Blessings.FortunateExplorer;
import me.scorchingflame.randoeffecto.CustomEffects.Blessings.PoisonAttackEntity;
import me.scorchingflame.randoeffecto.CustomEffects.Curses.*;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.io.IOException;
import java.util.Objects;

import static me.scorchingflame.randoeffecto.CustomEffects.Blessings.SilkEffect.currentSilkHolders;
import static me.scorchingflame.randoeffecto.CustomEffects.Blessings.SoulSpeedBles.currentSoulHolders;
import static me.scorchingflame.randoeffecto.Randoeffecto.crudGSON;
import static me.scorchingflame.randoeffecto.Randoeffecto.playerData;

public class ApplyEffect {
    public static void applyEffect(Player player, Effects effects){
        if (effects.getPotionEffectType() != null){
            player.addPotionEffect(new PotionEffect(Objects.requireNonNull(PotionEffectType.getByName(effects.getPotionEffectType())), effects.getDuration(), effects.getAmplifier(), false, false, false));
            playerData.get(player.getUniqueId().toString()).get(effects.getType() - 1).add(effects);
        }else{
            Integer id = effects.getId();
            switch (id){
                case 16:
                    if (player.hasPermission("randoeffecto.blessings.silkTouch")){
                        currentSilkHolders.add(player);
                        playerData.get(player.getUniqueId().toString()).get(0).add(effects);
                    }else {
                        applyEffect(player,GetRandomBlessing.getRandomBlessing().potion);
                    }
                    break;
                case 17:
                    currentSoulHolders.put(player, effects);
                    playerData.get(player.getUniqueId().toString()).get(0).add(effects);
                    break;
                case 18:
                    FortunateExplorer.currentFortuneHolders.put(player, effects);
                    playerData.get(player.getUniqueId().toString()).get(0).add(effects);
                    break;
                case 19:
                    FireworksFanatic.currentFireworkHolders.put(player, effects);
                    playerData.get(player.getUniqueId().toString()).get(0).add(effects);
                    break;
                case 20:
                    PoisonAttackEntity.currentPoisonAttackEntityHolders.put(player, effects);
                    playerData.get(player.getUniqueId().toString()).get(0).add(effects);
                    break;
                case 27:
                    VulturesHunger.currentVultureHungerHolders.put(player, effects);
                    playerData.get(player.getUniqueId().toString()).get(1).add(effects);
                    break;
                case 28:
                    ScorpionSting.currentStingHolders.put(player, effects);
                    playerData.get(player.getUniqueId().toString()).get(1).add(effects);
                    break;
                case 29:
                    CerberusBite.addEffect(player, effects);
                    playerData.get(player.getUniqueId().toString()).get(1).add(effects);
                    break;
                case 30:
                    WitchesBrew.currentWitchHolder.put(player, effects);
                    playerData.get(player.getUniqueId().toString()).get(1).add(effects);
                    break;
                case 31:
                    CurseOfCurses.addEffect(player, effects); // effect to playerData is added inside the function
                    break;
                case 32:
                    MothBlindness.currentMothHolders.put(player, effects);
                    playerData.get(player.getUniqueId().toString()).get(1).add(effects);
                    break;
                case 33:
                    Karma.currentKarmaHolders.put(player, effects);
                    playerData.get(player.getUniqueId().toString()).get(1).add(effects);
                    break;
                case 34:
                    ToadNausea.currentNauseaHolders.put(player, effects);
                    playerData.get(player.getUniqueId().toString()).get(1).add(effects);
                    break;
                case 35:
                    BatConfusion.currentBatConfusionHolder.put(player, effects);
                    playerData.get(player.getUniqueId().toString()).get(1).add(effects);
                    break;
                case 36:
                    CurseOfInsanity.currentInsanityHolders.put(player, effects);
                    playerData.get(player.getUniqueId().toString()).get(1).add(effects);
                    break;
                case 37:
                    ZeusNemesis.currentZeusEnemies.put(player, effects);
                    playerData.get(player.getUniqueId().toString()).get(1).add(effects);
                    break;
                case 38:
                    SlipperyHands.currentSlipperyHandPeople.put(player, effects);
                    playerData.get(player.getUniqueId().toString()).get(1).add(effects);
                    break;
            }
        }
        try{
            crudGSON.save();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public static void removeEffect(Player player, Effects effects){
        if (!effects.isCustomEffect()){
            player.removePotionEffect(Objects.requireNonNull(PotionEffectType.getByName(effects.getPotionEffectType())));
            playerData.get(player.getUniqueId().toString()).get(effects.getType()-1).remove(effects);
        }else{
            Integer id = effects.getId();
            switch (id){
                case 16:
                    currentSilkHolders.remove(player);
                    playerData.get(player.getUniqueId().toString()).get(0).remove(effects);
                    break;
                case 17:
                    currentSoulHolders.remove(player);
                    playerData.get(player.getUniqueId().toString()).get(0).remove(effects);
                    break;
                case 18:
                    FortunateExplorer.currentFortuneHolders.remove(player);
                    playerData.get(player.getUniqueId().toString()).get(0).remove(effects);
                    break;
                case 19:
                    FireworksFanatic.currentFireworkHolders.remove(player);
                    playerData.get(player.getUniqueId().toString()).get(0).remove(effects);
                    break;
                case 20:
                    PoisonAttackEntity.currentPoisonAttackEntityHolders.remove(player);
                    playerData.get(player.getUniqueId().toString()).get(0).remove(effects);
                    break;
                case 27:
                    VulturesHunger.currentVultureHungerHolders.remove(player);
                    playerData.get(player.getUniqueId().toString()).get(1).remove(effects);
                    break;
                case 28:
                    ScorpionSting.currentStingHolders.remove(player);
                    playerData.get(player.getUniqueId().toString()).get(1).remove(effects);
                    break;
                case 29:
                    CerberusBite.removeEffect(player, effects);
                    playerData.get(player.getUniqueId().toString()).get(1).remove(effects);
                    break;
                case 30:
                    WitchesBrew.currentWitchHolder.remove(player);
                    playerData.get(player.getUniqueId().toString()).get(1).remove(effects);
                    break;
                case 31:
                    CurseOfCurses.removeEffect(player);
                    playerData.get(player.getUniqueId().toString()).get(1).remove(effects);
                    break;
                case 32:
                    MothBlindness.currentMothHolders.remove(player);
                    playerData.get(player.getUniqueId().toString()).get(1).remove(effects);
                    break;
                case 33:
                    Karma.currentKarmaHolders.remove(player);
                    playerData.get(player.getUniqueId().toString()).get(1).remove(effects);
                    break;
                case 34:
                    ToadNausea.currentNauseaHolders.remove(player);
                    playerData.get(player.getUniqueId().toString()).get(1).remove(effects);
                    break;
                case 35:
                    BatConfusion.currentBatConfusionHolder.remove(player);
                    playerData.get(player.getUniqueId().toString()).get(1).remove(effects);
                    break;
                case 36:
                    CurseOfInsanity.currentInsanityHolders.remove(player);
                    playerData.get(player.getUniqueId().toString()).get(1).remove(effects);
                    break;
                case 37:
                    ZeusNemesis.currentZeusEnemies.remove(player);
                    playerData.get(player.getUniqueId().toString()).get(1).remove(effects);
                    break;
                case 38:
                    SlipperyHands.currentSlipperyHandPeople.remove(player);
                    playerData.get(player.getUniqueId().toString()).get(1).remove(effects);
                    break;
            }
        }
        try{
            crudGSON.save();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
