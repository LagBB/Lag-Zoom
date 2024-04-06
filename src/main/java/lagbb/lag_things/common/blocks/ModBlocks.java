package lagbb.lag_things.common.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings;

public class ModBlocks {

	public static final Block LOGO_BLOCK = new Block(QuiltBlockSettings.create());

	public static void register(ModContainer mod) {
		Registry.register(Registries.BLOCK, new Identifier(mod.metadata().id(), "logo_block"), LOGO_BLOCK);
	}

}
