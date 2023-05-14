package me.scorchingflame.randoeffecto.Extra;

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
                ApplyEffect.applyEffect(event.getPlayer(), GetRandomBlessing.getRandomBlessing().potion);
            }else {
                ApplyEffect.applyEffect(event.getPlayer(), GetRandomCurse.getRandomCurse().potion);
            }
        }
    }
}
