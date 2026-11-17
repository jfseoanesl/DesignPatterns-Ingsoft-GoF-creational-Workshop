package edu.ingsoft.actividad.creacionales.caso02;

public class Demo {
    public static void main(String[] args) {
        ServicioContratos contratos = new ServicioContratos();
        ServicioRenovaciones renovaciones = new ServicioRenovaciones();
        new ServicioContratos(); // otro módulo de la aplicación

        Contrato a = contratos.arrendamiento("Inmobiliaria Sol", "Ana Ruiz",
                "Apto 301, Medellín", 2_100_000);
        Contrato b = contratos.compraventa("Luis Mora", "Carlos Díaz", "Vehículo ABC123",
                48_000_000);
        Contrato a2 = renovaciones.renovar(a, 2_250_000);

        System.out.println(a);
        System.out.println(b);
        System.out.println(a2);
        System.out.println("Lecturas del catálogo: " + CatalogoClausulas.lecturas);
    }
}
