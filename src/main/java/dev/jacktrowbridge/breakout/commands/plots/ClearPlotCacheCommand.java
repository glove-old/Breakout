package dev.jacktrowbridge.breakout.commands.plots;

import dev.jacktrowbridge.breakout.Breakout;
import dev.jacktrowbridge.breakout.utils.plots.PlotUtils;
import dev.jorel.commandapi.CommandAPICommand;

public class ClearPlotCacheCommand {

    Breakout plugin;
    public ClearPlotCacheCommand(Breakout plugin){
        this.plugin = plugin;

        new CommandAPICommand("clearplotcache")
                .withPermission("breakout.clearplotcache")
                .executesPlayer((player, args) -> {
                    PlotUtils plotUtils = new PlotUtils();
                    plotUtils.clearPlotCache(plugin);
                })
                .register();

    }

}
