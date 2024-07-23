package de.d0ppe1gaenger.essentials.commands;

import de.d0ppe1gaenger.essentials.Main;
import de.d0ppe1gaenger.essentials.utils.VanishManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static de.d0ppe1gaenger.essentials.Main.Prefix;
import static de.d0ppe1gaenger.essentials.Main.nonPermission;


public class VanishCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        VanishManager vanishManager = Main.getInstance().getVanishmanager();
        Player player = (Player) sender;
        if (player.hasPermission("system.vanish.other")) {
            if (args.length == 1){
                Player target = Bukkit.getPlayer(args[0]);
                if (target == null) {
                    sender.sendMessage(Prefix + "Der angegebene Spieler ist nicht online!");
                    return true;
                }
                if (vanishManager.isVanished(player)){
                    vanishManager.setVanished(player, false);
                    player.sendMessage(Prefix + "Der Spieler ist jetzt nicht mehr im Vanish!");
                }else {
                    vanishManager.setVanished(player, true);
                    player.sendMessage(Prefix + "Der Spieler ist jetzt im Vanish!");
                }
                return true;

            } else if (player.hasPermission("system.vanish")) {
                if (vanishManager.isVanished(player)){
                    vanishManager.setVanished(player, false);
                    player.sendMessage(Prefix + "Du bist jetzt nicht mehr im Vanish!");
                }else {
                    vanishManager.setVanished(player, true);
                    player.sendMessage(Prefix + "Du bist jetzt im Vanish!");
                }
                return true;
            }
            sender.sendMessage(Prefix + "Benutze /vanish <Spieler>");
            return false;
        }
        sender.sendMessage(Prefix + nonPermission);
        return false;
    }
}
