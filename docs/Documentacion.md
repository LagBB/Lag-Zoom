# INTRODUCCION
Empece a ver a DoctorR4t mucho (creo que se nota en el video en correlación a este mod) y me motivó a meterme más enserio al Modding Minecraft. Tengo un camino largo que recorrer para aprender y poder plasmar todas mis ideas en el juego de una manera eficiente a nivel de código y bonita a nivel de estetica.

No soy un experto en crear Mods, mucho menos en Quilt, un Loader en Beta. El proposito de este repositorio es tratar de enseñar la manera en la que llegué a crear este mod y a lo mejor ayudarte a comprender más rapido los primeros pasos. 
***Si alguien con más conocimiento gusta contribuir al mod, bienvenido sea :D***

Es un tutorial bastante desde 0 para setear tus cosas para iniciar a crear tu primer MOD :D.

# Empezando
Hacer Mods para Minecraft puede ponerse complicado, con este repositorio espero ayudar a quien lo necesite y hacerle su inicio un poco más ligero, más tomando en cuenta que muy poca documentación de lo que tenga que ver con programación esta en español. 

Lo primero y más importante, a pesar de que dije que es chido improvisar y los insto a hacerlo, sino tienen un minimo conocimiento de programación solo se complicarán la vida y se frustrarán. Les recomiendo seguir un pequeño tutorial de Java, te dejo dos opciones: [Tutorial Java](https://www.google.com/search?q=java+tutorial+espa%C3%B1ol&rlz=1C1ONGR_esGT1026GT1026&oq=Java+tutorial+espa%C3%B1o&gs_lcrp=EgZjaHJvbWUqBwgAEAAYgAQyBwgAEAAYgAQyBggBEEUYOTIICAIQABgWGB4yCAgDEAAYFhgeMgwIBBAAGAoYDxgWGB4yCAgFEAAYFhgeMggIBhAAGBYYHjIICAcQABgWGB4yCggIEAAYDxgWGB6oAgCwAgE&sourceid=chrome&ie=UTF-8) o [Java desde cero - MoureDev by Brais Moure](https://www.youtube.com/watch?v=W86KTBSiX2o)

Otro requisito para adentrarte en el mundo del Modding es el ingles, pues todos los lenguajes y documentación respecto a programación suelen estar en ingles. Esto es importante porque, aunque la documentación de la Wiki de Quilt o Fabric suele ser buena para iniciar, casi siempre requeriras indagar más por aqui y por allá para poder plasmar tus ideas, todo depende en cuanto esfuerzo le pongas al buscar, la información esta ahí fuera.
[Ingles basico - INGLÉS CON EL TEACHER BOCARANDO](https://youtu.be/GWS3PCBFVgI)

# Establecer tu entorno de Desarrollo
Primero necesitaras tener un JDK para Java 17 o posterior. Yo recomiendo descargar el de Temurin Adoptiu JDK ya que son de facil acceso [Temurin Adoptium JDKs](https://adoptium.net/temurin/releases/)<br/>

Necesitaras también un IDE, [IntelliJ](https://www.jetbrains.com/idea/) es el que uso yo, es el más facil de usar. <br/>
[Eclipse](https://www.eclipse.org/topics/ide/) y [VSCode](https://code.visualstudio.com/) también funcionan, elige el que más se te haga comodo.

## Descargar Plantilla de Mod
Ahora toca descargar la plantilla [Mod-Plantilla.zip](https://github.com/QuiltMC/quilt-template-mod) <br/>
Se descarga así:
![](docs/imagenes_tutorial/descargar_zip.png)

Y extrae ese .zip en la carpeta que gustes.
*podrias clonar el repositorio oficial de la plantilla pero esta forma es más "amigable" para quienes no tengan mucho conocimiento. Les dejo este pequeño video para adentrarse más con [GIT - HolaMundo](https://youtu.be/VdGzPZ31ts8)*

## Creando el Proyecto en IntelliJ
![](docs/imagenes_tutorial/crear_proyecto_intellij.png)
*si te aparece una ventana preguntando si confias en la carpeta, presiona que si confias*

Hay un plugin que añade soporte adicional a la hora de hacer Mods para Minecraft, puedes descargarla aqui: [Plugin](https://plugins.jetbrains.com/plugin/8327-minecraft-development)

Esto es lo que veras a grandes rasgos una vez abras tu proyecto, lo más importante y que veremos más adelante es el botón de Gradle (el elefantito)
![](docs/imagenes_tutorial/idea_grandes_rasgos.png)

## Configurando tu mod
Primero debes ponerle un nombre a tu mod, el nuestro es **LagZoom** y basado en el nombre sera tu **MOD ID**. El mod id debe estar compuesto por minusculas y cualquier caracter especial o espacio debe ser reemplazado con un **_**. Además no debe existir otro mod con ese mod id, así que haz que sea unico<br/>
***Ejemplo: Nombre: LagZoom Mod,  MOD ID = lagzoom_mod***

También debes elegir un **MAVEN GROUP** que sirve para identificar el desarrollador de un mod. Suele ser el nombre de un dominio que poseas pero al reves, por ejemplo si eres dueño de **"lagzoom.tutorial.com"** tu maven group será **"com.tutorial.lagzoom"** <br/>
Si no tienes un dominio pero si una cuenta de GitHub, puedes usar **"io.github.tu_username_de_github"**, si tiene caracteres especiales tambien debes reemplazarlos con **_**

### Configurando la metadata

Si no estas familiarizado con archivos .json puedes aprender algo [aqui](https://developer.mozilla.org/es/docs/Learn/JavaScript/Objects/JSON)<br/>

Primero configuraremos el archivo `gradle.properties`, ajusta los datos acorde a lo que elegiste en la siguiente imagen estan los mios de ejemplo:
![](docs/imagenes_tutorial/gradle_properties.png)
*Nota: ya que Maven utiliza **-** para separar las palabras, si tu MOD ID consiste en palabras separadas, aqui deberia ir con un **-** en vez de **_***.

Ahora actualiza tu [quilt.mod.json](src/main/resources/quilt.mod.json) en `src/main/resources`. Aqui se definen cosas generales como el nombre de tu mod, el autor, la descripción, sitio web... pero también cosas enfocadas al desarrollo como las dependencias, la versión, el MOD ID y los MOD INITIALIZERS. <br/>

Hay varias cosas que actualizar aqui *(ver ejemplo completo al final)*:
- `"group"` deberia ser el maven group que estableciste en **gradle.properties**
- `"id"` tu MOD ID cumpliendo las reglas anteriormente descritas.
- `"metadata"`:
  - `"name"` El nombre de tu mod, este no necesita cumplir ninguna regla.
  - `"description"` Una pequeña descripción de tu mod
  - `"contributors"` Contiene quienes contribuyeron en tu mod y tu nombre como dueño. 
  - `"contact"` aqui usualmente se suele poner una forma de contacto, como el "issues" de github. *(puedes dejarlo en blanco)*
  - `"icon"` aqui deberia ir tu MOD ID.
- `"entrypoints"` dentro de este cambiaremos a **"client_init"** ya que nuestro mod es del lado del cliente <br/>
  - `"client_init"`  reemplaza **com.example.example_mod** con tu MAVEN GROUP y tu MOD ID y el ExampleMod al final deberia ser la clase principal de tu mod. En mi caso [LagZoomClient](src/main/java/lagbb/lagzoom/common/client/LagZoomClient)
- `"mixin"` Aqui actualiza el **"example_mod"** a tu MOD ID, no olvides actualizar el archivo example_mod.mixins.json en la raiz de tu proyecto. <br/>

Deberia quedarte así, sin rastros de "example":
![](docs/imagenes_tutorial/quilt_mod_json.png)


Elige una licencia para tu mod, si no sabes de licencias puedes leer esto: [Licencias](https://choosealicense.com/) <br/>
*Nota: GPL-3.0 y AGPL-3.0 son incompatibles con Minecraft, no las uses.*
Esta es la de este mod: [LagZoom Licencia](LICENSE.md)

## Estructura del Proyecto
La estructura del proyecto es simple, la raiz de tu proyecto contiene más que todo soporte proporcionado por gradle.

Tu código estará en `src/main/java/` con `src/main/java/com.tu_usuario.tu_mod`, ejemplo: `*src/main/java/lagbb/lagzoom*` siendo este el directorio principal y `src/main/resources` siendo tu directorio para los recuersos (texturas, modelos de bloques, etc)

## Generar Codigo fuente de Minecraft
Para esto vamos al gradle (el elefantito a la derecha), desplegamos la carpeta "Tasks" y la carpeta "fabric" y luego ejecutamos con dobleclick "genSourcesWithVineflower"
![](docs/imagenes_tutorial/gradle_vineflower.png)

y finalmente recargamos el gradle
![](docs/imagenes_tutorial/gradle_recarga.png)






