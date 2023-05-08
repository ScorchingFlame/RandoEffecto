package me.scorchingflame.randoeffecto.Extra;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;

import static me.scorchingflame.randoeffecto.Extra.Boots.materialListOfBoots;
import static me.scorchingflame.randoeffecto.Randoeffecto.currentSoulHolders;

public class SoulSpeedBles implements Listener {
    @EventHandler
    public void onPlayerPickupItem(PlayerPickupItemEvent event) {
        Player player = event.getPlayer();
        if (currentSoulHolders.contains(player)) {
            ItemStack pickedUpItem = event.getItem().getItemStack();
            if (materialListOfBoots.contains(pickedUpItem.getType())) {
                pickedUpItem.addEnchantment(Enchantment.SOUL_SPEED, 1);
            }
        }
    }

    @EventHandler
    public void onCraftItem(org.bukkit.event.inventory.CraftItemEvent event) {
        Player player = (Player) event.getWhoClicked();
        if (currentSoulHolders.contains(player)) {
            ItemStack craftedItem = event.getCurrentItem();
            assert craftedItem != null;
            if (materialListOfBoots.contains(craftedItem.getType())) {
                craftedItem.addEnchantment(Enchantment.SOUL_SPEED, 1);
            }
        }
    }

    @EventHandler
    public void onPlayerDropItem(PlayerDropItemEvent event) {
        Player player = event.getPlayer();
        if (currentSoulHolders.contains(player)) {
            ItemStack droppedItem = event.getItemDrop().getItemStack();
            if (materialListOfBoots.contains(droppedItem.getType())) {
                droppedItem.removeEnchantment(Enchantment.SOUL_SPEED);
            }
        }
    }
}
