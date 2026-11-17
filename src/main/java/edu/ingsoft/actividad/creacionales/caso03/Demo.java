package edu.ingsoft.actividad.creacionales.caso03;

public class Demo {
    public static void main(String[] args) {
        Cliente ana = new Cliente("Ana", "EMAIL", "ana@correo.co");
        Cliente luis = new Cliente("Luis", "SMS", "3001234567");
        Cliente sara = new Cliente("Sara", "PUSH", "device-77");

        TransferenciasService trf = new TransferenciasService();
        PrestamosService pre = new PrestamosService();
        System.out.println(trf.notificarTransferencia(ana, 500_000));
        System.out.println(trf.notificarTransferencia(luis, 80_000));
        System.out.println(pre.notificarPago(sara, 7));
        System.out.println(pre.notificarPago(luis, 3));
        System.out.println("Lecturas de configuración: " + ConfiguracionBanco.lecturas);
    }
}
