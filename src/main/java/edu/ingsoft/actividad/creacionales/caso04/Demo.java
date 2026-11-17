package edu.ingsoft.actividad.creacionales.caso04;

public class Demo {
    public static void main(String[] args) {
        GeneradorNivel g = new GeneradorNivel();
        System.out.println("Selva:    " + g.generar("selva", 300).describir());
        System.out.println("Desierto: " + g.generar("desierto", 300).describir());
        System.out.println("Sprites cargados desde disco: " + CargadorSprites.cargas
                + " (≈ " + CargadorSprites.cargas * 64 / 1024 + " MB leídos)");
    }
}
