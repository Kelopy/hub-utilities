package me.kelopy.hubutilities.events;

import me.kelopy.hubutilities.HubUtilities;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class playerQuit implements Listener {

    HubUtilities plugin;

    public playerQuit(HubUtilities plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event){
        event.setQuitMessage(plugin.getConfig().getString("quit-message"));
    }

}
