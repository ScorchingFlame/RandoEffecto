package me.scorchingflame.randoeffecto.menus;

import fr.minuskube.inv.ClickableItem;
import fr.minuskube.inv.SmartInventory;
import fr.minuskube.inv.content.InventoryContents;
import fr.minuskube.inv.content.InventoryProvider;
import me.scorchingflame.randoeffecto.Miscellaneous.playerHeadsSetUp;
import me.scorchingflame.randoeffecto.config.EffectName;
import me.scorchingflame.randoeffecto.config.configSetUp;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class allBlessings implements InventoryProvider {
    public static final SmartInventory allBlessingInv = SmartInventory.builder()
            .id("allBlessings")
            .size(5, 9)
            .provider(new allBlessings())
            .closeable(true)
            .title("All §2§lBlessings")
            .build();


    @Override
    public void init(Player player, InventoryContents contents) {
        ItemStack menuNothing = configSetUp.menuNothing;
        List<EffectName> effectNames = new ArrayList<>();
        configSetUp.getEffectNameMap().forEach((integer, effectName) -> {
            if (effectName.getType() == 1){
                effectNames.add(effectName);
            }
        });
        int row = 1;
        int column = 1;
        ItemStack itemStack = playerHeadsSetUp.getBlessing().clone();
        for (EffectName effectName:
             effectNames) {
            ItemMeta itemMeta = itemStack.getItemMeta();
            assert itemMeta != null;
            itemMeta.setDisplayName(effectName.getName());
            List<String> lore = new ArrayList<>();
            lore.add(effectName.getDescription());
            itemMeta.setLore(lore);
            itemStack.setItemMeta(itemMeta);
            contents.set(row, column, ClickableItem.empty(itemStack.clone()));

            if (column >= 7){
                column = 1;
                row++;
            }else {
                column++;
            }
        }
        contents.fillBorders(ClickableItem.empty(menuNothing));
    }

    @Override
    public void update(Player player, InventoryContents contents) {

    }
}
