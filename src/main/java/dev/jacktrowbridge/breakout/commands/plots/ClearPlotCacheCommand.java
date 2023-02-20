package dev.jacktrowbridge.breakout.commands.plots;

import dev.jacktrowbridge.breakout.Breakout;
import dev.jacktrowbridge.breakout.util.plot.PlotUtils;
import dev.jorel.commandapi.CommandAPICommand;

public class ClearPlotCacheCommand {

    public ClearPlotCacheCommand(Breakout plugin){
        new CommandAPICommand("clearplotcache")
                .withPermission("breakout.clearplotcache")
                .executesPlayer((player, args) -> {
                    PlotUtils.clearPlotCache(plugin);
                })
                .register();

    }

}
