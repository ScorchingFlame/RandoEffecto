package me.scorchingflame.randoeffecto.Extra;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.potion.PotionEffect;
import java.util.ArrayList;
import java.util.List;
import static me.scorchingflame.randoeffecto.Randoeffecto.playerDataF;

public class PlayerFirstJoin implements Listener {

    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent event){
        String uuid;
        uuid = event.getPlayer().getUniqueId().toString();
        if (playerDataF.configuration.getConfigurationSection("playerdata." + uuid) == null){
            RanPotion i = GetRandomBlessing.getRandomBlessing();
            event.getPlayer().addPotionEffect(new PotionEffect(i.potion, Integer.MAX_VALUE, 0));
            event.getPlayer().sendMessage("You suck really");
            List<String> list = new ArrayList<>();
            list.add(i.keyNo.toString());
            playerDataF.configuration.set("playerdata." + uuid + ".effects", list);
            playerDataF.saveData();
        }
    }
}
