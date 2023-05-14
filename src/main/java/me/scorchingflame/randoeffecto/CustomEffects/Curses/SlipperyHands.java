package me.scorchingflame.randoeffecto.CustomEffects.Curses;

import me.scorchingflame.randoeffecto.Extra.Effects;
import me.scorchingflame.randoeffecto.Randoeffecto;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

public class SlipperyHands {
    public static Map<Player, Effects> currentSlipperyHandPeople = new HashMap<>();
    public static void setUp(){
        Randoeffecto plugin = Randoeffecto.getPlugin();
        Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, () -> {
            for (Player player:
                    currentSlipperyHandPeople.keySet()) {
                if (currentSlipperyHandPeople.get(player).getAmplifier() == 0 && player.isOnline()){
                    dropHeldItem(player);
                }
            }
        }, 0, plugin.getConfig().getLong("effects.38.loop-duration-level-1") * 20);
        Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, () -> {
            for (Player player:
                    currentSlipperyHandPeople.keySet()) {
                if (currentSlipperyHandPeople.get(player).getAmplifier() == 1 && player.isOnline()){
                    dropHeldItem(player);
                }
            }
        }, 0, plugin.getConfig().getLong("effects.38.loop-duration-level-2") * 20);
        Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, () -> {
            for (Player player:
                    currentSlipperyHandPeople.keySet()) {
                if (currentSlipperyHandPeople.get(player).getAmplifier() == 2 && player.isOnline()){
                    dropHeldItem(player);
                }
            }
        }, 0, plugin.getConfig().getLong("effects.38.loop-duration-level-3") * 20);
    }

    public static void dropHeldItem(Player player) {
        ItemStack heldItem = player.getInventory().getItemInMainHand();
        if (!heldItem.getType().isAir()) {
            player.getWorld().dropItemNaturally(player.getLocation(), heldItem);
            player.getInventory().setItemInMainHand(null);
        }
    }
}
