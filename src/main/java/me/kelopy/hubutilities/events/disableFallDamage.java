package me.kelopy.hubutilities.events;

import me.kelopy.hubutilities.HubUtilities;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class disableFallDamage implements Listener {

    @EventHandler
    public void onFallDamage(EntityDamageEvent event){
        if(HubUtilities.getInstance().getConfig().getBoolean("fall-damage") && event.getCause().equals(EntityDamageEvent.DamageCause.FALL)){
            if(HubUtilities.Boost_Pad.contains(event.getEntity())){
                event.setCancelled(true);
                HubUtilities.Boost_Pad.remove(event.getEntity());
            }
        }
    }

}
