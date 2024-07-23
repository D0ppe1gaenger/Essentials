package de.d0ppe1gaenger.essentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static de.d0ppe1gaenger.essentials.Main.Prefix;
import static de.d0ppe1gaenger.essentials.Main.nonPermission;

public class GamemodeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player){
            Player player = (Player) sender;
            if (player.hasPermission("essentials.gamemode")){
                if (args.length == 0){
                    player.sendMessage(Prefix + "Benutze /gamemode 0 | 1 | 2 | 3 | <Spieler>");
                }else if (args.length == 1) {
                    if (args[0].equalsIgnoreCase("0")){
                        player.sendMessage(Prefix + "Du bist nun im Survival Modus!");
                        player.setGameMode(GameMode.SURVIVAL);
                    }else if (args[0].equalsIgnoreCase("1")) {
                        player.sendMessage(Prefix + "Du bist nun im Creative Modus!");
                        player.setGameMode(GameMode.CREATIVE);
                    }else if (args[0].equalsIgnoreCase("2")) {
                        player.sendMessage(Prefix + "Du bist nun im Adventure Modus!");
                        player.setGameMode(GameMode.ADVENTURE);
                    }else if (args[0].equalsIgnoreCase("3")) {
                        player.sendMessage(Prefix + "Du bist nun im Spectator Modus!");
                        player.setGameMode(GameMode.SPECTATOR);
                    }else {
                        player.sendMessage(Prefix + "Benutze /gamemode 0 | 1 | 2 | 3");
                    }
                }else if (args.length == 2) {
                    Player target = Bukkit.getPlayer(args[1]);
                    if (target != null){
                        if (args[0].equalsIgnoreCase("0")){
                            player.sendMessage(Prefix + "Du hast " + args[1] + " Survival gegeben!");
                            target.sendMessage(Prefix + "Du bist nun im Survival Modus!");
                            target.setGameMode(GameMode.SURVIVAL);
                        }else if (args[0].equalsIgnoreCase("1")) {
                            player.sendMessage(Prefix + "Du hast " + args[1] + " Creative gegeben!");
                            target.sendMessage(Prefix + "Du bist nun im Creative Modus!");
                            target.setGameMode(GameMode.CREATIVE);
                        }else if (args[0].equalsIgnoreCase("2")) {
                            player.sendMessage(Prefix + "Du hast " + args[1] + " Adventure gegeben!");
                            target.sendMessage(Prefix + "Du bist nun im Adventure Modus!");
                            target.setGameMode(GameMode.ADVENTURE);
                        }else if (args[0].equalsIgnoreCase("3")) {
                            player.sendMessage(Prefix + "Du hast " + args[1] + " Spectator gegeben!");
                            target.sendMessage(Prefix + "Du bist nun im Spectator Modus!");
                            target.setGameMode(GameMode.SPECTATOR);
                        }else {
                            player.sendMessage(Prefix + "Benutze /gamemode 0 | 1 | 2 | 3");
                        }
                    }else {
                        player.sendMessage(Prefix + "Der Spieler ist nicht online!");
                        return false;
                    }

                }else {
                    player.sendMessage(Prefix + "Benutze /gamemode 0 | 1 | 2 | 3 | <Spieler>");
                    return false;
                }
            }else{
                player.sendMessage(Prefix + nonPermission);
                return false;
            }
        }
        return false;
    }
}
