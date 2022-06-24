package me.kelopy.hubutilities;

import me.kelopy.hubutilities.events.clearWeather;
import me.kelopy.hubutilities.events.playerJoin;
import me.kelopy.hubutilities.events.playerQuit;
import me.kelopy.hubutilities.tasks.keepDayTask;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class HubUtilities extends JavaPlugin {

    private static HubUtilities instance;

    @Override
    public void onEnable() {
        System.out.println("Lobby Manager is online.");

        getConfig().options().copyDefaults();
        saveDefaultConfig();
        papi();

        new keepDayTask().runTaskTimer(this, 0L, 100L);
        getServer().getPluginManager().registerEvents(new clearWeather(), this);
        getServer().getPluginManager().registerEvents(new playerJoin(), this);
        getServer().getPluginManager().registerEvents(new playerQuit(), this);
    }

    public static HubUtilities getInstance(){
        return instance;
    }

    @Override
    public void onDisable() {
        System.out.println("Lobby Manager is offline.");
    }

    public void papi() {
        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") == null) {
            System.out.println("[Hub Utilities] Couldn't find PlaceholderAPI! Disabling Hub Utilities.");
            Bukkit.getPluginManager().disablePlugin(this);
        }
    }

}
