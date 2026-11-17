package edu.ingsoft.actividad.creacionales.caso04;

import java.util.ArrayList;
import java.util.List;

public class Nivel {
    public Object fondo;
    public List<Object> obstaculos = new ArrayList<>();
    public List<Object> enemigos = new ArrayList<>();

    public String describir() {
        return fondo + " | obstáculos=" + obstaculos + " | enemigos=" + enemigos.size()
                + " | primero=" + (enemigos.isEmpty() ? "-" : enemigos.get(0));
    }
}
