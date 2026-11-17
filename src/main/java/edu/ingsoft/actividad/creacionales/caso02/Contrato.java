package edu.ingsoft.actividad.creacionales.caso02;

import java.util.ArrayList;
import java.util.List;

public class Contrato {
    public String tipo;
    public String partes;
    public String objeto;
    public long valor;
    public List<String> clausulas = new ArrayList<>();

    public void agregarClausula(String texto) {
        clausulas.add(texto);
    }

    @Override
    public String toString() {
        return String.format("%s | %s | %s | $%,d | %d cláusulas: %s", tipo, partes, objeto,
                valor, clausulas.size(), clausulas);
    }
}
