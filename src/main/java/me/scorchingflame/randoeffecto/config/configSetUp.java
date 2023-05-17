package me.scorchingflame.randoeffecto.config;

import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class configSetUp {
    private static final Map<Integer, EffectName> effectNameMap = new HashMap<>();

    public static Map<Integer, EffectName> getEffectNameMap() {
        return effectNameMap;
    }
    public static ItemStack menuNothing = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);

    public static void setUp(FileConfiguration configuration){
        for (String path : Objects.requireNonNull(configuration.getConfigurationSection("effects")).getKeys(false)) {
            EffectName effectName = new EffectName(
                    configuration.getString("effects." + path + ".name"),
                    configuration.getString("effects." + path + ".description"),
                    configuration.getInt("effects." + path + ".type")
            );
            effectNameMap.put(Integer.valueOf(path), effectName);
        }

        ItemMeta itemMeta = menuNothing.getItemMeta();
        assert itemMeta != null;
        itemMeta.setDisplayName(" ");
        menuNothing.setItemMeta(itemMeta);
    }
}
