package lagbb.lagzoom.common.keybinds;

import com.mojang.blaze3d.platform.InputUtil;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.mixin.client.keybinding.KeyBindingAccessor;
import net.minecraft.client.option.KeyBind;
import net.minecraft.client.option.StickyKeyBind;
import org.lwjgl.glfw.GLFW;

public class LagZoomKeyBinds {


	 public static KeyBind keybinding;
	 public static KeyBind ZOOM_KEY = new KeyBind("key.lagzoom.zoom",
		 InputUtil.Type.KEYSYM,GLFW.GLFW_KEY_Z, "key.lagzoom.category");


	public LagZoomKeyBinds(){

	}
}
