package me.scorchingflame.randoeffecto.CustomEffects.Curses;

import me.scorchingflame.randoeffecto.Extra.Effects;
import me.scorchingflame.randoeffecto.Randoeffecto;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import java.util.HashMap;
import java.util.Map;

import static me.scorchingflame.randoeffecto.CustomEffects.Curses.Karma.currentKarmaHolders;
import static me.scorchingflame.randoeffecto.CustomEffects.Curses.Karma.karmaDamage;

public class Karma {
    public static Map<Player, Effects> currentKarmaHolders = new HashMap<>();
    public static int karmaDamage;
    public static void setUp(){
        Randoeffecto plugin = Randoeffecto.getPlugin();
        karmaDamage = plugin.getConfig().getInt("effects.33.damage");
        Bukkit.getPluginManager().registerEvents(new KarmaEventListener(), plugin);
    }

}
 class KarmaEventListener implements Listener{
     @EventHandler
     public void onEntityDamageByEntityEvent(EntityDamageByEntityEvent event){
         if (event.getDamager() instanceof Player){
             Player p = (Player) event.getDamager();
             if (currentKarmaHolders.containsKey(p)){
                 int amplifier = currentKarmaHolders.get(p).getAmplifier() + 1;
                 p.damage(karmaDamage * amplifier); //TODO: If they die from Karma, make it as a custom death message.
             }
         }
     }
 }
