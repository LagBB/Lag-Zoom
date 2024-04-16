![](src/main/resources/assets/lagzoom/Mod-Title.png)

Un mod que añade un simple, configurable y hermoso Zoom.

El mod permite una combinación de teclas, por defecto la Z, para que actives y desactives el Zoom.
Tiene hasta 4 niveles de Zoom a través del scroll del mouse así como varios comandos para establecer 
ciertas configuraciones.

Ver [Youtube-LagBB](agregar link al video aqui) para un showcase del mod.

# Aprende Quilt
No soy ningún experto creando mods y mucho menos en Quilt. Tomando en cuenta que es una *Bifurcación* de Fabric, y al no estar completa la documentación
en la Wiki de Quilt, seguro que mezcle unas cosas y no utilice otras que Quilt proporciona para hacer la vida más facil PERO, funciona, sirve y soy feliz.

[tutorial para empezar a hacer tu primer mod con Quilt](https://github.com/LagBB/Lag-Zoom/blob/master/docs/Tutorial_empezar_con_quilt.md)

# Como Usarlo
## Como Instalarlo
Una vez hayas instalado la versión correcta del Quilt Loader, pon la ultima versión de LagZoom con sus dependencias en .minecraft/mods folder.
## Dependencias
Quilt Loader: [Quilt.org](https://quiltmc.org/en/install/client/)<br/>
Quilted Fabric API (QFAPI) and Quilt Standard Librarires (QSL): [Modrinth](https://modrinth.com/mod/qsl)<br/>
Quilted Fabric API (QFAPI) and Quilt Standard Librarires (QSL): [CurseForge](https://www.curseforge.com/minecraft/mc-mods/qsl)

## Como usar el Mod
La tecla por defecto del mod es la "Z".
Pueden re-asignarla a otra telca en
*Opciones > Controles > Teclas...*

## Scroll Zoom
Puedes aumentar y disminuir hasta 4 niveles de Zoom con el scroll del mouse.

## Comandos
`/lagzoom setCinematicCamera true`
- Este comando es para activar o desactivar la cámara cinematografica de Minecraft. (true, false)

`/lagzoom setZoom 10`
- Es el porcentaje a usar en el Zoom. (min:10 - max:80)<br/>
*Nota: Es un porcentaje de tu FOV actual*<br/>
*Ejempo: setZoom = 10 sería TU_FOV(100) * 0.10 dando un total de 10 de FOV. Es decir, al hacer Zoom será como que tuvieras 10 de FOV, que eso es el Zoom basicamente, aumentar tu FOV.*

`/lagzoom setZoomLevelAccordingToScroll true`
- Este comando es para activar o desactivar que tu Zoom por defecto sea el valor que dejaste con el Scroll. (true, false)

# Créditos
@NicoIsLost - [Zoom-o-Matic](https://github.com/NicoIsLost/Zoom-o-Matic) - Quien me inspiró hace mucho a aprender a hacer mi propio zoom (aunque lo dejé xd)
actualmente aprendí a hacer los comandos con su repo y también inspiró el hacer este mod para también enseñar a otras personas, pero totalmente en español.

@LogicalGeekBoy - [LogicalZoom](https://github.com/LogicalGeekBoy/logical_zoom) - De quien tome código (Al que titule GameRendererMixin) para saber como modificar el FOV,
mencionar que su mod es bastante simple y muy "facil de aprender" así que los insto a leerlo.

@DoctorR4t - Gracias a sus videos me tome enserio y retome el aprender a hacer mods. Es por él que usé Quilt y no Fabric.
