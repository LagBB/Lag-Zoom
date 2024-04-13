# INTRODUCCIÓN
Empece a ver mucho a DoctorR4t (creo que se nota en el video en correlación a este mod) y me motivó a meterme más en serio al Modding Minecraft. Tengo un camino largo que recorrer para aprender y poder plasmar todas mis ideas en el juego de una manera eficiente a nivel de código y bonita a nivel de estética.

No soy un experto en crear Mods, mucho menos en Quilt, un Loader en Beta. El propósito de este repositorio es tratar de enseñar la manera en la que llegué a crear este mod y a lo mejor ayudarte a comprender más rápido los primeros pasos.
***Si alguien con más conocimiento gusta contribuir al mod, bienvenido sea :D***

Es un tutorial muy desde 0 para setear todas tus cosas para empezar a crear tu primer MOD :D.

# Empezando
Hacer Mods para Minecraft puede ponerse complicado, con este repositorio espero ayudar a quien lo necesite y hacerle su inicio un poco más ligero, más tomando en cuenta que muy poca documentación de lo que tenga que ver con programación está en español.

Lo primero y más importante, a pesar de que dije que es chido improvisar y los insto a hacerlo, si no tienen un mínimo conocimiento de programación solo se complicarán la vida y se frustrarán. Les recomiendo seguir un pequeño tutorial de Java, te dejo dos opciones: [Tutorial Java](https://www.guru99.com/es/java-tutorial.html) o [Java desde cero - MoureDev by Brais Moure](https://www.youtube.com/watch?v=W86KTBSiX2o)

Otro requisito para adentrarte en el mundo del Modding es el inglés, pues todos los lenguajes y documentación respecto a programación suelen estar en ingles. Esto es importante porque, aunque la documentación de la Wiki de Quilt o Fabric suele ser buena opción para iniciar, casi siempre necesitarás indagar más por aquí y por allá para poder plasmar tus ideas, todo depende de cuanto esfuerzo le pongas al buscar, la información está ahí fuera.
Aprende algo de ingles: [Ingles básico - INGLÉS CON EL TEACHER BOCARANDO](https://youtu.be/GWS3PCBFVgI) 

# Establecer tu entorno de Desarrollo
Primero necesitarás tener un JDK para Java 17 o posterior. Yo recomiendo descargar el de Temurin Adoptium JDK, ya que son de fácil acceso [Temurin Adoptium JDKs](https://adoptium.net/temurin/releases/)

Necesitarás también un IDE, [IntelliJ](https://www.jetbrains.com/idea/) es el que uso yo, es el más fácil de usar.
[Eclipse](https://www.eclipse.org/topics/ide/) y [VSCode](https://code.visualstudio.com/) también funcionan, elige el que más se te haga cómodo.

## Descargar Plantilla de Mod
Ahora toca descargar la plantilla [Mod-Plantilla.zip](https://github.com/QuiltMC/quilt-template-mod)
Se descarga así:
<br/>
![](https://github.com/LagBB/Lag-Zoom/blob/master/docs/imagenestutorial/descargarzip.png)
<br/>
<br/>
Y extrae ese .zip en la carpeta que gustes.
Podrías clonar el repositorio oficial de la plantilla, pero esta forma es más "amigable" para quienes no tengan mucho conocimiento. <br/>

Les dejo este pequeño video para adentrarse más con [GIT - HolaMundo](https://youtu.be/VdGzPZ31ts8)*

## Creando el Proyecto en IntelliJ
![](https://github.com/LagBB/Lag-Zoom/blob/master/docs/imagenestutorial/crearproyectointellij.png)
*si te aparece una ventana preguntando si confías en la carpeta, presiona que si confías*

Hay un plugin que añade soporte adicional a la hora de hacer Mods para Minecraft, puedes descargarla aquí: [Plugin](https://plugins.jetbrains.com/plugin/8327-minecraft-development)

Esto es lo que verás a grandes rasgos una vez abras tu proyecto, lo más importante y que veremos más adelante es el botón de Gradle (el elefantito)
![](https://github.com/LagBB/Lag-Zoom/blob/master/docs/imagenestutorial/ideagrandesrasgos.png)
<br/>
## Configurando tu mod
Primero debes ponerle un nombre a tu mod, el nuestro es **LagZoom** y basado en el nombre será tu **MOD ID**. El mod id debe estar compuesto por minúsculas y cualquier carácter especial o espacio debe ser reemplazado con un **("_") (guión bajo)**. Además no debe existir otro mod con ese mod id, así que haz que sea único
***Ejemplo: <br/>
Nombre: LagZoom Mod, <br/>
MOD ID = lagzoom_mod*** <br/>

También debes elegir un **MAVEN GROUP** que sirve para identificar el desarrollador de un mod. Suele ser el nombre de un dominio que poseas, pero al revés, por ejemplo si eres dueño de **"lagzoom.tutorial.com"** tu maven group será **"com.tutorial.lagzoom"**
Si no tienes un dominio, pero si una cuenta de GitHub, puedes usar **"io.github.tu_username_de_github"**, si tiene caracteres especiales también debes reemplazarlos con **("_")**

### Configurando la metadata

Si no estás familiarizado con archivos JSON puedes aprender algo [aquí](https://developer.mozilla.org/es/docs/Learn/JavaScript/Objects/JSON)

Primero configuraremos el archivo `gradle.properties`, ajusta los datos según lo que elegiste, en la siguiente imagen están los míos de ejemplo:
<br/>
![](https://github.com/LagBB/Lag-Zoom/blob/master/docs/imagenestutorial/gradleproperties.png)
<br/>
*Nota: ya que Maven utiliza **("-")** para separar las palabras, si tu MOD ID consiste en palabras separadas, aquí debería ir con un **("-")** en vez de **("_")***.

Ahora actualiza tú [quilt.mod.json](https://github.com/LagBB/Lag-Zoom/blob/master/src/main/resources/quilt.mod.json) en `src/main/resources`. Aquí se definen cosas generales como el nombre de tu mod, el autor, la descripción, sitio web... pero también cosas enfocadas al desarrollo como las dependencias, la versión, el MOD ID y los MOD INITIALIZERS.

Hay varias cosas que actualizar aquí *(ver ejemplo completo al final)*:
- `"group"` debería ser el maven group que estableciste en **gradle.properties**
- `"id"` tu MOD ID cumpliendo las reglas anteriormente descritas.
- `"metadata"`:
    - `"name"` El nombre de tu mod, este no necesita cumplir ninguna regla.
    - `"description"` Una pequeña descripción de tu mod
    - `"contributors"` Contiene quienes contribuyeron en tu mod y tu nombre como dueño.
    - `"contact"` aquí usualmente se suele poner una forma de contacto, como el "issues" de github. *(puedes dejarlo en blanco)*
    - `"icon"` aquí debería ir tu MOD ID.
- `"entrypoints"` dentro de este cambiaremos a **"client_init"**, ya que nuestro mod es del lado del cliente
    - `"client_init"` reemplaza **com.example.example_mod** con tu MAVEN GROUP y tu MOD ID y el ExampleMod al final debería ser la clase principal de tu mod. En mi caso [LagZoomClient](src/main/java/lagbb/lagzoom/common/client/LagZoomClient)
- `"mixin"` Aqui actualiza el **"example_mod"** a tu MOD ID, no olvides actualizar el archivo example_mod.mixins.json en la raiz de tu proyecto.

Debería quedarte así, sin rastros de "example":
<br/>
![](https://github.com/LagBB/Lag-Zoom/blob/master/docs/imagenestutorial/quiltmodjson.png)
<br/>

Elige una licencia para tu mod, si no sabes de licencias puedes leer esto: [Licencias](https://choosealicense.com/)<br/>
*Nota: GPL-3.0 y AGPL-3.0 son incompatibles con Minecraft, no las uses.*<br/>
Esta es la de este mod: [LagZoom Licencia](https://github.com/LagBB/Lag-Zoom/blob/master/LICENSE.md)

## Estructura del Proyecto
La estructura del proyecto es simple, la raíz de tu proyecto contiene más que todo soporte proporcionado por gradle.

Tu código estará en `src/main/java/` con `src/main/java/com.tu_usuario.tu_mod`, ejemplo: `*src/main/java/lagbb/lagzoom*` siendo este el directorio principal y `src/main/resources` siendo tu directorio para los recursos (texturas, modelos de bloques, etc.)

## Generar Código fuente de Minecraft
Para esto vamos al gradle (el elefantito a la derecha), desplegamos la carpeta "Tasks" y la carpeta "fabric" y luego ejecutamos con dobleclick "genSourcesWithVineflower"
<br/>
![](https://github.com/LagBB/Lag-Zoom/blob/master/docs/imagenestutorial/gradlevineflower.png)
<br/>

y finalmente recargamos el gradle
<br/>
![](https://github.com/LagBB/Lag-Zoom/blob/master/docs/imagenestutorial/gradlerecarga.png)
