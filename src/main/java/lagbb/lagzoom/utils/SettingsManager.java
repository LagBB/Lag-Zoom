package lagbb.lagzoom.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lagbb.lagzoom.common.init.LagZoomClient;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import net.fabricmc.loader.api.FabricLoader;

public class SettingsManager {
	private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
	private static final Path CONFIG_PATH = FabricLoader.getInstance().getConfigDir().resolve("LagZoom");
	private static final Path SETTINGS_PATH = CONFIG_PATH.resolve("LagZoomSettings.json");
	public static void saveSettings() {
		Settings settings = new Settings(LagZoomClient.zoomLevelDefault, LagZoomClient.cinematicCameraEnabled, LagZoomClient.zoomLevelAccordingToScrollEnabled);
		try {
			// Crea el directorio si no existe
			Files.createDirectories(SETTINGS_PATH.getParent());

			try (FileWriter writer = new FileWriter(SETTINGS_PATH.toFile())) {
				GSON.toJson(settings, writer);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public static void loadSettings() {
		try {
			if (Files.exists(SETTINGS_PATH)) {
				try (FileReader reader = new FileReader(SETTINGS_PATH.toFile())) {
					Settings settings = GSON.fromJson(reader, Settings.class);
					LagZoomClient.zoomLevelDefault = settings.zoomLevelDefault;
					LagZoomClient.cinematicCameraEnabled = settings.cinematicCameraEnabled;
					LagZoomClient.zoomLevelAccordingToScrollEnabled = settings.zoomLevelAccordingToScrollEnabled;
				}
			} else {
				// Si el archivo no existe, establece los valores predeterminados
				LagZoomClient.zoomLevelDefault = 10;
				LagZoomClient.cinematicCameraEnabled = true;
				LagZoomClient.zoomLevelAccordingToScrollEnabled = false;
				// Luego, guarda estos valores predeterminados en un nuevo archivo
				saveSettings();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	private static class Settings {
		double zoomLevelDefault;
		boolean cinematicCameraEnabled;
		boolean zoomLevelAccordingToScrollEnabled;

		Settings(double zoomLevelDefault, boolean cinematicCameraEnabled, boolean zoomLevelAccordingToScrollEnabled) {
			this.zoomLevelDefault = zoomLevelDefault;
			this.cinematicCameraEnabled = cinematicCameraEnabled;
			this.zoomLevelAccordingToScrollEnabled = zoomLevelAccordingToScrollEnabled;
		}
	}
}
