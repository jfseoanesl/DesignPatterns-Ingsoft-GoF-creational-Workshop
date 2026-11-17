package edu.ingsoft.actividad.creacionales.caso03;

public class EnvioCorreo {
    private final ConfiguracionBanco cfg;

    public EnvioCorreo(ConfiguracionBanco cfg) {
        this.cfg = cfg;
    }

    public String enviar(Mensaje m) {
        return "EMAIL via " + cfg.servidorCorreo + " -> " + m.destino + ": " + m;
    }
}
