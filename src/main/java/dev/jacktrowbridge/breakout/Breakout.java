package dev.jacktrowbridge.breakout;

import dev.jacktrowbridge.breakout.commands.plots.ClearPlotCacheCommand;
import dev.jacktrowbridge.breakout.commands.plots.CreatePlotCommand;
import dev.jacktrowbridge.breakout.event.player.PlayerConnectEvent;
import dev.jacktrowbridge.breakout.util.plot.BreakoutPlot;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.TreeMap;
import java.util.UUID;

@Getter
public class Breakout extends JavaPlugin {

    private final TreeMap<UUID, BreakoutPlot> plotCache = new TreeMap<>();

    /**
     * Called when the plugin initializes
     */
    @Override
    public void onEnable() {
        registerEvents();
        registerCommands();
    }

    /**
     * Called when the server is shutting down
     */
    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    /**
     * Registers all the event handlers for Breakout
     */
    private void registerEvents(){
        new PlayerConnectEvent(this);
    }

    /**
     * Registers all the custom commands for Breakout
     */
    private void registerCommands(){
        new CreatePlotCommand(this);
        new ClearPlotCacheCommand(this);
    }

}
