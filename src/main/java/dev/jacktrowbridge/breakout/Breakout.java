package dev.jacktrowbridge.breakout;

import dev.jacktrowbridge.breakout.commands.plots.ClearPlotCacheCommand;
import dev.jacktrowbridge.breakout.commands.plots.CreatePlotCommand;
import dev.jacktrowbridge.breakout.events.player.PlayerConnectEvent;
import dev.jacktrowbridge.breakout.utils.plots.BreakoutPlot;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.UUID;

public final class Breakout extends JavaPlugin {

    HashMap<UUID, BreakoutPlot> plotCache = new HashMap<>();

    @Override
    public void onEnable() {
        // Plugin startup logic
        registerEvents();
        registerCommands();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    void registerEvents(){
        new PlayerConnectEvent(this);
    }

    void registerCommands(){
        new CreatePlotCommand(this);
        new ClearPlotCacheCommand(this);
    }

    // Getters
    public HashMap<UUID, BreakoutPlot> getPlotCache() {
        return plotCache;
    }

}
