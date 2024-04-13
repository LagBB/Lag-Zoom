package lagbb.lagzoom.common.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.BoolArgumentType;
import com.mojang.brigadier.arguments.DoubleArgumentType;
import lagbb.lagzoom.common.client.LagZoomClient;
import lagbb.lagzoom.utils.SettingsManager;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;


public class LagZoomCommands {
	public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
		dispatcher.register(CommandManager.literal("lagzoom")
			.then(CommandManager.literal("setZoom")
				.then(CommandManager.argument("zoomAmount", DoubleArgumentType.doubleArg(10.0, 80.0))
					.executes(context -> {
						double zoom = DoubleArgumentType.getDouble(context, "zoomAmount");
						LagZoomClient.zoomLevelDefault = zoom;
						context.getSource().sendFeedback( () ->
							Text.translatable("lagzoom.lagzoomcommand.setzoom", zoom), false);
						SettingsManager.saveSettings();
						return 1;
					})))
			.then(CommandManager.literal("setCinematicCamera")
				.then(CommandManager.argument("cinematicCameraStatus", BoolArgumentType.bool())
					.executes(context -> {
						boolean cinematicCameraStatus = BoolArgumentType.getBool(context, "cinematicCameraStatus");
						LagZoomClient.cinematicCameraEnabled = cinematicCameraStatus;
						context.getSource().sendFeedback( () ->
							Text.translatable("lagzoom.lagzoomcommand.setCinematicCamera", cinematicCameraStatus), false);
						SettingsManager.saveSettings();
						return 1;
					})))
			.then(CommandManager.literal("setZoomLevelAccordingToScroll")
				.then(CommandManager.argument("zoomLevelAccordingToScrollStatus", BoolArgumentType.bool())
					.executes(context -> {
						boolean zoomLevelAccordingToScrollStatus = BoolArgumentType.getBool(context, "zoomLevelAccordingToScrollStatus");
						LagZoomClient.zoomLevelAccordingToScrollEnabled = zoomLevelAccordingToScrollStatus;
						context.getSource().sendFeedback( () ->
							Text.translatable("lagzoom.lagzoomcommand.setZoomLevelAccordingToScroll",
								zoomLevelAccordingToScrollStatus), false);
						SettingsManager.saveSettings();
						return 1;
					}))));
	}

}
