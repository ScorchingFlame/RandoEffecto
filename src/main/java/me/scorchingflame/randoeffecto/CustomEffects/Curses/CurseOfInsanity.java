package me.scorchingflame.randoeffecto.CustomEffects.Curses;

import me.scorchingflame.randoeffecto.Extra.Effects;
import me.scorchingflame.randoeffecto.Randoeffecto;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

public class CurseOfInsanity {
    public static Map<Player, Effects> currentInsanityHolders = new HashMap<>();

    public static void setUp(){
        Randoeffecto plugin = Randoeffecto.getPlugin();
        Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, () -> {
            for (Player player:
                    currentInsanityHolders.keySet()) {
                if (currentInsanityHolders.get(player).getAmplifier() == 0 && player.isOnline()){
                    changeInv(player);
                }
            }
        }, 0, plugin.getConfig().getLong("effects.36.loop-duration-level-1") * 20);
        Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, () -> {
            for (Player player:
                    currentInsanityHolders.keySet()) {
                if (currentInsanityHolders.get(player).getAmplifier() == 1 && player.isOnline()){
                    changeInv(player);
                }
            }
        }, 0, plugin.getConfig().getLong("effects.36.loop-duration-level-2") * 20);
        Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, () -> {
            for (Player player:
                    currentInsanityHolders.keySet()) {
                if (currentInsanityHolders.get(player).getAmplifier() == 2 && player.isOnline()){
                    changeInv(player);
                }
            }
        }, 0, plugin.getConfig().getLong("effects.36.loop-duration-level-3") * 20);
    }

    public static void changeInv(Player player){
        int currentSlot = player.getInventory().getHeldItemSlot();
        ItemStack currentHeldItem = player.getInventory().getItem(currentSlot);

        if (currentHeldItem == null) { // player is not holding anything
            currentHeldItem = new ItemStack(Material.AIR);
        }

        ItemStack[] hotBar = player.getInventory().getContents();

        int nextSlot = getNextHotBarSlot(currentSlot, hotBar);

        if (nextSlot == -1) {
            return;
        }

        ItemStack nextItem = hotBar[nextSlot];
        player.getInventory().setItem(currentSlot, nextItem);
        player.getInventory().setItem(nextSlot, currentHeldItem);
    }

    public static int getNextHotBarSlot(int currentSlot, ItemStack[] hotBar) {
        int nextSlot = currentSlot + 1;
        if (nextSlot >= hotBar.length) {
            nextSlot = 0;
        }
        int startingSlot = nextSlot;
        while (hotBar[nextSlot] == null) {
            nextSlot++;
            if (nextSlot >= hotBar.length) {
                nextSlot = 0;
            }
            if (nextSlot == startingSlot) {
                return -1;
            }
        }
        return nextSlot;
    }
}
