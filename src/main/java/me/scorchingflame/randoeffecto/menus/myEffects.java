package me.scorchingflame.randoeffecto.menus;

import fr.minuskube.inv.ClickableItem;
import fr.minuskube.inv.SmartInventory;
import fr.minuskube.inv.content.InventoryContents;
import fr.minuskube.inv.content.InventoryProvider;
import me.scorchingflame.randoeffecto.Extra.Effects;
import me.scorchingflame.randoeffecto.Miscellaneous.playerHeadsSetUp;
import me.scorchingflame.randoeffecto.Randoeffecto;
import me.scorchingflame.randoeffecto.config.configSetUp;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class myEffects implements InventoryProvider {

    private final String uuid;

    public myEffects(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public void init(Player player, InventoryContents contents) {
        ItemStack blackStainedGlass = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
        ItemMeta blackStainedGlassMeta = blackStainedGlass.getItemMeta();
        assert blackStainedGlassMeta != null;
        blackStainedGlassMeta.setDisplayName(" ");
        blackStainedGlass.setItemMeta(blackStainedGlassMeta);
        contents.fillBorders(ClickableItem.empty(blackStainedGlass));
        List<Effects> effectsList = new ArrayList<>();
        List<List<Effects>> listList = new ArrayList<>();
        listList.add(effectsList);
        listList.add(effectsList);
        List<Effects> blessings = Randoeffecto.playerData.getOrDefault(uuid, listList).get(0);
        List<Effects> curses = Randoeffecto.playerData.getOrDefault(uuid, listList).get(1);
        ItemStack itemStack = playerHeadsSetUp.getEffects().clone();
        itemStack.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1);
        ItemMeta meta = itemStack.getItemMeta();
        assert meta != null;
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        itemStack.setItemMeta(meta);
        int blessings_i = 1;
        for (Effects effects:
             blessings) {
            if (blessings_i <= 3){
                String displayName = configSetUp.getEffectNameMap().get(effects.getId()).getName();
                String description = configSetUp.getEffectNameMap().get(effects.getId()).getDescription();
                String type = "Type: §2§lBlessing";
                List<String> list = new ArrayList<>();
                list.add(description);
                list.add("");
                list.add(type);
                ItemMeta newItemMeta = itemStack.getItemMeta();
                newItemMeta.setDisplayName(displayName);
                newItemMeta.setLore(list);
                itemStack.setItemMeta(newItemMeta.clone());
                contents.set(1, blessings_i, ClickableItem.empty(itemStack.clone()));
                blessings_i++;
            }
        }
        contents.set(1, 4, ClickableItem.empty(blackStainedGlass));
        int curse_i = 5;
        for (Effects effects:
                curses) {
            if (curse_i <= 7){
                String displayName = configSetUp.getEffectNameMap().get(effects.getId()).getName();
                String description = configSetUp.getEffectNameMap().get(effects.getId()).getDescription();
                String type = "Type: §4§lCurse";
                List<String> list = new ArrayList<>();
                list.add(description);
                list.add("");
                list.add(type);
                ItemMeta newItemMeta = itemStack.getItemMeta();
                newItemMeta.setDisplayName(displayName);
                newItemMeta.setLore(list);
                itemStack.setItemMeta(newItemMeta.clone());
                contents.set(1, curse_i, ClickableItem.empty(itemStack.clone()));
                curse_i++;
            }
        }

    }

    @Override
    public void update(Player player, InventoryContents contents) {}

    public static SmartInventory getMyEffectGui(String uuid, boolean user){
        if (user){
            return SmartInventory.builder()
                    .id("myEffects")
                    .provider(new myEffects(uuid))
                    .size(3, 9)
                    .title(ChatColor.BLUE + "Your Effects")
                    .closeable(true)
                    .build();
        }else {
            return SmartInventory.builder()
                    .id("myEffects")
                    .provider(new myEffects(uuid))
                    .size(3, 9)
                    .title(ChatColor.BLUE + "Effects of " + Bukkit.getOfflinePlayer(UUID.fromString(uuid)).getName())
                    .closeable(true)
                    .build();
        }
    }
}
