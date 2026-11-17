package edu.ingsoft.actividad.creacionales.caso02;

import java.util.LinkedHashMap;
import java.util.Map;

/** Catálogo de cláusulas que el área jurídica mantiene en la base de datos. */
public class CatalogoClausulas {
    public static int lecturas = 0;
    private final Map<String, String> clausulas = new LinkedHashMap<>();

    public CatalogoClausulas() {
        lecturas++; // simula una consulta de ~2 s a la base de datos
        clausulas.put("OBJ", "Objeto del contrato");
        clausulas.put("DUR", "Duración y prórrogas");
        clausulas.put("PAG", "Forma de pago");
        clausulas.put("SER", "Servicios públicos a cargo del arrendatario");
        clausulas.put("SAN", "Saneamiento por evicción");
        clausulas.put("CON", "Confidencialidad");
        clausulas.put("RES", "Resolución de controversias");
    }

    public String texto(String codigo) {
        return clausulas.get(codigo);
    }
}
