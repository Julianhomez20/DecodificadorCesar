# Se crea una función propia para decifrar el mensaje
# A la función se le dan los parametros necesarios
def decifrado(mensaje_cifrado, veces_caracter):
    # Se crea un string vacio para almacenar cada caracter
    mensaje_decifrado = ""
    # Se usa un ciclo for con una función range
    # A la función range solo se le pasa el parametro stop
    # Los valores default de start y step son funcionales en este caso
    for i in range(len(mensaje_cifrado)):
        # Se recorre el mensaje letra por letra en la posición i
        letra = mensaje_cifrado[i]
        # Se valida que las letras sean mayusculas o minusculas
        mayuscula = letra.isupper()
        minuscula = letra.islower()
        # Se agrega los caracteres sin cambios si no son mayusculas o minusculas
        if not (mayuscula or minuscula):
            mensaje_decifrado += letra
        else:
            # Con la funcion ord se convierte cada letra en un entero
            ascii = ord(letra)
            ascii_base = ord('A')
            if minuscula:
                ascii_base = ord('a')
                # Para descifrar el mensaje se resta el ascii
                # Menos el ascii de la primer letra del alfabeto
                # Y se le resta las veces movidas del caracter
                # Se aplica el modulo 26 para mantenerlo entre el rango del abecedario
            ascii_decifrado = (ascii - ascii_base - veces_caracter) % 26 + ascii_base
            # Se convierte los valores ascii en char
            letra_decifrada = chr(ascii_decifrado)
            mensaje_decifrado += letra_decifrada

    print(mensaje_decifrado)

decifrado(input("Ingrese el mensaje cifrado: "),int(input("Ingrese la cantidad de veces que se movio el caracter: ")))

















