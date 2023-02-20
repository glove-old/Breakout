package dev.jacktrowbridge.breakout.util.block;

import lombok.experimental.UtilityClass;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;

@UtilityClass
public class BlockUtils {

    /**
     * Generates a random block clump with the provided parameters
     *
     * @param center The location of the center block
     * @param radius The radius of the clump
     * @param numBlocks The amount of blocks to use
     * @param blockType The material to use for the clump
     */
    public void generateRandomBlockClump(Location center, int radius, int numBlocks, Material blockType) {
        World world = center.getWorld();

        // Loop through and place the blocks
        for (int i = 0; i < numBlocks; i++) {
            // Choose a random coordinate within the defined area
            int x = (int) (Math.random() * (radius * 2 + 1)) + center.getBlockX() - radius;
            int y = center.getBlockY();
            int z = (int) (Math.random() * (radius * 2 + 1)) + center.getBlockZ() - radius;

            // Place the block at the selected coordinate
            Block block = world.getBlockAt(x, y, z);
            block.setType(blockType);
        }

    }

}
