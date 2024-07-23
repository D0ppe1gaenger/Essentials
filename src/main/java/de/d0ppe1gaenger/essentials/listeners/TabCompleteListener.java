package de.d0ppe1gaenger.essentials.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.TabCompleteEvent;

public class TabCompleteListener implements Listener {
    @EventHandler
    public void onTab(TabCompleteEvent event){
        Player player = (Player) event.getSender();
        if (player instanceof Player){
            if (!player.hasPermission("system.tab") && event.getBuffer().startsWith("/")){
                event.setCancelled(true);
            }
        }
    }
}

