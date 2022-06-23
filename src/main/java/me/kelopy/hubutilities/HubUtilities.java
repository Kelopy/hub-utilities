package me.kelopy.hubutilities;

import me.kelopy.hubutilities.events.clearWeather;
import me.kelopy.hubutilities.tasks.keepDayTask;
import org.bukkit.plugin.java.JavaPlugin;

public final class HubUtilities extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("Lobby Manager is online.");

        getConfig().options().copyDefaults();
        saveDefaultConfig();

        getServer().getPluginManager().registerEvents(new clearWeather(), this);
        new keepDayTask(this).runTaskTimer(this, 0L, 100L);
    }

    @Override
    public void onDisable() {
        System.out.println("Lobby Manager is offline.");
    }

}
