package dev.jacktrowbridge.breakout.utils.plots;

import java.util.UUID;

public class BreakoutPlot {

    final int xBlock;
    final int zBlock;
    final int plotSize;
    final UUID playerUUID;
    final int cacheID;

    public BreakoutPlot(int xBlock, int zBlock, int plotSize, UUID playerUUID, int cacheID){
        this.xBlock = xBlock;
        this.zBlock = zBlock;
        this.plotSize = plotSize;
        this.playerUUID = playerUUID;
        this.cacheID = cacheID;
    }

    public int getxBlock() {
        return xBlock;
    }

    public int getzBlock() {
        return zBlock;
    }

    public int getPlotSize(){
        return plotSize;
    }

}
