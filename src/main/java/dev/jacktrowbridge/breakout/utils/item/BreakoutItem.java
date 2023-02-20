package dev.jacktrowbridge.breakout.utils.item;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public abstract class BreakoutItem {

    private final Material type;
    private final Component name;
    private final ItemTypes rarity;

    public BreakoutItem(final Material type, final Component name, final ItemTypes rarity){
        this.type = type;
        this.name = name;
        this.rarity = rarity;
    }

    public ItemStack buildItem(int amount){

        ItemStack itemStack = new ItemStack(type, amount);

        ItemMeta meta = itemStack.getItemMeta();

        meta.displayName(name);

        ArrayList<Component> lore = new ArrayList<>();
        if(meta.hasLore()){
            lore.addAll(meta.lore());
        }

        switch (rarity) {
            case COMMON -> lore.add(MiniMessage.miniMessage().deserialize("<white><bold>COMMON</bold></white>"));
            case UNCOMMON -> lore.add(MiniMessage.miniMessage().deserialize("<green><bold>UNCOMMON</bold></green>"));
            case RARE -> lore.add(MiniMessage.miniMessage().deserialize("<blue><bold>RARE</bold></blue>"));
            case EPIC -> lore.add(MiniMessage.miniMessage().deserialize("<purple><bold>EPIC</bold></purple>"));
            case LEGENDARY -> lore.add(MiniMessage.miniMessage().deserialize("<gold><bold>LEGENDARY</bold></gold>"));
            case SPECIAL -> lore.add(MiniMessage.miniMessage().deserialize("<red><bold>SPECIAL</bold></red>"));
        }

        meta.lore(lore);

        itemStack.setItemMeta(meta);

        return itemStack;

    }

}
