package lagbb.lag_things.common.blocks;

import lagbb.lag_things.common.blocks.custom.StripMiningMinaBlock;
import lagbb.lag_things.common.blocks.custom.LogoBlock;
import lagbb.lag_things.common.blocks.custom.MinaBlock;
import lagbb.lag_things.common.blocks.custom.SuperBomba;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings;

public class ModBlocks {

	public static final Block LOGO_BLOCK = new LogoBlock(QuiltBlockSettings.create());

	public static final Block MINA_BLOCK = new MinaBlock(QuiltBlockSettings.copyOf(Blocks.TNT));
	public static final StripMiningMinaBlock STRIP_MINING_MINA_BLOCK = new StripMiningMinaBlock(QuiltBlockSettings.copyOf(Blocks.TNT));

	public static final SuperBomba SUPER_BOMBA = new SuperBomba(QuiltBlockSettings.copyOf(Blocks.TNT));


	public static void register(ModContainer mod) {
		Registry.register(Registries.BLOCK, new Identifier(mod.metadata().id(), "logo_block"), LOGO_BLOCK);

		Registry.register(Registries.BLOCK, new Identifier(mod.metadata().id(), "mina_block"), MINA_BLOCK);
		Registry.register(Registries.BLOCK, new Identifier(mod.metadata().id(), "strip_mining_mina_block"), STRIP_MINING_MINA_BLOCK);
		Registry.register(Registries.BLOCK, new Identifier(mod.metadata().id(), "super_bomba"), SUPER_BOMBA);

	}

}
