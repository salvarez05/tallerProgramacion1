package org.example;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        float [][] estudiantes= new float[50][5];
        agregarEstudiante(estudiantes);
        agregarEstudiante(estudiantes);
        mostrarmatriz(estudiantes);
    }

    private static void mostrarmatriz(float[][] estudiantes) {
        for (int i = 0; i < estudiantes.length ; i++) {
            System.out.println("");
            for (int j = 0; j < 5; j++) {
                System.out.print(estudiantes[i][j]+" ");
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