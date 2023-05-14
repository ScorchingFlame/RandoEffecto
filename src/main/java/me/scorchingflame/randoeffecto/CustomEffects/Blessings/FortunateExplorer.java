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

public class FortunateExplorer implements Listener {
    public static Map<Player, Effects> currentFortuneHolders = new HashMap<>();
    // TODO: Add the effect if the item was taken from chest and vice versa
    // TODO: Change All the blessings into using Map and add amplifier feature to all the blessings
    @EventHandler
    public void onPlayerPickupItem(PlayerPickupItemEvent event) {
        Player player = event.getPlayer();
        if (currentFortuneHolders.containsKey(player)) {
            if ( event.getItem().getItemStack().getType().toString().endsWith("_PICKAXE")) {
                event.getItem().getItemStack().addEnchantment(Enchantment.LOOT_BONUS_BLOCKS, currentFortuneHolders.get(player).getAmplifier() + 1);
            }
        }
    }

    @EventHandler
    public void onCraftItem(org.bukkit.event.inventory.CraftItemEvent event) {
        Player player = (Player) event.getWhoClicked();
        if (currentFortuneHolders.containsKey(player)) {
            ItemStack craftedItem = event.getCurrentItem();
            assert craftedItem != null;
            if (craftedItem.getType().toString().endsWith("_PICKAXE")) {
                craftedItem.addEnchantment(Enchantment.LOOT_BONUS_BLOCKS, currentFortuneHolders.get(player).getAmplifier() + 1);
                event.setCurrentItem(craftedItem);
            }
        }
    }

    @EventHandler
    public void onPlayerDropItem(PlayerDropItemEvent event) {
        Player player = event.getPlayer();
        if (currentFortuneHolders.containsKey(player)) {
            if (event.getItemDrop().getItemStack().getType().toString().endsWith("_PICKAXE") && event.getItemDrop().getItemStack().containsEnchantment(Enchantment.LOOT_BONUS_BLOCKS)) {
                event.getItemDrop().getItemStack().removeEnchantment(Enchantment.LOOT_BONUS_BLOCKS);
            }
        }
    }

    @EventHandler
    public void onInventoryMoveItem(InventoryMoveItemEvent event){
        if (event.getInitiator().getHolder() instanceof Player){
            Player player = (Player) event.getInitiator().getHolder();
            if (currentFortuneHolders.containsKey(player)){
                if (event.getItem().getType().toString().endsWith("_PICKAXE") && event.getItem().containsEnchantment(Enchantment.LOOT_BONUS_BLOCKS)){
                    ItemStack itemStack = event.getItem();
                    itemStack.removeEnchantment(Enchantment.LOOT_BONUS_BLOCKS);
                    event.setItem(itemStack);
                }
            }
        }
    }
}
