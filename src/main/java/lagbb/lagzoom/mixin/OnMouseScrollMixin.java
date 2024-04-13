package lagbb.lagzoom.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.Mouse;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import lagbb.lagzoom.common.client.LagZoomClient;

@Mixin(Mouse.class)
public class OnMouseScrollMixin {

	@Inject(method = "onMouseScroll", at = @At("HEAD"), cancellable = true)
	private void onMouseScroll(long window, double horizontal, double vertical, CallbackInfo info) {
		if (LagZoomClient.isZooming()) {

			if (window == MinecraftClient.getInstance().getWindow().getHandle()) {

				LagZoomClient.zoomLevel -= vertical * 20;
				System.out.println(LagZoomClient.zoomLevel);
				if (LagZoomClient.zoomLevel <= 10) {
					LagZoomClient.zoomLevel = 10;
				}
				if (LagZoomClient.zoomLevel >= 80) {
					LagZoomClient.zoomLevel = 80;
				}
			}
			info.cancel();
		}
	}

}
