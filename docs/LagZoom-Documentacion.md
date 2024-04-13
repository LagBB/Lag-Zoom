# LagZoom
# Estructura
Pueden elegir cualquier estructura que cumpla con alguna regla tipica de orden (io.github.lagbb), yo después de leer varios mods con el código publico llegué a esta estructura que se me hace la más comoda. `nombre_mod/common/mixin/utils` <br/>
donde `common` contiene todo lo "normal", por decirlo así, respecto al código de Minecraft. Es decir, en nuestro caso, los comandos, el archivo principal y las keybinds(teclas) que creamos para el mod.

En `mixin` estan los mixins que en esencia son utilidades que nos permiten injectar/sobreescribir con nuestro código, el código de Minecraft. <br/>
Mencionar que cada mixin que crees debes añadirlo al [tu_mod.mixinx.json](https://github.com/LagBB/Lag-Zoom/blob/master/src/main/resources/lagzoom.mixins.json).

Y por ultimo  `utils` que ahí van las utilidades, obviamente. En este caso, ahí esta el código `SettingsManager` que es mi forma de guardar las configuraciones que haces con los comandos del mod.
Puede que haya mejores formas, pero a la fecha no las sé (xd) y esto funciona correctamente.

# Archivo Principal
**LagZoomClient.java**
Es nuestra clase principal, acá se cargará todo el código que hagamos. <br/>
Como tal podríamos poner TODO nuestro código en este mismo archivo, pero es buena practica el ir separando nuestro código e ir llamandolo acá. Esto para tener un buen orden de código, hacerlo más entendible y poder modificarlo de manera más facil. 

```java

public class LagZoomClient implements ClientModInitializer {

	@Override
	public void onInitializeClient(ModContainer mod) {

		//Aqui se carga todo nuestro codigo
	}
}
```
Comentar que acá utilizamos el `ClientModInitializer` porque este mod es del lado del cliente y `ModContainer mod` es un parametro que contiene la metadad de tu mod, data escrita en **quilt.mod.json**.

```java
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
```
Aqui tenemos varias cosas, el `LOGGER` nos permite escribir mensajes en la terminal, en este caso pues un simple "Hola" por ser un tutorial :D.

Llamamos también al metodo `loadsettings()` de `SettingsManager` que es el encargado de cargar los valores según lo que el usuario vaya eligiendo con los comandos. <br/>
luego hacemos que `zoomLevel` sea igual al `zoomLevelDefault` pues ya se cargaron los valores desde el settings.json que graba `savesettings()` de `SettingsManager`.

`KeyBindingHelper.registerKeyBinding(ZOOM_KEY);` es el encargado de registrar nuestra tecla (creada en otro archivo), este helper de fabric lo que hace es registrar al completo tu tecla, es decir, ponerla en el menu de "Opciones > controles > teclas..." <br/>

Y por ultimo estamos registrando nuestros comandos,
utilizando una clase anónima que implementa `CommandRegistrationCallback` y sobrescribe el método `registerCommands`. <br/>
Los comandos y keybinds estan en `src/main/java/lagbb/lagzoom/common/commands` y `/keybinds` respectivamente.


# Tecla Custom
Las teclas custom son bastante facil, [la documentacion de Fabric](https://fabricmc.net/wiki/tutorial:keybinds) cubre bien este tema.

Sin embargo, mencionar que no utilice `ClientTickEvents` como es presentado en la documentación, esto es algo que le "preste" a LogicalZoom también. <br/>
Que lo que hace es regresar el valor booleano del metodo `isPressed()` de las teclas. True significa que nuestra tecla esta siendo presionada y False que no.
```java
public class LagZoomClient implements ClientModInitializer {

	public static boolean isZooming(){
		return ZOOM_KEY.isPressed();
	}
```

Y dicho valor es comprobado en `GameRendererMixin` con un IF, esto hace que nos devuelva el valor de la tecla cada que el juego renderiza algo.
```java
if(LagZoomClient.isZooming()) {
}
``` 
# Comandos
Los comandos fue un poco raro, porque la [documentacion de Quilt](https://wiki.quiltmc.org/en/introduction/get-started) no contiene esto aún y la [documentacion de Fabric](https://fabricmc.net/wiki/tutorial:commands) o no esta actualizada o en Quilt no termina de funcionar. <br/>

Así que les recomiendo empezar con la [documentación de Fabric](https://fabricmc.net/wiki/tutorial:commands) y luego usar la [documentacion de Brigadier](https://github.com/Mojang/brigadier), esto junto con el [código](https://github.com/LagBB/Lag-Zoom/blob/master/src/main/java/lagbb/lagzoom/common/commands/LagZoomCommands.java) debería ser suficiente para entender.
