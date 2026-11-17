package edu.ingsoft.actividad.creacionales.caso03;

public class EnvioSms {
    private final ConfiguracionBanco cfg;

    public EnvioSms(ConfiguracionBanco cfg) {
        this.cfg = cfg;
    }

    public String enviar(Mensaje m) {
        return "SMS via " + cfg.proveedorSms + " -> " + m.destino + ": " + m.asunto;
    }
}
