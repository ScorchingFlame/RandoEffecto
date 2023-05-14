package me.scorchingflame.randoeffecto.CustomEffects;

import me.scorchingflame.randoeffecto.CustomEffects.Blessings.*;
import me.scorchingflame.randoeffecto.CustomEffects.Curses.*;
import me.scorchingflame.randoeffecto.Extra.ApplyEffect;
import me.scorchingflame.randoeffecto.Extra.Effects;
import me.scorchingflame.randoeffecto.Randoeffecto;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.Map;
import java.util.UUID;


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
        CurseOfCurses.setUp();
        MothBlindness.setUp();
        Karma.setUp();
        ToadNausea.setUp();
        BatConfusion.setUp();
        CurseOfInsanity.setUp();
        ZeusNemesis.setUp();
        SlipperyHands.setUp();

        // loading all the custom effects after restart
        Map<String, List<List<Effects>>> copyOfPlayerData = Randoeffecto.playerData;
        for (String uuid:
                copyOfPlayerData.keySet()) {
            Player player = Bukkit.getPlayer(UUID.fromString(uuid));
            int i = 0;
            for (List<Effects> effectsList:
                    copyOfPlayerData.get(uuid)) {

                for (Effects effects:
                     effectsList) {
                    if (effects.isCustomEffect()){
                        Randoeffecto.playerData.get(uuid).get(i).remove(effects);
                        ApplyEffect.applyEffect(player, effects);
                    }
                }

                i++;
            }
        }
    }
}
