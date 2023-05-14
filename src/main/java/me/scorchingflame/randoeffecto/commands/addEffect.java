package me.scorchingflame.randoeffecto.commands;

import me.scorchingflame.randoeffecto.Extra.ApplyEffect;
import me.scorchingflame.randoeffecto.Extra.Effects;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class addEffect implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player p = (Player) sender;
            if (args.length == 2){
                int effectID = Integer.parseInt(args[0]);
                int amplifier = Integer.parseInt(args[1]) - 1;
                Effects effects = new Effects(effectID, amplifier);
                ApplyEffect.applyEffect(p, effects);
                p.sendMessage("Applied!");
            }else {
                p.sendMessage("/addEffect <custom-effect-id> <amplifier [1-3]>");
            }
            return true;
        }
        return false;
    }
}
