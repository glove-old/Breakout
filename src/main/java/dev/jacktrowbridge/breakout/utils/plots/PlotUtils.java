package dev.jacktrowbridge.breakout.utils.plots;

import dev.jacktrowbridge.breakout.Breakout;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.Map;
import java.util.UUID;

public class PlotUtils {

    public void clearPlotCache(Breakout plugin){

        for (Map.Entry<UUID, BreakoutPlot> entry : plugin.getPlotCache().entrySet()) {
            BreakoutPlot plot = entry.getValue();
            int _upperLeftX = plot.getxBlock() - plot.getPlotSize()/2;
            int _upperLeftZ = plot.getzBlock() - plot.getPlotSize()/2;
            for(int i = _upperLeftZ; i < plot.getPlotSize() + _upperLeftZ; i++) {
                for(int i2 = _upperLeftX; i2 < plot.getPlotSize() + _upperLeftX; i2++) {

                    for(int i3 = -64; i3 < 319; i3++){
                        Location loc = new Location(plugin.getServer().getWorld("world"), i2, i3, i);
                        loc.getBlock().setType(Material.AIR);
                    }

                }
            }
        }

        plugin.getPlotCache().clear();
        Bukkit.broadcast(Component.text("All plots cleared!"));

    }

    public void createPlot(Player player, Breakout plugin){

        // height limit is 319
        // bottom height limit is -64
        // 383 blocks high the plot

        UUID uuid = player.getUniqueId();

        if(plugin.getPlotCache().containsKey(uuid)){
            player.sendMessage("You already have a plot!");
            return;
        }

        int x;
        int z;

        int plotSize = 50;

        if(plugin.getPlotCache().isEmpty()){
            x = 0;
            z = 0;
        }else{

            Map.Entry<UUID, BreakoutPlot> lastPlot = null;
            for (Map.Entry<UUID, BreakoutPlot> entry : plugin.getPlotCache().entrySet()) {
                lastPlot = entry;
            }

            x = lastPlot.getValue().getxBlock() + 100;
            z = 0;

        }

        plugin.getPlotCache().put(uuid, new BreakoutPlot(x, z, plotSize, uuid, plugin.getPlotCache().size()+1));
        player.sendMessage("Plot created at " + x + ", " + z);

        player.teleport(new Location(player.getWorld(), x, 120, z));
        int _upperLeftX = x - plotSize/2;
        int _upperLeftZ = z - plotSize/2;
        for(int i = _upperLeftZ; i < plotSize + _upperLeftZ; i++) {
            for(int i2 = _upperLeftX; i2 < plotSize + _upperLeftX; i2++) {

                player.getWorld().getBlockAt(i2, 100, i).setType(Material.STONE);

                if(i == _upperLeftZ || i == plotSize + _upperLeftZ - 1 || i2 == _upperLeftX || i2 == plotSize + _upperLeftX - 1){
                    for(int i3 = -64; i3 < 319; i3++){
                        player.getWorld().getBlockAt(i2, i3, i).setType(Material.BARRIER);
                    }
                }

            }
        }

    }

}
