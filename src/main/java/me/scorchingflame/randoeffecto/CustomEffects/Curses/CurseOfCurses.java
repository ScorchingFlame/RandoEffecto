package me.scorchingflame.randoeffecto.CustomEffects.Curses;

import me.scorchingflame.randoeffecto.Extra.ApplyEffect;
import me.scorchingflame.randoeffecto.Extra.Effects;
import me.scorchingflame.randoeffecto.Extra.GetRandomCurse;
import me.scorchingflame.randoeffecto.Randoeffecto;
import org.bukkit.Statistic;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryPickupItemEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

public class CurseOfCurses {
    public static Map<Player, Effects> currentCurseHolders = new HashMap<>();
    private static Randoeffecto plugin;
    public static void setUp(){
        plugin = Randoeffecto.getPlugin();
        plugin.getServer().getPluginManager().registerEvents(new CurseOfCursesListener(), plugin);
    }
    public static void addEffect(Player player, Effects effects){
        if (player.getStatistic(Statistic.DEATHS) >= plugin.getConfig().getInt("effects.31.hard-lock-till-deaths")){
            currentCurseHolders.put(player, effects);
        }else {
            ApplyEffect.applyEffect(player, GetRandomCurse.getRandomCurse().getPotion());
        }
    }
    public static void removeEffect(Player player){
        currentCurseHolders.remove(player);
    }
}
class CurseOfCursesListener implements Listener{
    @EventHandler
    public void onPlayerPickupItem(PlayerPickupItemEvent event) {
        if (CurseOfCurses.currentCurseHolders.containsKey(event.getPlayer())){
            applyCurseOfVanishing(event.getPlayer(), event.getItem().getItemStack());
        }

    }

    @EventHandler
    public void onInventoryPickupItem(InventoryPickupItemEvent event) {
        if (event.getInventory().getHolder() instanceof Player) {
            Player player = (Player) event.getInventory().getHolder();
            if (CurseOfCurses.currentCurseHolders.containsKey(player)){
                applyCurseOfVanishing(player, event.getItem().getItemStack());
            }
        }
    }

    @EventHandler
    public void onPlayerItemHeld(PlayerItemHeldEvent event) {
        if (CurseOfCurses.currentCurseHolders.containsKey(event.getPlayer())){
            applyCurseOfVanishing(event.getPlayer(), event.getPlayer().getInventory().getItem(event.getNewSlot()));
        }
    }

    private void applyCurseOfVanishing(Player player, ItemStack item) {
        if (item != null) {
            if (item.getType().toString().endsWith("_SWORD") || item.getType().toString().endsWith("_AXE") || item.getType().toString().endsWith("_HOE") || item.getType().toString().endsWith("_PICKAXE") || item.getType().toString().endsWith("_SHOVEL") || item.getType().toString().endsWith("_HELMET") || item.getType().toString().endsWith("_CHESTPLATE") || item.getType().toString().endsWith("_LEGGINGS") || item.getType().toString().endsWith("_BOOTS")) {
                item.addUnsafeEnchantment(Enchantment.VANISHING_CURSE, 1);
            }
        }
    }
}