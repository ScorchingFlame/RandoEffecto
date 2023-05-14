package me.scorchingflame.randoeffecto.Extra;

import me.scorchingflame.randoeffecto.Randoeffecto;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.potion.PotionEffect;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static me.scorchingflame.randoeffecto.Extra.GetRandomBlessing.blessing;
import static me.scorchingflame.randoeffecto.Extra.GetRandomCurse.Curse;
import static me.scorchingflame.randoeffecto.Randoeffecto.crudGSON;

public class PlayerFirstJoin implements Listener {

    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent event) {
        if (!Randoeffecto.playerData.containsKey(event.getPlayer().getUniqueId().toString())){
            List<List<Effects>> listList = new ArrayList<>();
            List<Effects> blessings = new ArrayList<>();
            List<Effects> curses = new ArrayList<>();
            blessings.add(blessing.get(1));
            blessings.add(blessing.get(20));
            curses.add(Curse.get(21));
            curses.add(Curse.get(38));
            listList.add(blessings);
            listList.add(curses);
            Randoeffecto.playerData.put(event.getPlayer().getUniqueId().toString(), listList);
            try{
                crudGSON.save();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
