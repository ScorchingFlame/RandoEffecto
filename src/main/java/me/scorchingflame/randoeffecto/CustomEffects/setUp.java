package me.scorchingflame.randoeffecto.CustomEffects;

import me.scorchingflame.randoeffecto.CustomEffects.Blessings.*;
import me.scorchingflame.randoeffecto.Randoeffecto;
import org.bukkit.Bukkit;


public class setUp {
    public static void setUpEffects(){
        Randoeffecto plugin = Randoeffecto.getPlugin();
       Bukkit.getPluginManager().registerEvents(new SilkEffect(), plugin);
       Bukkit.getPluginManager().registerEvents(new SoulSpeedBles(), plugin);
       Bukkit.getPluginManager().registerEvents(new FortunateExplorer(), plugin);
        FireworksFanatic.setUp();
       Bukkit.getPluginManager().registerEvents(new PoisonAttackEntity(), plugin);
    }
}
