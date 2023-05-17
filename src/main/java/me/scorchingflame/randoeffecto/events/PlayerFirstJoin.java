package me.scorchingflame.randoeffecto.events;

import me.scorchingflame.randoeffecto.Extra.ApplyEffect;
import me.scorchingflame.randoeffecto.Extra.Effects;
import me.scorchingflame.randoeffecto.Extra.GetRandomBlessing;
import me.scorchingflame.randoeffecto.Extra.GetRandomCurse;
import me.scorchingflame.randoeffecto.Randoeffecto;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PlayerFirstJoin implements Listener {

    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent event) {
        if (!Randoeffecto.playerData.containsKey(event.getPlayer().getUniqueId().toString())){
            List<List<Effects>> listList = new ArrayList<>();
            List<Effects> ble = new ArrayList<>();
            List<Effects> cur = new ArrayList<>();
            listList.add(ble);
            listList.add(cur);
            Randoeffecto.playerData.put(event.getPlayer().getUniqueId().toString(), listList);
            Random random = new Random();
            if (random.nextBoolean()){
                ApplyEffect.applyEffect(event.getPlayer(), GetRandomBlessing.getRandomBlessing().getPotion());
            }else {
                ApplyEffect.applyEffect(event.getPlayer(), GetRandomCurse.getRandomCurse().getPotion());
            }
        }else{
            for (List<Effects> effectsList : Randoeffecto.playerData.get(event.getPlayer().getUniqueId().toString())){
                for (Effects effects:
                     effectsList) {
                    ApplyEffect.applyEffectWithoutSave(event.getPlayer(), effects);
                }
            }
        }
    }
}
