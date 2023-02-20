package dev.jacktrowbridge.breakout.util.item;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class BreakoutItem {

    private final Material type;
    private final ItemTypes rarity;

    private final Component name;

    public BreakoutItem(Material type, Component name, ItemTypes rarity){
        this.type = type;
        this.name = name;
        this.rarity = rarity;
    }

    public ItemStack buildItem(int amount){
        ItemStack itemStack = new ItemStack(type, amount);
        ItemMeta meta = itemStack.getItemMeta();

        meta.displayName(name);

        List<Component> lore = new ArrayList<>();

        if(meta.hasLore()){
            lore.addAll(Objects.requireNonNull(meta.lore()));
        }

        MiniMessage miniMessage = MiniMessage.miniMessage();

        switch (rarity) {
            case COMMON -> lore.add(miniMessage.deserialize("<white><bold>COMMON</bold></white>"));
            case UNCOMMON -> lore.add(miniMessage.deserialize("<green><bold>UNCOMMON</bold></green>"));
            case RARE -> lore.add(miniMessage.deserialize("<blue><bold>RARE</bold></blue>"));
            case EPIC -> lore.add(miniMessage.deserialize("<purple><bold>EPIC</bold></purple>"));
            case LEGENDARY -> lore.add(miniMessage.deserialize("<gold><bold>LEGENDARY</bold></gold>"));
            case SPECIAL -> lore.add(miniMessage.deserialize("<red><bold>SPECIAL</bold></red>"));
        }

        meta.lore(lore);
        itemStack.setItemMeta(meta);

        return itemStack;

    }

}
