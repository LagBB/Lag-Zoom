package lagbb.lagzoom.mixin;

import lagbb.lagzoom.common.client.LagZoomClient;
import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

import net.minecraft.client.render.GameRenderer;

@Environment(EnvType.CLIENT)
@Mixin(GameRenderer.class)
public class GameRendererMixin {
	private static final MinecraftClient minecraftClient = MinecraftClient.getInstance();

	@Inject(method = "getFov(Lnet/minecraft/client/render/Camera;FZ)D", at = @At("RETURN"), cancellable = true)
	public void getZoomLevel(CallbackInfoReturnable<Double> callbackInfo) {
		if(LagZoomClient.isZooming()) {
			double fov = callbackInfo.getReturnValue();
			callbackInfo.setReturnValue(fov * LagZoomClient.zoomLevel/100);
			minecraftClient.options.cinematicCamera = LagZoomClient.cinematicCameraEnabled;
		} else {
			if(!LagZoomClient.zoomLevelAccordingToScrollEnabled){
				LagZoomClient.zoomLevel = LagZoomClient.zoomLevelDefault;
			}
			minecraftClient.options.cinematicCamera = false;
		}
	}
}


