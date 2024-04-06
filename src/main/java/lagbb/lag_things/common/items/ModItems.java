package lagbb.lag_things.common.items;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.quiltmc.loader.api.ModContainer;
import net.minecraft.item.ItemGroups;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

import static lagbb.lag_things.common.blocks.ModBlocks.*;

public class ModItems {

	public static void register(ModContainer mod) {
		Registry.register(Registries.ITEM, new Identifier(mod.metadata().id(), "logo_block"),
			new BlockItem(LOGO_BLOCK, new QuiltItemSettings()));

		// Y aqui lo agregamos a una pestaña del inventario en creativo
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
			entries.addItem(LOGO_BLOCK.asItem());
		});
	}


}
