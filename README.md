# ChangeMessageNav
Cambios Arreglados- Arreglados cambios en onViewCreated y onCreateView

-Añadido el componente Navigation el cual se encarga de gestionar la vçnavegacion entre fragmentos y activity
-Añadido plugin navigation.safeargs

Con estos cambios hemos simplificado el codigo anteriormente escrito de forma que conseguimos enviar el message desde SendMessageFragment a ViewMessageFragment
de una forma mas sencilla
Al añadir el plugin safeargs, nos crea automaticamente una clase la cual sera "NuestroFragment"Directions donde se nos habra creado una accion la cual se podra usar para pasar el mensaje de un fragment al otro
Mencionar que tanto el uso del plugin como el uso de bundle es totalmente correcto y se puede usar cualqauiera de los 2.

