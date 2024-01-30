package com.example.application.models;

public class Profesor implements Persona{
    public String Nombre;
    public int Edad;

    public Profesor(String nombre, int edad) {
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
        return "Profesor";
    }
}
