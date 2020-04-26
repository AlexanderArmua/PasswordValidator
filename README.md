# PasswordValidator
Proyecto del grupo 7 de la materia Diseño de Sistemas - UTN

Validations:
1. Has Numbers.
2. Has Characters.
3. Has a Lowercase Character.
4. Has a Uppercase Character.
5. Has Symbols.
6. Has length >= 8.
7. Has length < 128.
8. Is not on the black list.


## Como agregar nuevas validaciones.
1. En el archivo `PasswordValidator.java`, agregar a la lista `validationsToExecute` un nuevo elemento.
2. Puede ser una expresión regular que validará contra el password o una función Lambda que ejecutará.
3. Recordar ponerle el mensaje que mostrará en caso de error.
4. Fin