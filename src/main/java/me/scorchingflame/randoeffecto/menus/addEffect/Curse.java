package me.scorchingflame.randoeffecto.menus.addEffect;

import fr.minuskube.inv.ClickableItem;
import fr.minuskube.inv.SmartInventory;
import fr.minuskube.inv.content.InventoryContents;
import fr.minuskube.inv.content.InventoryProvider;
import me.scorchingflame.randoeffecto.Extra.Effects;
import me.scorchingflame.randoeffecto.Extra.GetRandomCurse;
import me.scorchingflame.randoeffecto.Miscellaneous.playerHeadsSetUp;
import me.scorchingflame.randoeffecto.config.EffectName;
import me.scorchingflame.randoeffecto.config.configSetUp;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Curse implements InventoryProvider {
    private final String uuid;

    public Curse(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public void init(Player player, InventoryContents contents) {
        ItemStack menuNothing = configSetUp.menuNothing;
        List<EffectName> effectNames = new ArrayList<>();
        configSetUp.getEffectNameMap().forEach((integer, effectName) -> {
            if (effectName.getType() == 2){
                effectNames.add(effectName);
            }
        });
        int row = 1;
        int column = 1;
        ItemStack itemStack = playerHeadsSetUp.getCurse().clone();
        for (EffectName effectName:
                effectNames) {
            ItemMeta itemMeta = itemStack.getItemMeta();
            assert itemMeta != null;
            itemMeta.setDisplayName(effectName.getName());
            List<String> lore = new ArrayList<>();
            lore.add(effectName.getDescription());
            lore.add("");
            lore.add("ID: " + (Integer) configSetUp.getEffectNameMap().entrySet().stream().filter(integerEffectNameEntry -> effectName.equals(integerEffectNameEntry.getValue())).map(Map.Entry::getKey).mapToInt(Integer::intValue).sum());
            itemMeta.setLore(lore);
            itemStack.setItemMeta(itemMeta);
            contents.set(row, column, ClickableItem.of(itemStack.clone(), event -> {
                                Objects.requireNonNull(Objects.requireNonNull(Objects.requireNonNull(event.getCurrentItem())
                                                        .getItemMeta())
                                                .getLore())
                                        .stream()
                                        .reduce((a, b) -> b)
                                        .ifPresent(s -> {
                                            Effects effects;
                                            if (GetRandomCurse.Curse.get(Integer.valueOf(s.replaceAll("[^-?0-9]+", ""))).isCustomEffect()){
                                                effects = new Effects(Integer.valueOf(s.replaceAll("[^-?0-9]+", "")), 1, 1);
                                            }else{
                                                effects = new Effects(Integer.valueOf(s.replaceAll("[^-?0-9]+", "")), GetRandomCurse.Curse.get(Integer.valueOf(s.replaceAll("[^-?0-9]+", ""))).getPotionEffectType(), 1, 1);
                                            }

                                            setAmplifier.getSetAmpInv(effects, uuid).open(player);
                                        });
            }));

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
    public void update(Player player, InventoryContents contents) {}

    public static SmartInventory getCurseInv(String uuid){
        return SmartInventory.builder()
                .id("curses")
                .size(5, 9)
                .provider(new Curse(uuid))
                .closeable(true)
                .title("All §4§lCurses")
                .build();
    }
}
