package me.kelopy.hubutilities.tasks;

import me.kelopy.hubutilities.HubUtilities;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public class keepDayTask extends BukkitRunnable {

    @Override
    public void run() {
        String world = HubUtilities.getInstance().getConfig().getString("world-name");
        if(Bukkit.getServer().getWorld(world) != null){
            Bukkit.getServer().getWorld(world).setTime(0L);
        }else{
            System.out.println("[Hub Utilities] world " + '"' + world + '"' + " doesn't exist. edit the config.yml");
        }
    }

}
