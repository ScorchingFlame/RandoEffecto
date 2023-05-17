package me.scorchingflame.randoeffecto.Miscellaneous;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class playerHeadsSetUp {
    private static ItemStack blessing;
    private static ItemStack curse;
    private static ItemStack effects;
    private static ItemStack numberOne;
    private static ItemStack numberTwo;
    private static ItemStack numberThree;

    public static ItemStack getEffects() {
        return effects;
    }

    public static void setUp(){
        blessing = getPlayerHeads.getHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjU1NTM4MTIwOWJmOTg5ZThjYWFjM2FlOGQ2YjdlMTkzMzczZjE3MTgwODhmNWRiZjEyMmY3MWY1ZWFmOTBmMCJ9fX0=");
        curse = getPlayerHeads.getHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNmI0YTVjMjlkOTAxNzIxODUxZDg4NjhiOTA3NWY0OWM0NzZhODk0MDk4YzdlZjI2NjU4MTNjNTUyYmJjOWFkZCJ9fX0=");
        effects = getPlayerHeads.getHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzE0MGU3NjIzZmI0YTA4Nzk5ZGI2YTYzMjFkZGU4OWFjMmM3MjFlMjA2MWI1OTZkNGUxODA0NjkyNDVlMzk1OSJ9fX0=");
        numberOne = getPlayerHeads.getHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjFkODU5ZThiMTRmNjI2NDY4NTljZjM4MDRhNjRmMTA2MGQ2ODc5MzQxYjRjMzM4NWI0NmEwZWM0MGZhZjczYyJ9fX0=");
        ItemMeta num1 = numberOne.getItemMeta();
        assert num1 != null;
        num1.setDisplayName("1");
        numberOne.setItemMeta(num1);
        numberTwo = getPlayerHeads.getHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjNkOTNlOGI1ZmIwYjVkNTBhYmQ0ZWY4ODUzMmY0Njg3NGI5OTI0ZjY2OGRkYjAxMDkxNDY4ZTRlNjFiOWM4MyJ9fX0=");
        ItemMeta num2 = numberTwo.getItemMeta();
        assert num2 != null;
        num2.setDisplayName("2");
        numberTwo.setItemMeta(num2);
        numberThree = getPlayerHeads.getHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZWE3OWRhYTkyMDhhMDU2NTAwYzgzY2QyMDkwZmFlYzkxZWFlNTQwNTc5MmU0ZjU0NzI2OTdiMGU3ZGFjMzIzYSJ9fX0=");
        ItemMeta num3 = numberThree.getItemMeta();
        assert num3 != null;
        num3.setDisplayName("3");
        numberThree.setItemMeta(num3);
    }

    public static ItemStack getBlessing() {
        return blessing;
    }

    public static ItemStack getCurse() {
        return curse;
    }

    public static ItemStack getNumberOne() {
        return numberOne;
    }

    public static ItemStack getNumberTwo() {
        return numberTwo;
    }

    public static ItemStack getNumberThree() {
        return numberThree;
    }
}
