import java.util.Scanner;

public class decodificadorcesar {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        System.out.println("Ingresa el mensaje cifrado");
        String mensajeCifrado = lector.next();
        System.out.println("Cuántas veces se movió la letra al cifrar");
        int veces = lector.nextInt();

        String mensajeDescifrado = "";

        // Recorrer cada caracter de el mensaje
        for (int i = 0; i < mensajeCifrado.length(); i++) {
            char letra = mensajeCifrado.charAt(i);
            // Validar que las letras sean mayusculas o minusculas
            boolean minuscula = (letra >= 'a' && letra <= 'z');
            boolean mayuscula = (letra >= 'A' && letra <= 'Z');
            // En caso de no ser una mayuscula o minuscula se agrega al mensaje sin cambios
            if (!(minuscula || mayuscula))
                mensajeDescifrado += letra;
            else {
                // Se obtiene el numero entero de cada letra
                int ascii = (int) letra;
                // Se obtiene el numero de la primer letra en el alfabeto
                int baseAscii = (int) 'a';
                if (mayuscula)
                    baseAscii = (int) 'A';
                /* Se aplica el modulo 26 dos veces para mantener el resultad
                dentro de el rango [0,25], si solo se aplicara una vez el modulo
                26 aun asi el resultado podria ser negativo en caso de que "veces"
                sea muy grande
                 */
                int nuevoAscii = ((ascii - baseAscii - veces) % 26 + 26) % 26 + baseAscii;
                // Se convierte el valor numerico de cada letra en un caracter
                char nuevaLetra = (char) nuevoAscii;
                mensajeDescifrado += nuevaLetra;
            }
        }
        System.out.println("Mensaje descifrado: " + mensajeDescifrado);

    }
}
