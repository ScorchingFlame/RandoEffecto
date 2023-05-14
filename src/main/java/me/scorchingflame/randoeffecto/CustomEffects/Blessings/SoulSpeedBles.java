package me.scorchingflame.randoeffecto.CustomEffects.Blessings;

import me.scorchingflame.randoeffecto.Extra.Effects;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

import static me.scorchingflame.randoeffecto.Extra.Boots.materialListOfBoots;

public class SoulSpeedBles implements Listener {
    public static Map<Player, Effects> currentSoulHolders = new HashMap<>();
    // TODO: Add the effect if the item was taken from chest and vice versa
    // TODO: Change All the blessings into using Map and add amplifier feature to all the blessings
    @EventHandler
    public void onPlayerPickupItem(PlayerPickupItemEvent event) {
        Player player = event.getPlayer();
        if (currentSoulHolders.containsKey(player)) {
            ItemStack pickedUpItem = event.getItem().getItemStack();
            if (materialListOfBoots.contains(pickedUpItem.getType())) {
                pickedUpItem.addEnchantment(Enchantment.SOUL_SPEED, currentSoulHolders.get(player).getAmplifier() + 1);
            }
        }
    }

    @EventHandler
    public void onCraftItem(org.bukkit.event.inventory.CraftItemEvent event) {
        Player player = (Player) event.getWhoClicked();
        if (currentSoulHolders.containsKey(player)) {
            ItemStack craftedItem = event.getCurrentItem();
            assert craftedItem != null;
            if (materialListOfBoots.contains(craftedItem.getType())) {
                craftedItem.addEnchantment(Enchantment.SOUL_SPEED, currentSoulHolders.get(player).getAmplifier() + 1);
                event.setCurrentItem(craftedItem);
            }
        }
    }

    @EventHandler
    public void onPlayerDropItem(PlayerDropItemEvent event) {
        Player player = event.getPlayer();
        if (currentSoulHolders.containsKey(player)) {
            ItemStack droppedItem = event.getItemDrop().getItemStack();
            if (materialListOfBoots.contains(droppedItem.getType()) && droppedItem.containsEnchantment(Enchantment.SOUL_SPEED)) {
                droppedItem.removeEnchantment(Enchantment.SOUL_SPEED);
            }
        }
    }

    @EventHandler
    public void onInventoryMoveItem(InventoryMoveItemEvent event){
        if (event.getInitiator().getHolder() instanceof Player){
            Player player = (Player) event.getInitiator().getHolder();
            if (currentSoulHolders.containsKey(player)){
                if (materialListOfBoots.contains(event.getItem().getType()) && event.getItem().containsEnchantment(Enchantment.SOUL_SPEED)){
                    ItemStack itemStack = event.getItem();
                    itemStack.removeEnchantment(Enchantment.SOUL_SPEED);
                    event.setItem(itemStack);
                }
            }
        }
    }
}
