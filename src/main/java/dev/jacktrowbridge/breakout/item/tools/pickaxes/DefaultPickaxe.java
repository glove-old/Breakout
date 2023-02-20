package dev.jacktrowbridge.breakout.item.tools.pickaxes;

import dev.jacktrowbridge.breakout.util.item.BreakoutItem;
import dev.jacktrowbridge.breakout.util.item.ItemTypes;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;

public class DefaultPickaxe extends BreakoutItem {
    public DefaultPickaxe() {

        super(Material.WOODEN_PICKAXE,
                MiniMessage.miniMessage().deserialize("<white>Default</white> <gray>Pickaxe</gray>"),
                ItemTypes.COMMON);
    }
}
