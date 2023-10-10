package net.momirealms.customfishing.gui.icon.property.item;

import net.momirealms.customfishing.adventure.AdventureManagerImpl;
import net.momirealms.customfishing.adventure.component.ShadedAdventureComponentWrapper;
import net.momirealms.customfishing.gui.ItemPage;
import net.momirealms.customfishing.gui.page.property.NBTEditor;
import net.momirealms.customfishing.util.ConfigUtils;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.jetbrains.annotations.NotNull;
import xyz.xenondevs.invui.item.ItemProvider;
import xyz.xenondevs.invui.item.builder.ItemBuilder;
import xyz.xenondevs.invui.item.impl.AbstractItem;

public class NBTItem extends AbstractItem {

    private final ItemPage itemPage;

    public NBTItem(ItemPage itemPage) {
        this.itemPage = itemPage;
    }

    @Override
    public ItemProvider getItemProvider() {
        ItemBuilder itemBuilder = new ItemBuilder(Material.COMMAND_BLOCK)
                .setDisplayName(new ShadedAdventureComponentWrapper(AdventureManagerImpl.getInstance().getComponentFromMiniMessage(
                        "<#FA8072>● NBT"
                )));
        var section = itemPage.getSection().getConfigurationSection("nbt");
        if (section != null) {
            itemBuilder.addLoreLines(new ShadedAdventureComponentWrapper(AdventureManagerImpl.getInstance().getComponentFromMiniMessage(
                            "<gray>Current value: "
                    )));
            for (String line : ConfigUtils.getReadableSection(section.getValues(false))) {
                itemBuilder.addLoreLines(new ShadedAdventureComponentWrapper(AdventureManagerImpl.getInstance().getComponentFromMiniMessage(
                        line
                )));
            }

            itemBuilder.addLoreLines("").addLoreLines(new ShadedAdventureComponentWrapper(AdventureManagerImpl.getInstance().getComponentFromMiniMessage(
                    "<#00FF7F> -> Left click to edit"
            ))).addLoreLines(new ShadedAdventureComponentWrapper(AdventureManagerImpl.getInstance().getComponentFromMiniMessage(
                    "<#FF6347> -> Right click to reset"
            )));
        } else {
            itemBuilder.addLoreLines(new ShadedAdventureComponentWrapper(AdventureManagerImpl.getInstance().getComponentFromMiniMessage(
                    "<#00FF7F> -> Left click to set"
            )));
        }

        return itemBuilder;
    }

    @Override
    public void handleClick(@NotNull ClickType clickType, @NotNull Player player, @NotNull InventoryClickEvent event) {
        if (clickType.isLeftClick()) {
            new NBTEditor(player, itemPage, itemPage.getSection());
        } else if (clickType.isRightClick()) {
            itemPage.getSection().set("nbt", null);
            itemPage.save();
            itemPage.reOpen();
        }
    }
}
