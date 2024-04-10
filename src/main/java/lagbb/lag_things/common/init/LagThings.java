package lagbb.lag_things.common.init;

import lagbb.lag_things.common.blocks.ModBlocks;
import lagbb.lag_things.common.items.ModItems;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import org.joml.Matrix4f;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LagThings implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod name as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("LagThings Mod");
	@Override
	public void onInitialize(ModContainer mod) {
		LOGGER.info("Hola Mundo de Quilt :D!", mod.metadata().name());

		ModItems.register(mod);
		ModBlocks.register(mod);

	}
}
