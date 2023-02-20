package dev.jacktrowbridge.breakout.event.player;

import dev.jacktrowbridge.breakout.Breakout;
import dev.jacktrowbridge.breakout.item.tools.pickaxes.DefaultPickaxe;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;

public class PlayerConnectEvent implements Listener {

    public PlayerConnectEvent(Breakout plugin){
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onConnect(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        Inventory inventory = player.getInventory();

        if (!inventory.contains(Material.WOODEN_PICKAXE)){
            inventory.addItem(new DefaultPickaxe()
                    .buildItem(1)
            );
        }
    }

}
