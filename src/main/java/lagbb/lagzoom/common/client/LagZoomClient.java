package lagbb.lagzoom.common.client;

import com.mojang.brigadier.CommandDispatcher;
import lagbb.lagzoom.common.commands.LagZoomCommands;
import lagbb.lagzoom.utils.SettingsManager;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.command.CommandBuildContext;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.client.ClientModInitializer;
import org.quiltmc.qsl.command.api.CommandRegistrationCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static lagbb.lagzoom.common.keybinds.LagZoomKeyBinds.ZOOM_KEY;


public class LagZoomClient implements ClientModInitializer {

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod name as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("LagZoom Mod");

	public static boolean cinematicCameraEnabled;
	public static boolean zoomLevelAccordingToScrollEnabled;

	public static int zoomLevel;
	public static int zoomLevelDefault;

	public static boolean isZooming(){
		return ZOOM_KEY.isPressed();
	}
	@Override
	public void onInitializeClient(ModContainer mod) {
		LOGGER.info("Hola, espero aprendas con este 'tutorial' :D", mod.metadata().name());

		// Se encarga de cargar las settings del usuario.
		SettingsManager.loadSettings();

		// Establece zoomLevel igual a zoomLevelDefault después de cargar los ajustes
		zoomLevel = zoomLevelDefault;

		KeyBindingHelper.registerKeyBinding(ZOOM_KEY);

		CommandRegistrationCallback.EVENT.register(new CommandRegistrationCallback() {
			@Override
			public void registerCommands(CommandDispatcher<ServerCommandSource> dispatcher,
										 CommandBuildContext buildContext,
										 CommandManager.RegistrationEnvironment environment) {
				LagZoomCommands.register(dispatcher);
			}
		});
	}
}
