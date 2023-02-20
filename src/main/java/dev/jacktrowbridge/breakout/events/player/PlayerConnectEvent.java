package dev.jacktrowbridge.breakout.events.player;

import dev.jacktrowbridge.breakout.Breakout;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerConnectEvent implements Listener {

    Breakout plugin;
    public PlayerConnectEvent(Breakout plugin){
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onConnect(PlayerJoinEvent event){

    }

}