package edu.ingsoft.actividad.creacionales.caso03;

public class TransferenciasService {

    public String notificarTransferencia(Cliente c, long monto) {
        ConfiguracionBanco cfg = new ConfiguracionBanco();
        Mensaje m = new Mensaje(c.contacto(), "Transferencia por $" + monto,
                "Hola " + c.nombre(), "comprobante.pdf", 2, "TRF-01", "es", true);
        switch (c.canal()) {
            case "EMAIL":
                return new EnvioCorreo(cfg).enviar(m);
            case "SMS":
                return new EnvioSms(cfg).enviar(m);
            case "PUSH":
                return new EnvioPush().enviar(m);
            default:
                throw new IllegalArgumentException(c.canal());
        }
    }
}
