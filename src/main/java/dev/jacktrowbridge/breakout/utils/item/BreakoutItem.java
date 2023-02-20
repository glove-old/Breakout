package dev.jacktrowbridge.breakout.utils.item;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public abstract class BreakoutItem {

    private final Material type;
    private final String name;

    public BreakoutItem(final Material type, final String name){
        this.type = type;
        this.name = name;
    }

    public ItemStack buildItem(int amount){

        ItemStack itemStack = new ItemStack(type, amount);

        ItemMeta meta = itemStack.getItemMeta();

        // Set name
        final Component text = LegacyComponentSerializer.legacyAmpersand().deserialize(name);
        meta.displayName(text);

        itemStack.setItemMeta(meta);

        return itemStack;
    }

}
