package me.scorchingflame.randoeffecto.CustomEffects;

import me.scorchingflame.randoeffecto.CustomEffects.Blessings.*;
import me.scorchingflame.randoeffecto.CustomEffects.Curses.*;
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

       // Curses
        VulturesHunger.setUp();
        ScorpionSting.setUp();
        CerberusBite.setUp();
        WitchesBrew.setUp();
        // Curse of curses
        MothBlindness.setUp();
        Karma.setUp();
        ToadNausea.setUp();
        BatConfusion.setUp();
        CurseOfInsanity.setUp();
        ZeusNemesis.setUp();
        SlipperyHands.setUp();
    }
}
