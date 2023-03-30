package org.example;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        float [][] estudiantes= new float[50][5];
        for (int i = 0; i < estudiantes.length; i++) {
            agregarEstudiante(estudiantes);
        }
        estudiantesAprobados(estudiantes);
        estudiantesReprobados(estudiantes);
        estudiantesExamen(estudiantes);
        mostrarDetalle(estudiantes);
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
            if (calcularPromedio(estudiantes,i)<3.6){
                reprobados++;
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
            System.out.println("");
            for (int j = 0; j < 5; j++) {
                System.out.print("Nota "+(j+1)+": "+estudiantes[i][j]+" ");
            }
        }
        System.out.println("");
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