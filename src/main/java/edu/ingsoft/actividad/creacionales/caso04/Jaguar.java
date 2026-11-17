package edu.ingsoft.actividad.creacionales.caso04;

public class Jaguar {
    private final byte[] sprite;
    private final int vida;
    private final int x;

    public Jaguar(int x) {
        this.sprite = CargadorSprites.cargar("jaguar.png");
        this.vida = 30;
        this.x = x;
    }

    @Override
    public String toString() {
        return "Jaguar(vida=" + vida + ",x=" + x + ",sprite=" + sprite.length / 1024 + "KB)";
    }
}
