package edu.ingsoft.actividad.creacionales.caso04;

/** Simula la lectura costosa de imágenes desde disco. */
public final class CargadorSprites {
    public static int cargas = 0;

    private CargadorSprites() {
    }

    public static byte[] cargar(String nombre) {
        cargas++;
        return new byte[64 * 1024]; // 64 KB por sprite
    }
}
