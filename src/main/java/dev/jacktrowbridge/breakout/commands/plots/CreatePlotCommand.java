package dev.jacktrowbridge.breakout.commands.plots;

import dev.jacktrowbridge.breakout.Breakout;
import dev.jacktrowbridge.breakout.util.plot.PlotUtils;
import dev.jorel.commandapi.CommandAPICommand;

public class CreatePlotCommand {

    public CreatePlotCommand(Breakout plugin){
        new CommandAPICommand("createplot")
                .withPermission("breakout.createplot")
                .executesPlayer((player, args) -> {
                    PlotUtils.createPlot(player, plugin);
                })
                .register();
    }

}
