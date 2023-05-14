package me.scorchingflame.randoeffecto.CustomEffects.Blessings;

import me.scorchingflame.randoeffecto.Extra.Effects;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PoisonAttackEntity implements Listener {
    public static Map<Player, Effects> currentPoisonAttackEntityHolders = new HashMap<>();

    @EventHandler
    public void onEntityDamageByEntityEvent(EntityDamageByEntityEvent event){
        if (event.getDamager() instanceof Player){
            Player player = (Player) event.getDamager();
            if (currentPoisonAttackEntityHolders.containsKey(player)){
                if (event.getEntity() instanceof LivingEntity){
                    LivingEntity livingEntity = (LivingEntity) event.getEntity();
                    livingEntity.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 400, currentPoisonAttackEntityHolders.get(player).getAmplifier(), true, true, false));
                }
            }
        }
    }
}
