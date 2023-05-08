package me.scorchingflame.randoeffecto.Extra;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import static me.scorchingflame.randoeffecto.Randoeffecto.currentSilkHolders;

public class SilkEffect implements Listener {

    @EventHandler
    public void onBlockBreakEvent(BlockBreakEvent event){
        if (event.getPlayer().getGameMode().equals(GameMode.SURVIVAL)){
            if (currentSilkHolders.contains(event.getPlayer())) {
                Player player = event.getPlayer();
                World world = player.getWorld();
                Block block = event.getBlock();
                //If there is no silk touch on it

                ItemStack is = new ItemStack(block.getType());

                event.setDropItems(false);
                block.getDrops(is).clear();
                world.dropItemNaturally(event.getBlock().getLocation(), is);
            }
        }
    }
}
