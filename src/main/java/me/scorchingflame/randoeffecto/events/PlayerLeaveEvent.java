package me.scorchingflame.randoeffecto.events;

import me.scorchingflame.randoeffecto.Extra.Effects;
import me.scorchingflame.randoeffecto.Randoeffecto;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.potion.PotionEffectType;

import java.util.List;
import java.util.Objects;

public class PlayerLeaveEvent implements Listener {
    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        for (List<Effects> effectsList:
                Randoeffecto.playerData.get(event.getPlayer().getUniqueId().toString())) {
            for (Effects effects:
                 effectsList) {
                if (!effects.isCustomEffect()){
                    event.getPlayer().removePotionEffect(Objects.requireNonNull(PotionEffectType.getByName(effects.getPotionEffectType())));
                }
            }
        }
    }
}
