package me.scorchingflame.randoeffecto.CustomEffects.Blessings;

import org.bukkit.GameMode;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class SilkEffect implements Listener {

    public static List<Player> currentSilkHolders = new ArrayList<>();

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
