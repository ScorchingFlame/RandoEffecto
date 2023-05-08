package me.scorchingflame.randoeffecto.Extra;

import org.bukkit.Material;

import java.util.ArrayList;
import java.util.List;

public class Boots {
    public static List<Material> materialListOfBoots = new ArrayList<>();
    public static void setBoots(){
        materialListOfBoots.add(Material.LEATHER_BOOTS);
        materialListOfBoots.add(Material.IRON_BOOTS);
        materialListOfBoots.add(Material.CHAINMAIL_BOOTS);
        materialListOfBoots.add(Material.GOLDEN_BOOTS);
        materialListOfBoots.add(Material.DIAMOND_BOOTS);
        materialListOfBoots.add(Material.NETHERITE_BOOTS);
    }
}
