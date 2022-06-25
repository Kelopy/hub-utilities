package me.kelopy.hubutilities.events;

import me.kelopy.hubutilities.HubUtilities;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class playerMove implements Listener {

    @EventHandler
    public void onMove(PlayerMoveEvent event){

        if(HubUtilities.getInstance().getConfig().getBoolean("boost-pad")){
            Player player = event.getPlayer();
            Location blockUnder = player.getLocation();
            blockUnder.setY(blockUnder.getY() - 1);

            if(
                    player.getLocation().getBlock().getType().equals(Material.valueOf(HubUtilities.getInstance().getConfig().getString("top-block")))
                            &&
                    blockUnder.getBlock().getType().equals(Material.valueOf(HubUtilities.getInstance().getConfig().getString("under-block")))
              ){
                player.setVelocity(player.getLocation().getDirection().multiply(HubUtilities.getInstance().getConfig().getInt("velocity-multiplier")).setY(HubUtilities.getInstance().getConfig().getInt("y-velocity")));
                HubUtilities.Boost_Pad.add(player);

                if(HubUtilities.getInstance().getConfig().getBoolean("message-enable")){
                    String message = HubUtilities.getInstance().getConfig().getString("message");
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
                }

            }

        }

    }

}
