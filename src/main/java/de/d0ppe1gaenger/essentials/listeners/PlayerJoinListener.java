package de.d0ppe1gaenger.essentials.listeners;

import de.d0ppe1gaenger.essentials.Main;
import de.d0ppe1gaenger.essentials.utils.VanishManager;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerJoinListener implements Listener {

    @EventHandler
    private void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        event.setJoinMessage(ChatColor.GREEN + "+ " + ChatColor.GRAY + player.getName());
        if (!player.hasPlayedBefore()){
            player.sendMessage(ChatColor.YELLOW + "Herzlich Willkommen auf dem Server " + ChatColor.RED + " <3");
        }
    }
    private void onQuit(PlayerQuitEvent event){
        Player player = event.getPlayer();
        event.setQuitMessage(ChatColor.RED + "- " + ChatColor.GRAY + player.getName());
    }

    @EventHandler
    private void onConnect(PlayerJoinEvent event){
        VanishManager manager = Main.getInstance().getVanishmanager();
        manager.hideALL(event.getPlayer());
    }
}
