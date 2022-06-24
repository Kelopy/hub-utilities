package me.kelopy.hubutilities.events;

import me.clip.placeholderapi.PlaceholderAPI;
import me.kelopy.hubutilities.HubUtilities;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class playerJoin implements Listener {

    HubUtilities plugin;

    public playerJoin(HubUtilities plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player p = event.getPlayer();

        String joinMessage = plugin.getConfig().getString("join-message");
        joinMessage = PlaceholderAPI.setPlaceholders(p, joinMessage);
        event.setJoinMessage(joinMessage);
        p.playSound(p.getLocation(), Sound.BLOCK_NOTE_PLING, 1.0f, 1.0f);

        if(plugin.getConfig().getBoolean("first-join")){
            if(!p.hasPlayedBefore()){
                String firstJoinMessage = plugin.getConfig().getString("first-join-msg");
                firstJoinMessage = PlaceholderAPI.setPlaceholders(p, firstJoinMessage);
                event.setJoinMessage(firstJoinMessage);
                p.playSound(p.getLocation(), Sound.BLOCK_NOTE_PLING, 1.0f, 1.0f);
            }
        }

        if(plugin.getConfig().getBoolean("motd")){
            for(int i = 0; i < (plugin.getConfig().getList("motd-message").size()); i++){
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getList("motd-message").get(i).toString()));
            }
        }

    }

}
