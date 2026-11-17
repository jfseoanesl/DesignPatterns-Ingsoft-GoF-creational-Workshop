package edu.ingsoft.actividad.creacionales.caso01;

import java.time.LocalDate;

public class ServicioReservas {

    public PaqueteTuristico reservar(String pais, String destino, LocalDate inicio,
                                     LocalDate fin, int viajeros, boolean conTraslado,
                                     boolean seguro, String tour) {
        Object vuelo;
        if (pais.equals("CO")) {
            vuelo = new VueloAndino();
        } else if (pais.equals("PE")) {
            vuelo = new VueloInca();
        } else {
            throw new IllegalArgumentException("País no soportado: " + pais);
        }

        Object hotel;
        if (pais.equals("CO")) {
            hotel = new HotelCaribe();
        } else {
            hotel = new HotelCusco();
        }

        Object traslado = null;
        if (conTraslado) {
            if (pais.equals("PE") && destino.equals("Lima")) {
                traslado = new TrasladoLima();
            } else {
                traslado = new TrasladoBogota();
            }
        }

        if (!seguro && tour == null) {
            return new PaqueteTuristico(destino, inicio, fin, viajeros, vuelo, hotel, traslado);
        }
        return new PaqueteTuristico(destino, inicio, fin, viajeros, vuelo, hotel, traslado,
                seguro, tour);
    }
}
