package lagbb.lag_things.common.items;

import net.minecraft.item.BlockItem;
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

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
			entries.addItem(LOGO_BLOCK.asItem());
		});

		Registry.register(Registries.ITEM, new Identifier(mod.metadata().id(), "mina_block"),
			new BlockItem(MINA_BLOCK, new QuiltItemSettings()));

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.REDSTONE_BLOCKS).register(entries -> {
			entries.addItem(MINA_BLOCK.asItem());
		});

		Registry.register(Registries.ITEM, new Identifier(mod.metadata().id(), "strip_mining_mina_block"),
			new BlockItem(STRIP_MINING_MINA_BLOCK, new QuiltItemSettings()));

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.REDSTONE_BLOCKS).register(entries -> {
			entries.addItem(STRIP_MINING_MINA_BLOCK.asItem());
		});

		Registry.register(Registries.ITEM, new Identifier(mod.metadata().id(), "super_bomba"),
			new BlockItem(SUPER_BOMBA, new QuiltItemSettings()));

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
			entries.addItem(SUPER_BOMBA.asItem());
		});
	}


}
