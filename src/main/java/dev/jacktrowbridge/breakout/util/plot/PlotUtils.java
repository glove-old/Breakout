package dev.jacktrowbridge.breakout.util.plot;

import dev.jacktrowbridge.breakout.Breakout;
import dev.jacktrowbridge.breakout.util.block.BlockUtils;
import lombok.experimental.UtilityClass;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;

@UtilityClass
public class PlotUtils {

    private final World world = Bukkit.getWorld("world");

    public void clearPlotCache(Breakout plugin){
        for (Map.Entry<UUID, BreakoutPlot> entry : plugin.getPlotCache().entrySet()) {
            BreakoutPlot plot = entry.getValue();

            int upperLeftX = plot.getXBlock() - plot.getPlotSize() / 2;
            int upperLeftZ = plot.getZBlock() - plot.getPlotSize() / 2;

            for(int z = upperLeftZ; z < plot.getPlotSize() + upperLeftZ; z++) {
                for(int x = upperLeftX; x < plot.getPlotSize() + upperLeftX; x++) {
                    for(int y = -64; y < 319; y++){
                        Location loc = new Location(world, x, y, z);

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
        TreeMap<UUID, BreakoutPlot> plotCache = plugin.getPlotCache();

        if (plotCache.containsKey(uuid)) {
            player.sendMessage("You already have a plot!");
            return;
        }

        int x;
        int z;

        int plotSize = 50;

        if (plugin.getPlotCache().isEmpty()){
            x = 0;
        } else {
            Map.Entry<UUID, BreakoutPlot> lastPlot = plotCache.lastEntry();

            x = lastPlot.getValue().getXBlock() + 100;
        }

        z = 0;

        plotCache.put(uuid, new BreakoutPlot(x, z, plotSize, uuid, plotCache.size() + 1));

        player.sendMessage("Plot created at " + x + ", " + z);
        player.teleport(new Location(world, x, 120, z));

        int upperLeftX = x - plotSize / 2;
        int upperLeftZ = z - plotSize / 2;

        for (int i = upperLeftZ; i < plotSize + upperLeftZ; i++) {
            for (int i2 = upperLeftX; i2 < plotSize + upperLeftX; i2++) {
                world.getBlockAt(i2, 100, i).setType(Material.STONE_BRICKS);

                if (i == upperLeftZ || i == plotSize + upperLeftZ - 1 || i2 == upperLeftX || i2 == plotSize + upperLeftX - 1) {
                    for (int i3 = -64; i3 < 319; i3++) {
                        player.getWorld().getBlockAt(i2, i3, i).setType(Material.BARRIER);
                    }
                }

            }
        }

        BlockUtils.generateRandomBlockClump(new Location(world, x, 100, z), 5, 10, Material.COAL_ORE);
    }

}
