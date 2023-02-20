package dev.jacktrowbridge.breakout.util.plot;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter @AllArgsConstructor
public class BreakoutPlot {

    private final int xBlock;
    private final int zBlock;
    private final int plotSize;

    private final UUID playerUUID;
    private final int cacheId;

}
