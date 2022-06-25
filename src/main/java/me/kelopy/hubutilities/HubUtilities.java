package me.kelopy.hubutilities;

import me.kelopy.hubutilities.events.*;
import me.kelopy.hubutilities.tasks.keepDayTask;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class HubUtilities extends JavaPlugin {

    public static ArrayList<Player> Boost_Pad = new ArrayList<>();

    private static HubUtilities instance;

    @Override
    public void onEnable() {
        papi();
        System.out.println("Lobby Manager is online.");

        getConfig().options().copyDefaults();
        saveDefaultConfig();
        instance = this;

        new keepDayTask().runTaskTimer(this, 0L, 100L);
        getServer().getPluginManager().registerEvents(new clearWeather(), this);
        getServer().getPluginManager().registerEvents(new playerJoin(), this);
        getServer().getPluginManager().registerEvents(new playerQuit(), this);
        getServer().getPluginManager().registerEvents(new playerMove(), this);
        getServer().getPluginManager().registerEvents(new disableFallDamage(), this);
    }

    public static HubUtilities getInstance(){
        return instance;
    }

    public void papi() {
        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") == null) {
            System.out.println("[Hub Utilities] Couldn't find PlaceholderAPI! Disabling Hub Utilities.");
            Bukkit.getPluginManager().disablePlugin(this);
        }
    }

}
