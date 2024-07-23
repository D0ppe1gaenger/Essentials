package de.d0ppe1gaenger.essentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static de.d0ppe1gaenger.essentials.Main.Prefix;
import static de.d0ppe1gaenger.essentials.Main.nonPermission;

public class HealCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (player.hasPermission("essentials.heal")) {
                if (args.length == 0) {
                    player.setHealth(player.getHealthScale());
                    player.setFoodLevel(20);
                    player.setFireTicks(0);

                    player.sendMessage(Prefix + "Du hast dich geheilt.");
                    } else if (args.length == 1) {
                        if (player.hasPermission("essentials.heal.other")){
                            for (Player players : Bukkit.getOnlinePlayers()) {
                                if (players.getName().equals(args[0])) {
                                    players.setHealth(players.getHealthScale());
                                    player.setFoodLevel(20);
                                    player.setFireTicks(0);
                                }
                                player.sendMessage(Prefix + "Der Spieler " + players.getName() + " wurde geheilt!");
                                return true;
                            }
                        }else{
                            player.sendMessage(Prefix + nonPermission);
                            return false;
                        }

                    } else {
                        sender.sendMessage(Prefix + "Benutze /heal <Spieler>");
                        return true;
                    }
                }else{
                    player.sendMessage(Prefix + nonPermission);
                    return false;
                }

        } else {
            sender.sendMessage(Prefix + "Du bist keine Spieler!");
        }
        return false;
    }
}
