package edu.ingsoft.actividad.creacionales.caso01;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class PaqueteTuristico {
    private final String destino;
    private final LocalDate inicio;
    private final LocalDate fin;
    private final int viajeros;
    private final Object vuelo;
    private final Object hotel;
    private final Object traslado;
    private final boolean seguro;
    private final String tour;

    public PaqueteTuristico(String destino, LocalDate inicio, LocalDate fin, int viajeros,
                            Object vuelo, Object hotel) {
        this(destino, inicio, fin, viajeros, vuelo, hotel, null);
    }

    public PaqueteTuristico(String destino, LocalDate inicio, LocalDate fin, int viajeros,
                            Object vuelo, Object hotel, Object traslado) {
        this(destino, inicio, fin, viajeros, vuelo, hotel, traslado, false, null);
    }

    public PaqueteTuristico(String destino, LocalDate inicio, LocalDate fin, int viajeros,
                            Object vuelo, Object hotel, Object traslado, boolean seguro,
                            String tour) {
        this.destino = destino;
        this.inicio = inicio;
        this.fin = fin;
        this.viajeros = viajeros;
        this.vuelo = vuelo;
        this.hotel = hotel;
        this.traslado = traslado;
        this.seguro = seguro;
        this.tour = tour;
    }

    public double precio() {
        long noches = ChronoUnit.DAYS.between(inicio, fin);
        double total = 0;
        if (vuelo instanceof VueloAndino v) {
            total += v.tarifa(viajeros);
        } else if (vuelo instanceof VueloInca v) {
            total += v.precioPorPersona() * viajeros;
        }
        if (hotel instanceof HotelCaribe h) {
            total += h.tarifaNoche() * noches;
        } else if (hotel instanceof HotelCusco h) {
            total += h.valorNoche() * noches;
        }
        if (traslado instanceof TrasladoBogota t) {
            total += t.costo();
        } else if (traslado instanceof TrasladoLima t) {
            total += t.valor();
        }
        if (seguro) {
            total += 45_000.0 * viajeros;
        }
        if (tour != null) {
            total += 120_000.0 * viajeros;
        }
        return total;
    }

    public String resumen() {
        return String.format("%s | %s→%s | %d viajero(s) | vuelo=%s hotel=%s traslado=%s "
                + "seguro=%s tour=%s | $%,.0f", destino, inicio, fin, viajeros,
                nombre(vuelo), nombre(hotel), nombre(traslado), seguro ? "sí" : "no",
                tour == null ? "-" : tour, precio());
    }

    private static String nombre(Object o) {
        return o == null ? "-" : o.getClass().getSimpleName();
    }
}
