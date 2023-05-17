package me.scorchingflame.randoeffecto.menus;

import fr.minuskube.inv.ClickableItem;
import fr.minuskube.inv.SmartInventory;
import fr.minuskube.inv.content.InventoryContents;
import fr.minuskube.inv.content.InventoryProvider;
import fr.minuskube.inv.content.SlotIterator;
import me.scorchingflame.randoeffecto.Miscellaneous.getPlayerHeads;
import me.scorchingflame.randoeffecto.Miscellaneous.playerHeadsSetUp;
import me.scorchingflame.randoeffecto.config.configSetUp;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class allEffects implements InventoryProvider {
    public static final SmartInventory allEffectsMenu = SmartInventory.builder()
            .id("allEffectsMenu")
            .size(1, 9)
            .closeable(true)
            .title("All Effects")
            .provider(new allEffects())
            .build();

    @Override
    public void init(Player player, InventoryContents contents) {
        ItemStack menuNothing = configSetUp.menuNothing;
        for (int i = 0; i <= 2; i++){
            contents.set(0, i, ClickableItem.empty(menuNothing));
        }
        ItemStack blessing = playerHeadsSetUp.getBlessing().clone();
        ItemMeta blessingMeta = blessing.getItemMeta();
        assert blessingMeta != null;
        blessingMeta.setDisplayName("All §2§lBlessings");
        blessingMeta.setLore(null);
        blessing.setItemMeta(blessingMeta);
        contents.set(0, 3, ClickableItem.of(
                blessing,
                event -> {
                    allBlessings.allBlessingInv.open((Player) event.getWhoClicked());
                }
        ));
        contents.set(0, 4, ClickableItem.empty(menuNothing));
        ItemStack curse = playerHeadsSetUp.getCurse().clone();
        ItemMeta curseMeta = curse.getItemMeta();
        assert curseMeta != null;
        curseMeta.setDisplayName("All §4§lCurses");
        curseMeta.setLore(null);
        curse.setItemMeta(curseMeta);
        contents.set(0, 5, ClickableItem.of(
                curse,
                event -> {
                    allCurses.allCursesInv.open((Player) event.getWhoClicked());
                }
        ));
        for (int i = 6; i <= 9; i++){
            contents.set(0, i, ClickableItem.empty(menuNothing));
        }
    }

    @Override
    public void update(Player player, InventoryContents contents) {

    }
}
