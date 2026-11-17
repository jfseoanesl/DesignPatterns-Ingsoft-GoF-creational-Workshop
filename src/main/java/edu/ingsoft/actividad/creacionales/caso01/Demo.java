package edu.ingsoft.actividad.creacionales.caso01;

import java.time.LocalDate;

public class Demo {
    public static void main(String[] args) {
        ServicioReservas servicio = new ServicioReservas();
        LocalDate ini = LocalDate.of(2026, 12, 18);
        LocalDate fin = LocalDate.of(2026, 12, 22);

        System.out.println(servicio.reservar("CO", "Cartagena", ini, fin, 2, true, false, null)
                .resumen());
        System.out.println(servicio.reservar("PE", "Cusco", ini, fin, 2, true, true,
                "Machu Picchu").resumen());
        // Llamada directa al constructor con las fechas invertidas: nadie lo detecta
        System.out.println(new PaqueteTuristico("Santa Marta", fin, ini, 1, new VueloAndino(),
                new HotelCaribe()).resumen());
    }
}
