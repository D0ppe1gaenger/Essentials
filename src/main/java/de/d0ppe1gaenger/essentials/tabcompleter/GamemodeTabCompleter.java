package de.d0ppe1gaenger.essentials.tabcompleter;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class GamemodeTabCompleter implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;
        if (args.length == 1){
            ArrayList<String> list = new ArrayList();
            list.add("0");
            list.add("1");
            list.add("2");
            list.add("3");
            return list;
        } else if (args.length == 2) {
            ArrayList<String> players = new ArrayList();
            for (Player p : Bukkit.getOnlinePlayers()){
                players.add(p.getName());
            }
            return players;
        }
        return null;
    }
}
