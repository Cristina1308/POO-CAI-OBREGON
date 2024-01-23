package com.mycompany.poo_cai_obregon;


import java.security.SecureRandom;
import java.util.Scanner;

public class AprendizajeAritmetico {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SecureRandom random = new SecureRandom();

        String[] respuestasPositivas = {"¡Muy bien!", "¡Excelente!", "¡Buen trabajo!", "¡Sigue así!"};
        String[] respuestasNegativas = {"No está correcto. Por favor intenta de nuevo.", "Incorrecto. Intenta una vez más.", "¡No te rindas aún!", "¡Incorrecto pero sigue intentando!."};

        int respuestasCorrectas = 0;
        int totalPreguntas = 0;

        while (respuestasCorrectas < 10) {
            System.out.println("Elige el nivel de dificultad: (1 para números de UN dígito, 2 para números de DOS dígitos, y así sucesivamente.)");
            int nivel = sc.nextInt();

            System.out.println("Elige el tipo de problema aritmético: (1 para suma, 2 para resta, 3 para multiplicación, 4 para división, 5 para aleatorio)");
            int tipo = sc.nextInt();

            int num1 = random.nextInt((int) Math.pow(10, nivel));
            int num2 = random.nextInt((int) Math.pow(10, nivel));
            int respuestaCorrecta = 0;

            if (tipo == 5) {
                tipo = random.nextInt(4) + 1;
            }

            switch (tipo) {
                case 1:
                    respuestaCorrecta = num1 + num2;
                    System.out.printf("¿Cuánto es %d + %d?%n", num1, num2);
                    break;
                case 2:
                    respuestaCorrecta = num1 - num2;
                    System.out.printf("¿Cuánto es %d - %d?%n", num1, num2);
                    break;
                case 3:
                    respuestaCorrecta = num1 * num2;
                    System.out.printf("¿Cuánto es %d * %d?%n", num1, num2);
                    break;
                case 4:
                    while (num2 == 0) {
                        num2 = random.nextInt((int) Math.pow(10, nivel));
                    }
                    respuestaCorrecta = num1 / num2;
                    System.out.printf("¿Cuánto es %d / %d? (respuesta entera)%n", num1, num2);
                    break;
            }

            int respuestaUsuario = sc.nextInt();
            totalPreguntas++;

            if (respuestaUsuario == respuestaCorrecta) {
                respuestasCorrectas++;
                System.out.println(respuestasPositivas[random.nextInt(4)]);
            } else {
                System.out.println(respuestasNegativas[random.nextInt(4)]);
            }

            double porcentajeCorrecto = ((double) respuestasCorrectas / totalPreguntas) * 100;
            if (porcentajeCorrecto < 75 && totalPreguntas >= 10) {
                System.out.println("Por favor, deberías pedir ayuda adicional a tu instructor.");
            } else if (porcentajeCorrecto >= 75 && respuestasCorrectas == 10) {
                System.out.println("Felicidades, ahora si estás listo para pasar al siguiente nivel!");
                break;
            }
        }
        sc.close();
    }
}

