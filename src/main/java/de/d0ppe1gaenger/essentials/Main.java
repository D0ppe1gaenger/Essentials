package de.d0ppe1gaenger.essentials;

import de.d0ppe1gaenger.essentials.commands.GamemodeCommand;
import de.d0ppe1gaenger.essentials.commands.HealCommand;
import de.d0ppe1gaenger.essentials.commands.VanishCommand;
import de.d0ppe1gaenger.essentials.listeners.PlayerJoinListener;
import de.d0ppe1gaenger.essentials.listeners.TabCompleteListener;
import de.d0ppe1gaenger.essentials.tabcompleter.GamemodeTabCompleter;
import de.d0ppe1gaenger.essentials.tabcompleter.HealTabCompleter;
import de.d0ppe1gaenger.essentials.utils.VanishManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    private static Main instance;
    private VanishManager vanishmanager;

    public static String Prefix = ChatColor.GREEN + "Essentials" + ChatColor.GRAY + " : ";
    public static String nonPermission = ChatColor.RED + "Du hast keine Rechte!";

    @Override
    public void onEnable() {
        instance = this;
        this.vanishmanager = new VanishManager(this);

        getCommand("heal").setExecutor(new HealCommand());
        getCommand("gamemode").setExecutor(new GamemodeCommand());
        getCommand("vanish").setExecutor(new VanishCommand());

        getCommand("gamemode").setTabCompleter(new GamemodeTabCompleter());
        getCommand("heal").setTabCompleter(new HealTabCompleter());

        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new PlayerJoinListener(), this);
        pm.registerEvents(new TabCompleteListener(), this);

        Bukkit.getConsoleSender().sendMessage(Prefix + "Das Plugin wurde erfolgreich gestartet!");

    }

    @Override
    public void onDisable() {

        Bukkit.getConsoleSender().sendMessage(Prefix + "Das Plugin wurde gestoppt!");
    }

    public static Main getInstance() {
        return instance;
    }

    public VanishManager getVanishmanager() {
        return vanishmanager;
    }
}
