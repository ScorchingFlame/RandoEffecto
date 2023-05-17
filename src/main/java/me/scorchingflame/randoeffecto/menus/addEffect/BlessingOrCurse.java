package me.scorchingflame.randoeffecto.menus.addEffect;

import fr.minuskube.inv.ClickableItem;
import fr.minuskube.inv.SmartInventory;
import fr.minuskube.inv.content.InventoryContents;
import fr.minuskube.inv.content.InventoryProvider;
import me.scorchingflame.randoeffecto.Miscellaneous.playerHeadsSetUp;
import me.scorchingflame.randoeffecto.config.configSetUp;
import me.scorchingflame.randoeffecto.menus.allBlessings;
import me.scorchingflame.randoeffecto.menus.allCurses;
import me.scorchingflame.randoeffecto.menus.allEffects;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class BlessingOrCurse implements InventoryProvider {
    private String uuid;

    public BlessingOrCurse(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public void init(Player player, InventoryContents contents) {
        ItemStack menuNothing = configSetUp.menuNothing;
        for (int i = 0; i <= 2; i++){
            contents.set(0, i, ClickableItem.empty(menuNothing));
        }
        ItemStack blessing = playerHeadsSetUp.getBlessing().clone();
        ItemMeta blessingMeta = blessing.getItemMeta();
        assert blessingMeta != null;
        blessingMeta.setDisplayName("§2§lBlessings");
        blessingMeta.setLore(null);
        blessing.setItemMeta(blessingMeta);
        contents.set(0, 3, ClickableItem.of(
                blessing,
                event -> {
                    Blessing.getBlessingInv(uuid).open(player);
                }
        ));
        contents.set(0, 4, ClickableItem.empty(menuNothing));
        ItemStack curse = playerHeadsSetUp.getCurse().clone();
        ItemMeta curseMeta = curse.getItemMeta();
        assert curseMeta != null;
        curseMeta.setDisplayName("§4§lCurses");
        curseMeta.setLore(null);
        curse.setItemMeta(curseMeta);
        contents.set(0, 5, ClickableItem.of(
                curse,
                event -> {
                    Curse.getCurseInv(uuid).open(player);
                }
        ));
        for (int i = 6; i <= 9; i++){
            contents.set(0, i, ClickableItem.empty(menuNothing));
        }
    }

    @Override
    public void update(Player player, InventoryContents contents) {

    }

    public static SmartInventory getBlessingOrCurseMenu(String uuid){
        return SmartInventory.builder()
                .id("blessingOrCurse")
                .size(1, 9)
                .closeable(true)
                .title("Effects")
                .provider(new BlessingOrCurse(uuid))
                .build();
    }
}
