# LagZoom
# Estructura General
Pueden elegir cualquier estructura, yo después de leer varios mods con el código publico llegué a esta estructura que se me hace la más comoda. `nombre_mod/common/mixin/utils` <br/>
donde `common` contiene todo lo "normal", por decirlo así, respecto al código de Minecraft. Es decir, en nuestro caso, los comandos, el archivo principal y las keybinds(teclas) que creamos para el mod.

En `mixin` estan los mixins que veremos un poco más adelante pero que en esencia son utilidades que nos permiten injectar/sobreescribir con nuestro código, el código de Minecraft. 
 
Y por ultimo  `utils` que ahí van las utilidades, obviamente. En este caso, ahí esta el código `SettingsManager` que es mi forma de guardar las configuraciones que haces con los comandos del mod.
Puede que haya mejores formas, pero a la fecha no las sé (xd) y esto funciona correctamente.

**LagZoomClient.java**
Es nuestra clase principal, acá se cargará todo el código que hagamos. <br/>
Como tal podríamos poner TODO nuestro código en este mismo archivo, pero es buena practica el ir separando nuestro código e ir llamandolo acá. Esto para tener un buen orden de código, hacerlo más entendible y poder modificarlo de manera más facil. 
`	@Override
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
	}`

Comentar que acá utilizamos el `ClientModInitializer` porque este mod es del lado del cliente y `ModContainer mod` es un parametro que contiene la metadad de tu mod, data escrita en **quilt.mod.json**.

Aqui tenemos varias cosas, el `LOGGER` nos permite escribir mensajes en la terminal, en este caso pues un simple "Hola" por ser un tutorial :D.

Llamamos también al metodo `loadsettings()` de `SettingsManager` que es el encargado de cargar los valores de según lo que el usuario vaya eligiendo. (*veremos este metodo más adelante*) <br/>
luego hacemos que `zoomLevel` sea igual al `zoomLevelDefault`
