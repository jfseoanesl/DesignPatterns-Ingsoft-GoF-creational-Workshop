package edu.ingsoft.actividad.creacionales.caso03;

public class PrestamosService {

    public String notificarPago(Cliente c, int cuota) {
        ConfiguracionBanco cfg = new ConfiguracionBanco();
        Mensaje m = new Mensaje(c.contacto(), "Pago cuota " + cuota, null, null, 1, null,
                "es", false);
        switch (c.canal()) {
            case "EMAIL":
                return new EnvioCorreo(cfg).enviar(m);
            case "PUSH":
                return new EnvioPush().enviar(m);
            default:
                return "(sin notificación para canal " + c.canal() + ")";
        }
    }
}
