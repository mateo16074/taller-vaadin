package com.example.application.models;

public class Estudiante implements Persona{
    public String Nombre;
    public int Edad;

    public Estudiante(String nombre, int edad) {
        Nombre = nombre;
        Edad = edad;
    }

    @Override
    public String obtenerNombre() {
        return Nombre;
    }

    @Override
    public int obtenerEdad() {
        return Edad;
    }

    @Override
    public String rol() {
        return "Estudiante";
    }
}
