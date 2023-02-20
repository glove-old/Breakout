package dev.jacktrowbridge.breakout.commands.plots;

import dev.jacktrowbridge.breakout.Breakout;
import dev.jacktrowbridge.breakout.utils.plots.BreakoutPlot;
import dev.jacktrowbridge.breakout.utils.plots.PlotUtils;
import dev.jorel.commandapi.CommandAPICommand;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.Map;
import java.util.UUID;

public class CreatePlotCommand {

    Breakout plugin;
    public CreatePlotCommand(Breakout plugin){
        this.plugin = plugin;

        new CommandAPICommand("createplot")
                .withPermission("breakout.createplot")
                .executesPlayer((player, args) -> {
                    PlotUtils plotUtils = new PlotUtils();
                    plotUtils.createPlot(player, plugin);
                })
                .register();

    }

}
