package me.scorchingflame.randoeffecto.CustomEffects.Blessings;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.List;

public class PoisonAttackEntity implements Listener {
    public static List<Player> currentPoisonAttackEntityHolders = new ArrayList<>();

    @EventHandler
    public void onEntityDamageByEntityEvent(EntityDamageByEntityEvent event){
        if (event.getDamager() instanceof Player){
            Player player = (Player) event.getDamager();
            if (currentPoisonAttackEntityHolders.contains(player)){
                if (event.getEntity() instanceof LivingEntity){
                    LivingEntity livingEntity = (LivingEntity) event.getEntity();
                    livingEntity.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 20000, 0, false, false, false));
                }
            }
        }
    }
}
