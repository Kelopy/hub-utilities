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

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player p = event.getPlayer();

        String joinMessage = HubUtilities.getInstance().getConfig().getString("join-message");
        joinMessage = PlaceholderAPI.setPlaceholders(p, joinMessage);
        event.setJoinMessage(joinMessage);
        p.playSound(p.getLocation(), Sound.BLOCK_NOTE_PLING, 1.0f, 1.0f);

        if(HubUtilities.getInstance().getConfig().getBoolean("first-join")){
            if(!p.hasPlayedBefore()){
                String firstJoinMessage = HubUtilities.getInstance().getConfig().getString("first-join-msg");
                firstJoinMessage = PlaceholderAPI.setPlaceholders(p, firstJoinMessage);
                event.setJoinMessage(firstJoinMessage);
                p.playSound(p.getLocation(), Sound.BLOCK_NOTE_PLING, 1.0f, 1.0f);
            }
        }

        if(HubUtilities.getInstance().getConfig().getBoolean("motd")){
            for(String s : HubUtilities.getInstance().getConfig().getStringList("motd-message")){
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', s));
            }
        }

    }

}
