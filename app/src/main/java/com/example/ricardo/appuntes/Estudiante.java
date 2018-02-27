package com.example.ricardo.appuntes;

import java.util.ArrayList;

/**
 * Created by ricardo on 19-02-18.
 */

public class Estudiante {
    private int id;
    private String nombre;
    private boolean aprobado;

    public Estudiante(int id, String nombre, boolean aprobado) {
        this.id = id;
        this.nombre = nombre;
        this.aprobado = aprobado;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isAprobado() {
        return aprobado;
    }

    @Override
    public String toString(){
        return nombre;
    }

    public static ArrayList<Estudiante> listaEstudiantes(){
        ArrayList<Estudiante> estudiantes = new ArrayList<>();
        estudiantes.add(new Estudiante(1,"Estudiante 1", false));
        estudiantes.add(new Estudiante(2,"Estudiante 2", true));
        estudiantes.add(new Estudiante(3,"Estudiante 3", false));
        estudiantes.add(new Estudiante(4,"Estudiante 4", true));
        estudiantes.add(new Estudiante(5,"Estudiante 5", false));
        return estudiantes;
    }

}
