package edu.ingsoft.actividad.creacionales.caso03;

public class Mensaje {
    final String destino;
    final String asunto;
    final String cuerpo;
    final String adjunto;
    final int prioridad; // 0 baja, 1 normal, 2 alta
    final String plantilla;
    final String idioma;
    final boolean requiereAcuse;

    public Mensaje(String destino, String asunto, String cuerpo, String adjunto, int prioridad,
                   String plantilla, String idioma, boolean requiereAcuse) {
        this.destino = destino;
        this.asunto = asunto;
        this.cuerpo = cuerpo;
        this.adjunto = adjunto;
        this.prioridad = prioridad;
        this.plantilla = plantilla;
        this.idioma = idioma;
        this.requiereAcuse = requiereAcuse;
    }

    @Override
    public String toString() {
        return asunto + " (p" + prioridad + ", " + idioma
                + (adjunto != null ? ", adj=" + adjunto : "") + ")";
    }
}
