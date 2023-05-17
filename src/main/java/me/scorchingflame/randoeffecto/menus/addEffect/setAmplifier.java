package me.scorchingflame.randoeffecto.menus.addEffect;

import fr.minuskube.inv.ClickableItem;
import fr.minuskube.inv.SmartInventory;
import fr.minuskube.inv.content.InventoryContents;
import fr.minuskube.inv.content.InventoryProvider;
import me.scorchingflame.randoeffecto.Extra.Effects;
import me.scorchingflame.randoeffecto.Miscellaneous.playerHeadsSetUp;
import me.scorchingflame.randoeffecto.config.configSetUp;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class setAmplifier implements InventoryProvider {
    private Effects effects;
    private final String uuid;

    public setAmplifier(Effects effects, String uuid) {
        this.effects = effects;
        this.uuid = uuid;
    }

    @Override
    public void init(Player player, InventoryContents contents) {
        ItemStack nothing = configSetUp.menuNothing;
        for (int i = 0; i <= 2; i++){
            contents.set(0, i, ClickableItem.empty(nothing));
        }
        contents.set(0, 3, ClickableItem.of(playerHeadsSetUp.getNumberOne().clone(),
                event -> {}
        ));
        contents.set(0, 4, ClickableItem.of(playerHeadsSetUp.getNumberTwo().clone(),
                event -> {}
        ));
        contents.set(0, 5, ClickableItem.of(playerHeadsSetUp.getNumberThree().clone(),
                event -> {}
        ));
        for (int i = 6; i <= 8; i++){
            contents.set(0, i, ClickableItem.empty(nothing));
        }
    }

    @Override
    public void update(Player player, InventoryContents contents) {

    }

    public static SmartInventory getSetAmpInv(Effects effects, String uuid){
        return SmartInventory.builder()
                .id("setAmplifier")
                .size(1, 9)
                .title("Set the amplifier")
                .provider(new setAmplifier(effects, uuid))
                .build();
    }
}
