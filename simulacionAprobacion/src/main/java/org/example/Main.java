package org.example;
import java.util.Random;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        float [][] estudiantes= new float[50][5];
        menu(estudiantes);
    }

    private static void menu(float[][] estudiantes) {
        int opcion=0;
        System.out.println("Que acción quiere realizar");
        System.out.println("[1] Agregar estudiante");
        System.out.println("[2] Mostrar cantidad de estudiantes que aprueban la asignatura");
        System.out.println("[3] Mostrar cantidad de estudiantes que reprueban la asignatura");
        System.out.println("[4] Mostrar la cantidad de estudiantes que van a examen");
        System.out.println("[5] Mostrar el estado de todos los estudiantes de la asignatura (notas y promedio)");
        System.out.println("[6] Salir");
        while(opcion !=6){
            Scanner teclado = new Scanner(System.in);
            opcion= teclado.nextInt();
            switch (opcion) {
                case 1:
                    agregarEstudiante(estudiantes);
                    System.out.println("Estudiante agregado");
                    break;
                case 2:
                    estudiantesAprobados(estudiantes);
                    break;
                case 3:
                    estudiantesReprobados(estudiantes);
                    break;
                case 4:
                    estudiantesExamen(estudiantes);
                    break;
                case 5:
                    mostrarDetalle(estudiantes);
                    break;
                case 6:
                    System.out.println("Saliendo del menú");
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        }
    }

    private static void estudiantesAprobados(float[][] estudiantes) {
        int aprobados=0;
        for (int i = 0; i < estudiantes.length; i++) {
            if (calcularPromedio(estudiantes,i)>=4.0){
                aprobados++;
            }
        }
        System.out.println("Aprobaron "+aprobados+" estudiantes");
    }
    private static void estudiantesReprobados(float[][] estudiantes) {
        int reprobados=0;
        for (int i = 0; i < estudiantes.length; i++) {
            if (estudiantes[i][0] != 0) {
                if (calcularPromedio(estudiantes,i)<3.6){
                    reprobados++;
                }
            }
        }
        System.out.println("Reprobaron "+reprobados+" estudiantes");
    }
    private static void estudiantesExamen(float[][] estudiantes) {
        int examen=0;
        for (int i = 0; i < estudiantes.length; i++) {
            if (calcularPromedio(estudiantes,i)>=3.6 && calcularPromedio(estudiantes,i)<4.0){
                examen++;
            }
        }
        System.out.println("Hay "+examen+" estudiantes en examen");
    }


    private static float calcularPromedio(float[][] estudiantes, int numero) {
        float promedio= 0.0F;
        promedio = (float) ((estudiantes[numero][0]*0.25)+(estudiantes[numero][1]*0.25)+(estudiantes[numero][2]*0.25)+(estudiantes[numero][3]*0.15)+(estudiantes[numero][4]*0.10));
        return promedio;
    }


    private static void mostrarDetalle(float[][] estudiantes) {
        for (int i = 0; i < estudiantes.length ; i++) {
            if (estudiantes[i][0] != 0) {
                System.out.println("");
                System.out.print("Estudiante "+(i+1)+":");
                for (int j = 0; j < 5; j++) {
                    System.out.print(" Nota "+(j+1)+": "+estudiantes[i][j]+" ");

                }
            }

        }
        System.out.println("");
    }

    private static void mostrarPromedio(float[][] estudiantes) {
        float promedio=0;
        for (int i = 0; i < estudiantes.length; i++) {
            if (estudiantes[i][0] != 0) {
                promedio= calcularPromedio(estudiantes,i);
                System.out.println(promedio);
            }
        }
    }

    public static void agregarEstudiante(float[][] estudiantes) {
        int estudiante = 0;
        for (int i = 0; i < estudiantes.length; i++) {
            if (estudiantes[i][0] == 0) {
                break;
            }
            estudiante++;
        }
        for (int i = 0; i < 5; i++) {
            estudiantes[estudiante][i]=agregarNotaAleatoria(estudiantes);
        }
    }

    public static float agregarNotaAleatoria(float[][] estudiantes) {
        float notaAleatoria;
        Random rnum= new Random();
        notaAleatoria = rnum.nextFloat(1.0F,7.0F);
        return notaAleatoria;
    }



}