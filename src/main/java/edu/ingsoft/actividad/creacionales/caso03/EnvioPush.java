package edu.ingsoft.actividad.creacionales.caso03;

public class EnvioPush {
    public String enviar(Mensaje m) {
        return "PUSH -> " + m.destino + ": " + m.asunto;
    }
}
