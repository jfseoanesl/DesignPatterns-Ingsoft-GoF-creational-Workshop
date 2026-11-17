package edu.ingsoft.actividad.creacionales.caso04;

public class Escorpion {
    private final byte[] sprite;
    private final int vida;
    private final int x;

    public Escorpion(int x) {
        this.sprite = CargadorSprites.cargar("escorpion.png");
        this.vida = 15;
        this.x = x;
    }

    @Override
    public String toString() {
        return "Escorpion(vida=" + vida + ",x=" + x + ",sprite=" + sprite.length / 1024 + "KB)";
    }
}
